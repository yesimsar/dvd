package com.tzonesoft.data.controller;

import com.tzonesoft.data.model.Category;
import com.tzonesoft.data.repository.CategoryRepository;
import com.tzonesoft.data.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping(path = "{id}")
    public Category getOne(@PathVariable Integer id) {
        return categoryService.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category saveOne(@RequestBody Category category){
        Category newCategory= new Category();
        newCategory.setName(category.getName());
        newCategory.setLastUpdate(LocalDateTime.now());
        return categoryService.save(newCategory);
    }

    @PutMapping(path = "{categoryId}")
    public Category updateOne(@RequestBody Category category, @PathVariable Integer categoryId){
        Category replacedCategory=new Category();
        replacedCategory.setCategoryId(category.getCategoryId());
        replacedCategory.setName(category.getName());
        replacedCategory.setLastUpdate(LocalDateTime.now());
        return categoryService.update(replacedCategory, categoryId);
    }
    @DeleteMapping(path="{categoryId}")
    public void delete(@PathVariable Integer categoryId){
        categoryService.delete(categoryId);
    }
}
