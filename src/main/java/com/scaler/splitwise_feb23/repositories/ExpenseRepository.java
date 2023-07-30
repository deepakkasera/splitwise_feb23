package com.scaler.splitwise_feb23.repositories;

import com.scaler.splitwise_feb23.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// HIbernate ORM
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByPaidByContainingOrOwedByContaining(Long userId, Long userId2);
    // select * from expenses
    // where
    // paidBy contains userID
    // OR
    // hadToPay contains userId
}
