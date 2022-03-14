package com.tzonesoft.data.service;

import com.tzonesoft.data.model.Category;
import com.tzonesoft.data.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
    public Category getOne(Integer categoryId) {
        return categoryRepository.getById(categoryId);
    }
    public Category save(Category newCategory) {
        return categoryRepository.save(newCategory);
    }
    public Category update(Category replacedCategory, Integer categoryId) {
        Category one = getOne(categoryId);
        return categoryRepository.save(replacedCategory);
    }
    public void delete(Integer categoryId) {
        Category category = getOne(categoryId);
        categoryRepository.delete(category);
    }
}
