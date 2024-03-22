package com.royalheaven.restaurant.controller;
import com.royalheaven.restaurant.dao.NutritionEntity;

import com.royalheaven.restaurant.dto.Nutrition;
import com.royalheaven.restaurant.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/nutrition")

public class NutritionController {

    @Autowired
    NutritionService nutritionService;

    @PostMapping
    public void setNutrition(@RequestBody Nutrition nutrition){
        nutritionService.setNutrition(nutrition);
    }
    @GetMapping
    public Iterable<NutritionEntity> getNutrition(){
        return nutritionService.getNutrition();
    }

    @DeleteMapping("/{id}")
    public void deleteNutrition(@PathVariable("id") Long id){
        nutritionService.deleteNutritionById(id);
    }

    @PutMapping("/{nutritionId}")
    public NutritionEntity updateNutrition(@PathVariable Long nutritionId, @RequestBody Nutrition updatedNutrition) {
        return nutritionService.updateNutritionById(nutritionId,updatedNutrition);
    }
}
