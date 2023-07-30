package com.scaler.splitwise_feb23.strategies.settleup;

import com.scaler.splitwise_feb23.models.Expense;
import com.scaler.splitwise_feb23.models.Transaction;

import java.util.List;

public interface SettleUpExpensesStrategy {
    List<Transaction> settle(List<Expense> expenses);
}
