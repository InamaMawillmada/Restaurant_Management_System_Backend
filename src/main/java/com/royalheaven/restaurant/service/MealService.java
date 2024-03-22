package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dto.Meal;

public interface MealService {
    void setMeal (Meal meal);
    Iterable<MealEntity> getMeal();
    public void deleteMealById(Long id);
    public MealEntity updateMealById(Long id, Meal updatedMeal);
}
