package com.geekbrains.springwebhomework.repositories;

import com.geekbrains.springwebhomework.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Repositories {
//    private List<Product> products;
//
//    @PostConstruct
//    public void init(){
//        products = new ArrayList<>(List.of(
//                new Product(1L, "Bread", 42.0, 1),
//                new Product(2L, "Milk", 62.0, 1),
//                new Product(3L, "Butter", 142.0, 1),
//                new Product(4L, "Fish", 890.0, 1),
//                new Product(5L, "Pasta", 75.0, 1),
//                new Product(6L, "Chicken", 240.0, 1),
//                new Product(7L, "Rice", 70.0, 1),
//                new Product(8L, "Tomato", 220.0, 1),
//                new Product(9L, "Apple", 160.0, 1),
//                new Product(10L, "Orange", 220.0, 1)
//        ));
//    }
//
//    public List<Product> getAllProducts(){
//        return Collections.unmodifiableList(products);
//    }
//
//    public void deleteById(Long id){
//        products.removeIf(s -> s.getId().equals(id));
//    }
//
//    public Product findById(Long id){
//        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
//    }
}
