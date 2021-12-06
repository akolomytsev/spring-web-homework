package com.geekbrains.springwebhomework.repositories;

import com.geekbrains.springwebhomework.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Repositories extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Integer min, Integer max);

//    @Query("select s from Product s where s.price < :max")
//    List<Product> findProductsWithALowPrice(Double max);
//
//    @Query("select s from Product s where s.price > :min")
//    List<Product> findProductsWithAHighPrice(Double min);
}
