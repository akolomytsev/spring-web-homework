package com.geekbrains.springwebhomework.services;

import com.geekbrains.springwebhomework.data.Product;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.repositories.Repositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private Repositories repositories;

    public ProductService(Repositories repositories) {
        this.repositories = repositories;
    }

    public List<Product> findAll(){
        return repositories.findAll();
    }

    public Optional<Product> findById(Long id){return repositories.findById(id);}

    public void deleteById(Long id){
        repositories.deleteById(id);
    }

    @Transactional
    public void changeNumber(Long productId, Integer delta){
        Product product = repositories.findById(productId).orElseThrow(() -> new ResourceNotFoundException("It is not possible to change the price of a product. Product not found, id: " + productId));
        product.setPrice(product.getPrice() + delta);
    }

    public List<Product> findByPriceBetween(Double min, Double max) {
        return repositories.findAllByPriceBetween(min, max);
    }

    public List<Product> findProductsWithALowPrice(Double max){
        return repositories.findProductsWithALowPrice(max);
    }

    public List<Product> findProductsWithAHighPrice(Double min){
        return repositories.findProductsWithAHighPrice(min);
    }
}
