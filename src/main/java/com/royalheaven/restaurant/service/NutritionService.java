package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dao.NutritionEntity;
import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.dto.Nutrition;

public interface NutritionService {

    void setNutrition (Nutrition nutrition);
    Iterable<NutritionEntity> getNutrition();
    public void deleteNutritionById(Long id);
    public NutritionEntity updateNutritionById(Long id, Nutrition updatedNutrition);
}
