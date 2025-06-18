package com.compassoul.workshop.resources;

import com.compassoul.workshop.entities.Order;
import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.services.OrderService;
import com.compassoul.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    private final OrderService service;

    @Autowired  // Optional declaration
    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order object = service.findById(id);
        return ResponseEntity.ok().body(object);
    }
}
