package com.example.lab2.service.impl;

import com.example.lab2.model.Category;
import com.example.lab2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findAll() {
        return List.of(Category.values());
    }
}
