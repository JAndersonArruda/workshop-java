package com.compassoul.workshop.services;

import com.compassoul.workshop.entities.Product;
import com.compassoul.workshop.entities.User;
import com.compassoul.workshop.repositories.ProductRepository;
import com.compassoul.workshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired  // Optional declaration
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> object = repository.findAllById(id);
        return object.get();
    }
}
