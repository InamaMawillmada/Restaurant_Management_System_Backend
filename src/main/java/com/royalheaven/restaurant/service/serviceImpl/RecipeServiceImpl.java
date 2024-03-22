package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.IngredientEntity;
import com.royalheaven.restaurant.dao.RecipeEntity;
import com.royalheaven.restaurant.dto.Recipe;
import com.royalheaven.restaurant.repository.RecipeRepository;
import com.royalheaven.restaurant.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public void setRecipe(Recipe recipe) {
        RecipeEntity recipeEntity=new RecipeEntity();
        recipeEntity.setName(recipe.getName());
        recipeEntity.setStatus(recipe.getStatus());
        recipeEntity.setCost(recipe.getCost());
        recipeEntity.setCategory(recipe.getCategory());

        recipeRepository.save(recipeEntity);
    }

    @Override
    public Iterable<RecipeEntity> getRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public RecipeEntity updateRecipeById(Long id, Recipe updatedRecipe) {
        Optional<RecipeEntity> optionalExistingRecipe = recipeRepository.findById(id);

        if (optionalExistingRecipe.isPresent()) {
            RecipeEntity existingRecipe = optionalExistingRecipe.get();

            existingRecipe.setName(updatedRecipe.getName());
            existingRecipe.setStatus(updatedRecipe.getStatus());
            existingRecipe.setCost(updatedRecipe.getCost());
            existingRecipe.setCategory(updatedRecipe.getCategory());

            return recipeRepository.save(existingRecipe);
        } else {
            System.out.println("Error");
        }
        return null;
    }
}
