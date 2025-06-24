package com.compassoul.workshop.services;

import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.repositories.UserRepository;

import com.compassoul.workshop.services.exceptions.DatabaseException;
import com.compassoul.workshop.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return object.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User object) {
       return repository.save(object);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User object) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, object);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User object) {
        entity.setName(object.getName());
        entity.setEmail(object.getEmail());
        entity.setPhone(object.getPhone());
    }
}
