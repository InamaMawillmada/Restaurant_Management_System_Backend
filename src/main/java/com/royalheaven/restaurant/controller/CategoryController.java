package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.CategoryEntity;
import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dto.Category;
import com.royalheaven.restaurant.dto.Employee;
import com.royalheaven.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public void setCategory(@RequestBody Category category){
        categoryService.setCategory(category);
    }

    @GetMapping
    public Iterable<CategoryEntity> getCategories(){
        return categoryService.getCategories();
    }

}
