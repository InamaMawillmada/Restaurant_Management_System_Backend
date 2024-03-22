package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dao.IngredientEntity;
import com.royalheaven.restaurant.dto.Employee;
import com.royalheaven.restaurant.dto.Ingredient;
import com.royalheaven.restaurant.service.EmployeeService;
import com.royalheaven.restaurant.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @PostMapping
    public void setIngredient(@RequestBody Ingredient ingredient){
        ingredientService.setIngredient(ingredient);
    }

    @GetMapping
    public Iterable<IngredientEntity> getIngredients(){
        return ingredientService.getIngredient();
    }

    @PutMapping("/{ingredientId}")
    public IngredientEntity updateIngredient(@PathVariable Long ingredientId, @RequestBody Ingredient updatedIngredient) {
        return ingredientService.updateIngredientById(ingredientId,updatedIngredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable("id") Long id){
        ingredientService.deleteIngredientById(id);
    }
}
