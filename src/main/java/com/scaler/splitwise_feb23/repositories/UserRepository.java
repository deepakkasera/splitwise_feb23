package com.scaler.splitwise_feb23.repositories;

import com.scaler.splitwise_feb23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

    Optional<User> getUserById(Long id);
}
