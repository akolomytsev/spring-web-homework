package com.geekbrains.springwebhomework.controllers;

import com.geekbrains.springwebhomework.data.Product;
import com.geekbrains.springwebhomework.repositories.Repositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private Repositories repositories;

    public MainController(Repositories repositories) {
        this.repositories = repositories;
    }

    @GetMapping("/products")
    public String showProductPage(Model model){
        model.addAttribute("products", repositories.getAllProducts());
        return "table_product_info_page";
    }

    @GetMapping("/products/{id}")
    public String showProductPage(Model model, @PathVariable Long id){
        Product product = repositories.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

}
