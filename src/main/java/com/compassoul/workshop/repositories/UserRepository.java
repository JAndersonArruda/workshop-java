package com.compassoul.workshop.repositories;

import com.compassoul.workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findAllById(Long id);
}
