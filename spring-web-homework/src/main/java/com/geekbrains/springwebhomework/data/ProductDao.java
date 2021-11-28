package com.geekbrains.springwebhomework.data;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product saveOrUpdate(Product product);

}
