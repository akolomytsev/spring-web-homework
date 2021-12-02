package com.geekbrains.springwebhomework.data;

import java.util.List;

public interface Dao {
    Product findById(Long id);
    List<Product> findAll();
    List<Product> findByIdBuyer(Long buyer_id);
    List<Buyer> findByIdProduct(Long product_id);
}
