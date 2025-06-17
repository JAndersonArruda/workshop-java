package com.compassoul.workshop.resources;

import com.compassoul.workshop.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "José", "jose@gmail.com", "(83) 99908-0022", "123456");
        return ResponseEntity.ok().body(user);
    }
}
