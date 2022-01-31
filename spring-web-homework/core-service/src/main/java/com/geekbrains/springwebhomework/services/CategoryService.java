package com.geekbrains.springwebhomework.services;


import com.geekbrains.springwebhomework.entities.Category;
import com.geekbrains.springwebhomework.repositories.CategoryRepository;
import com.geekbrains.springwebhomework.soap.categories.Category1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CategoryService {
//    private final CategoryRepository categoryRepository;
//
//    public static final Function<Category, Category1> functionEntityToSoap = ge -> {
//        Category1 c = new Category1();
//        c.setTitle(c.getTitle());
//        ge.getProducts().stream().map(ProductsService.functionEntityToSoap).forEach(s ->c.getProduct1().add(s));
//        return c;
//    };

//    public Category1 getByTitle(String title) {
//        return categoryRepository.findByTitle(title).map(functionEntityToSoap).get();
//    }
}
