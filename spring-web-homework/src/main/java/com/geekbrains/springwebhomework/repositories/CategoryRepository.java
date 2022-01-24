package com.geekbrains.springwebhomework.repositories;

import com.geekbrains.springwebhomework.entities.Category;
import com.geekbrains.springwebhomework.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select s from Category s where s.title = ?1")
    Optional<Product> findByTitle(String title);
}
