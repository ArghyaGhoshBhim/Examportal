package com.example.examserver.service.exam;

import com.example.examserver.model.exam.Category;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface CategoryService {

    Category addCategory(Category category);

    Category updateCategory(Category category);

    Set<Category>getCategories();

    Category getCategoryById(Long cId);

    void deleteCategory(Long cId);
}
