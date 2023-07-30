package com.scaler.splitwise_feb23.repositories;

import com.scaler.splitwise_feb23.models.Group;
import com.scaler.splitwise_feb23.models.GroupExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpenseRepository extends JpaRepository<GroupExpense, Long> {

    List<GroupExpense> findAllByGroup(Group group);

//    List<GroupExpense> findAllByGroup
}
