package com.compassoul.workshop.services;

import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired  // Optional declaration
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> object = repository.findAllById(id);
        return object.get();
    }

    public User insert(User object) {
       return repository.save(object);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
