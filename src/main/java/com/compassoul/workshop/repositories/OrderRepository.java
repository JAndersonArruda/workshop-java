package com.compassoul.workshop.repositories;

import com.compassoul.workshop.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findAllById(Long id);
}
