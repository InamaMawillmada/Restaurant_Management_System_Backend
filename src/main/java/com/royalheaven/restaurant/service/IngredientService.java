package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.IngredientEntity;
import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dto.Ingredient;
import com.royalheaven.restaurant.dto.Meal;

public interface IngredientService {

    void setIngredient(Ingredient ingredient);
    Iterable<IngredientEntity> getIngredient();
    public void deleteIngredientById(Long id);
    public IngredientEntity updateIngredientById(Long id, Ingredient updateIngredient);
}
