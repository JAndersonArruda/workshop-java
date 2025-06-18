package com.compassoul.workshop.repositories;

import com.compassoul.workshop.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findAllById(Long id);
}
