package com.projectbox.projectbox_backend.repository;

import com.projectbox.projectbox_backend.model.User;
import com.projectbox.projectbox_backend.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByRole(UserRole role);
}
