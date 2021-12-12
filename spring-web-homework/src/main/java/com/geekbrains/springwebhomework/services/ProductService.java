package com.geekbrains.springwebhomework.services;

import com.geekbrains.springwebhomework.data.Product;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.repositories.ProductRepositories;
import com.geekbrains.springwebhomework.repositories.specifications.ProductSpecifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepositories productRepositories;

    public ProductService(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }


    public Page<Product> find(Integer minPrice, Integer maxPrice,String titlePart, Integer page){
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null){
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(minPrice));
        } if (maxPrice != null){
            spec = spec.and(ProductSpecifications.priceLessOrEqualsThan(maxPrice));
        } if (titlePart != null){
            spec = spec.and(ProductSpecifications.titleLike(titlePart));
        }
        return productRepositories.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public List<Product> findAll(){
        return productRepositories.findAll();
    }

    public Optional<Product> findById(Long id){return productRepositories.findById(id);}

    public void deleteById(Long id){
        productRepositories.deleteById(id);
    }

    @Transactional
    public void changeNumber(Long productId, Integer delta){
        Product product = productRepositories.findById(productId).orElseThrow(() -> new ResourceNotFoundException("It is not possible to change the number of a product. Product not found, id: " + productId));
        product.setNumber(product.getNumber() + delta);
    }

//    public List<Product> findByPriceBetween(Double min, Double max) {
//        return repositories.findAllByPriceBetween(min, max);
//    }

//    public List<Product> findProductsWithALowPrice(Double max){
//        return repositories.findProductsWithALowPrice(max);
//    }
//
//    public List<Product> findProductsWithAHighPrice(Double min){
//        return repositories.findProductsWithAHighPrice(min);
//    }

    public Product save(Product product) {
        return productRepositories.save(product);
    }

    public List<Product> findByPriceBetween(Integer min, Integer max) {
        return productRepositories.findAllByPriceBetween(min, max);
    }
}
