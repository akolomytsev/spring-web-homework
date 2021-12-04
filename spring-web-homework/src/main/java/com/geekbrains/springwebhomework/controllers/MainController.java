package com.geekbrains.springwebhomework.controllers;

import com.geekbrains.springwebhomework.data.Product;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showProductPage(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }

    @GetMapping("/products/change_number")
    public void changeNumber(@RequestParam Long productId, @RequestParam Integer delta){
        productService.changeNumber(productId, delta);
    }

    @GetMapping("/products/price_between")
    public List<Product> findByPriceBetween(@RequestParam(defaultValue = "0") Double min, @RequestParam(defaultValue = "1000") Double max) {
        return productService.findByPriceBetween(min, max);
    }

    @GetMapping("/products/price_max")
    public List<Product> findProductsWithALowPrice(@RequestParam(defaultValue = "1000") Double max) {
        return productService.findProductsWithALowPrice(max);
    }

    @GetMapping("/products/price_min")
    public List<Product> findProductsWithAHighPrice(@RequestParam(defaultValue = "0") Double min) {
        return productService.findProductsWithAHighPrice(min);
    }
}
