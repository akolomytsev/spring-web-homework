package com.geekbrains.springwebhomework.controllers;

import com.geekbrains.springwebhomework.data.Product;
import com.geekbrains.springwebhomework.repositories.Repositories;
import com.geekbrains.springwebhomework.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
//
//    private ProductService productService;
//
//    public MainController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @GetMapping("/products")
//    public List<Product> showProductPage(){
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/products/delete/{id}")
//    public void deleteById(@PathVariable Long id){
//        productService.deleteById(id);
//    }
//
//    @GetMapping("/products/change_number")
//    public void changeNumber(@RequestParam Long productId, @RequestParam Integer delta){
//        productService.changeNumber(productId, delta);
//    }
}
