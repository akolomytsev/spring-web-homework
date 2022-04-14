package com.geekbrains.springwebhomework.core.repositories;

import com.geekbrains.springwebhomework.core.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("select s from Product s where s.title = ?1")
    Optional<Product> findByName(String title);
    List<Product> findAll();
}
