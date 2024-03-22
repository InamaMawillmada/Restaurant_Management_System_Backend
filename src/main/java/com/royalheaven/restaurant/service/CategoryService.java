package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.CategoryEntity;
import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dto.Category;
import com.royalheaven.restaurant.dto.Employee;

public interface CategoryService {
    void setCategory(Category category);

    Iterable<CategoryEntity>  getCategories();

    public void deleteCategoryById(Long id);
}
