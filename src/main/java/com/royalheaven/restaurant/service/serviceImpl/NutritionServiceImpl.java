package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.NutritionEntity;
import com.royalheaven.restaurant.dao.RecipeEntity;
import com.royalheaven.restaurant.dto.Nutrition;
import com.royalheaven.restaurant.repository.NutritionRepository;
import com.royalheaven.restaurant.service.NutritionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NutritionServiceImpl implements NutritionService {

    @Autowired
    NutritionRepository nutritionRepository;


    @Override
    public void setNutrition(Nutrition nutrition) {
        NutritionEntity nutritionEntity = new NutritionEntity();

        nutritionEntity.setName(nutrition.getName());
        nutritionEntity.setBenefit(nutrition.getBenefit());
        nutritionEntity.setType(nutrition.getType());
        nutritionRepository.save(nutritionEntity);
    }

    @Override
    public Iterable<NutritionEntity> getNutrition() {
        return nutritionRepository.findAll();
    }

    @Override
    public void deleteNutritionById(Long id) {
        nutritionRepository.deleteById(id);
    }

    @Override
    public NutritionEntity updateNutritionById(Long id, Nutrition updatedNutrition) {
        Optional<NutritionEntity> optionalExistingNutrition = nutritionRepository.findById(id);

        if (optionalExistingNutrition.isPresent()) {
            NutritionEntity existingNutrition = optionalExistingNutrition.get();

            existingNutrition.setName(updatedNutrition.getName());
            existingNutrition.setBenefit(updatedNutrition.getBenefit());
            existingNutrition.setType(updatedNutrition.getType());

            return nutritionRepository.save(existingNutrition);
        } else {
            System.out.println("Error");
        }
        return null;
    }
}
