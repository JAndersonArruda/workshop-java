package com.compassoul.workshop.services;

import com.compassoul.workshop.entities.Order;
import com.compassoul.workshop.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;

    @Autowired  // Optional declaration
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> object = repository.findAllById(id);
        return object.get();
    }
}
