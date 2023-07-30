package com.scaler.splitwise_feb23.repositories;

import com.scaler.splitwise_feb23.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findById(Long id);

//    List<Group> findAllByMembersContaining(List<User> users);
}
