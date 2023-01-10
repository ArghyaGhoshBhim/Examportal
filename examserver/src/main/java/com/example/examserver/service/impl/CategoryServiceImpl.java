package com.example.examserver.service.impl;

import com.example.examserver.dao.exam.CategoryRepository;
import com.example.examserver.model.exam.Category;
import com.example.examserver.service.exam.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategoryById(Long cId) {
        return this.categoryRepository.findById(cId).get();
    }

    @Override
    public void deleteCategory(Long cId) {
        this.categoryRepository.deleteById(cId);
    }
}
