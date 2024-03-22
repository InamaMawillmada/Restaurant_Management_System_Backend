package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dao.RecipeEntity;
import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.dto.Recipe;
import com.royalheaven.restaurant.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    @PostMapping
    public void setRecipe(@RequestBody Recipe recipe){
        recipeService.setRecipe(recipe);
    }

    @GetMapping
    public Iterable<RecipeEntity> getRecipes(){
        return recipeService.getRecipe();
    }

    @PutMapping("/{recipeId}")
    public RecipeEntity updateRecipe(@PathVariable Long recipeId, @RequestBody Recipe updatedRecipe) {
        return recipeService.updateRecipeById(recipeId,updatedRecipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Long id){
        recipeService.deleteRecipeById(id);
    }
}
