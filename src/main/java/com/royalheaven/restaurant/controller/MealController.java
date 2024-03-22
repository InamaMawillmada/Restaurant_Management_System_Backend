package com.royalheaven.restaurant.controller;


import com.royalheaven.restaurant.dao.MealEntity;

import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/meal")


public class MealController {
    @Autowired
    MealService mealService;

    @PostMapping
    public void setMeal(@RequestBody Meal meal){
        mealService.setMeal(meal);
    }

    @GetMapping
    public Iterable<MealEntity> getMeals(){
        return mealService.getMeal();
    }

    @PutMapping("/{mealId}")
    public MealEntity updateMeal(@PathVariable Long mealId, @RequestBody Meal updatedMeal) {
        return mealService.updateMealById(mealId,updatedMeal);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        mealService.deleteMealById(id);
    }
}
