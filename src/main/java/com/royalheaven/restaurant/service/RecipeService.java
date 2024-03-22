package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dao.RecipeEntity;
import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.dto.Recipe;

public interface RecipeService {
    void setRecipe (Recipe recipe);
    Iterable<RecipeEntity> getRecipe();
    public void deleteRecipeById(Long id);
    public RecipeEntity updateRecipeById(Long id, Recipe updatedRecipe);
}
