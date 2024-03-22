package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.CategoryEntity;
import com.royalheaven.restaurant.dto.Category;
import com.royalheaven.restaurant.repository.CategoryRepository;
import com.royalheaven.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void setCategory(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        categoryEntity.setDescription(category.getDescription());
        categoryRepository.save(categoryEntity);
    }

    @Override
    public Iterable<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
