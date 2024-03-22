package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.AllergenEntity;
import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dto.Allergen;
import com.royalheaven.restaurant.dto.Meal;

public interface AllergenService {
    void setAllergen (Allergen allergen);
    Iterable<AllergenEntity> getAllergen();
    public void deleteAllergenById(Long id);
    public AllergenEntity updateAllergenById(Long id, Allergen updatedAllergen);
}
