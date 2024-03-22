package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dao.IngredientEntity;
import com.royalheaven.restaurant.dto.Ingredient;
import com.royalheaven.restaurant.repository.IngredientRepository;
import com.royalheaven.restaurant.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public void setIngredient(Ingredient ingredient) {
        IngredientEntity ingredientEntity = new IngredientEntity();

        ingredientEntity.setName(ingredient.getName());
        ingredientEntity.setPrice(ingredient.getPrice());
        ingredientEntity.setCategory(ingredient.getCategory());
        ingredientEntity.setNutrition(ingredient.getNutrition());
        ingredientEntity.setQuantity(ingredient.getQuantity());

        ingredientRepository.save(ingredientEntity);
    }

    @Override
    public Iterable<IngredientEntity> getIngredient() {
        return ingredientRepository.findAll();
    }

    @Override
    public void deleteIngredientById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public IngredientEntity updateIngredientById(Long id, Ingredient updateIngredient) {
        Optional<IngredientEntity> optionalExistingIngredient = ingredientRepository.findById(id);

        if (optionalExistingIngredient.isPresent()) {
            IngredientEntity existingIngredient = optionalExistingIngredient.get();

            existingIngredient.setName(updateIngredient.getName());
            existingIngredient.setQuantity(updateIngredient.getQuantity());
            existingIngredient.setPrice(updateIngredient.getPrice());
            existingIngredient.setNutrition(updateIngredient.getNutrition());
            existingIngredient.setCategory(updateIngredient.getCategory());

            return ingredientRepository.save(existingIngredient);
        } else {
            System.out.println("Error");
        }
        return null;
    }
}
