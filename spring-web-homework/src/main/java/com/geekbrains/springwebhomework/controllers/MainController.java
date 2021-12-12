package com.geekbrains.springwebhomework.controllers;

import com.geekbrains.springwebhomework.data.Product;
import com.geekbrains.springwebhomework.dto.ProductDto;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDto> showProductPage(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "max_price", required = false) Integer maxPrice,
            @RequestParam(name = "min_price", required = false) Integer minPrice,
            @RequestParam(name = "title_part", required = false) String titlePart
    ){
        if (page <1){
            page = 1;
        }
        return productService.find(minPrice, maxPrice, titlePart, page).map(
                s -> new ProductDto(s)
        );
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
}
