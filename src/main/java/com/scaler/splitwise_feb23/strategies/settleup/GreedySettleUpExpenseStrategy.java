package com.scaler.splitwise_feb23.strategies.settleup;

import com.scaler.splitwise_feb23.models.Expense;
import com.scaler.splitwise_feb23.models.Transaction;
import com.scaler.splitwise_feb23.models.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GreedySettleUpExpenseStrategy implements SettleUpExpensesStrategy {

    class Record {
        User user;
        int pendingAmount;

        Record(User user, int pendingAmount) {
            this.user = user;
            this.pendingAmount = pendingAmount;
        }
    }

    @Override
    public List<Transaction> settle(List<Expense> expenses) {
        Map<User, Integer> extraMoney = new HashMap<>();
        //In extraMoney map, we'll store the amount which is paid extra or lesser by each user.

        for (Expense expense: expenses) {
            for (User user: expense.getPaidBy().keySet()) {
                if (!extraMoney.containsKey(user)) {
                    extraMoney.put(user, 0);
                }

                extraMoney.put(user, extraMoney.get(user) + expense.getPaidBy().get(user));
            }

            for (User user: expense.getHadToPay().keySet()) {
                if (!extraMoney.containsKey(user)) {
                    extraMoney.put(user, 0);
                }

                extraMoney.put(user, extraMoney.get(user) - expense.getHadToPay().get(user));
            }
        }

        Queue<Record> negativeQueue = new ArrayDeque<>(); // This queue will contain the amount had to pay by the users.
        Queue<Record> positiveQueue = new ArrayDeque<>(); // This queue will contain the amount paid extra by the users.

        for (User user: extraMoney.keySet()) {
            if (extraMoney.get(user) < 0) {
                negativeQueue.add(new Record(user, extraMoney.get(user)));
            } else if (extraMoney.get(user) > 0) {
                positiveQueue.add(new Record(user, extraMoney.get(user)));
            }
        }

        List<Transaction> transactions = new ArrayList<>();

        //negative(A) = -150 -> -150+100 = -50
        //positive(B) = +100 -> 0
        //Transaction  : A  -----> B : 100

        //negative(A) = - 80 -> 0
        //positive(B) = +100
        //Transaction : A ---------> B : 80
        while (!positiveQueue.isEmpty() && !negativeQueue.isEmpty()) {
            Record firstNegative = negativeQueue.remove(); // user paid lesser.
            Record firstPostive = positiveQueue.remove(); // user paid extra.

            if (firstPostive.pendingAmount > Math.abs(firstNegative.pendingAmount)) {
                transactions.add(
                        new Transaction(firstNegative.user.toDto(), firstPostive.user.toDto(), Math.abs(firstNegative.pendingAmount))
                );
                positiveQueue.add(new Record(firstPostive.user, firstPostive.pendingAmount - Math.abs(firstNegative.pendingAmount)));
            } else {
                transactions.add(
                        new Transaction(firstNegative.user.toDto(), firstPostive.user.toDto(), firstPostive.pendingAmount)
                );
                negativeQueue.add(new Record(firstNegative.user, firstNegative.pendingAmount + firstPostive.pendingAmount));
            }
        }

        return transactions;
    }
}

/*
Expense-1

for every user : paidBy - hadToPay

paidBy Map - A:500, B:500
hadToPay - A:250, B:250, C:250, D:250

extraMoney : A: 0 + 500 - 250, B : 0 + 500 - 250,
             C : 0 - 250, D : 0 -250

extraMoney - A:250, B:250, C:-250, D:-250
A -> paid 250 Rs extra
B -> paid 250 Rs extra
C -> paid 250 Rs lesser
D -> paid 250 Rs lesser.
 */
