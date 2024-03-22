package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.AllergenEntity;
import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dto.Allergen;
import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.service.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/allergen")
public class AllergenController {

    @Autowired
    AllergenService allergenService;

    @PostMapping
    public void setAllergen(@RequestBody Allergen allergen){
        allergenService.setAllergen(allergen);
    }

    @GetMapping
    public Iterable<AllergenEntity> getAllergens(){
        return allergenService.getAllergen();
    }

    @PutMapping("/{allergenId}")
    public AllergenEntity updateAllergen(@PathVariable Long allergenId, @RequestBody Allergen updatedAllergen) {
        return allergenService.updateAllergenById(allergenId,updatedAllergen);
    }

    @DeleteMapping("/{id}")
    public void deleteAllergen(@PathVariable("id") Long id){
        allergenService.deleteAllergenById(id);
    }
}
