package com.geekbrains.springwebhomework.repositories.specifications;

import com.geekbrains.springwebhomework.data.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(Integer price){
        return (root, criteriaQuery, criteriaBuilder)-> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }


    public static Specification<Product> priceLessOrEqualsThan(Integer price){
        return (root, criteriaQuery, criteriaBuilder)-> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> titleLike(String titlePart){
        return (root, criteriaQuery, criteriaBuilder)-> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

}
