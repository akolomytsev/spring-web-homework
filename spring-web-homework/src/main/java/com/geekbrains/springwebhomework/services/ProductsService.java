package com.geekbrains.springwebhomework.services;

import com.geekbrains.springwebhomework.soap.products.Product1;
import com.geekbrains.springwebhomework.dto.ProductDto;
import com.geekbrains.springwebhomework.entities.Product;
import com.geekbrains.springwebhomework.exceptions.ResourceNotFoundException;
import com.geekbrains.springwebhomework.repositories.ProductsRepository;
import com.geekbrains.springwebhomework.repositories.specifications.ProductsSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public static final Function<Product, Product1> functionEntityToSoap = se -> {
        Product1 s = new Product1();
        s.setId(se.getId());
        s.setTitle(se.getTitle());
        s.setPrice(se.getPrice());
        //s.setCategory(se.getCategory().getTitle());
        return s;
    };

    public Page<Product> findAll(Integer minPrice, Integer maxPrice, String partTitle, Integer page) {
        Specification<Product> spec = Specification.where(null);
        if (minPrice != null) {
            spec = spec.and(ProductsSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductsSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }
        if (partTitle != null) {
            spec = spec.and(ProductsSpecifications.titleLike(partTitle));
        }

        return productsRepository.findAll(spec, PageRequest.of(page - 1, 8));
    }

    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }


    public List<Product1> getAllProducts() {
        return productsRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }


    public Product1 getByTitle(String title){
        return productsRepository.findByName(title).map(functionEntityToSoap).get();
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

    public Product save(Product product) {
        return productsRepository.save(product);
    }

    @Transactional
    public Product update(ProductDto productDto) {
        Product product = productsRepository.findById(productDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не найден в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        //product.setCategory(product.getCategory());
        return product;
    }
}
