package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.repository.MealRepository;
import com.royalheaven.restaurant.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    MealRepository mealRepository;

    @Override
    public void setMeal(Meal meal) {
        MealEntity mealEntity = new MealEntity();
        mealEntity.setName(meal.getName());
        mealEntity.setPrice(meal.getPrice());
        mealEntity.setCategory(meal.getCategory());
        mealEntity.setDescription(meal.getDescription());
        mealRepository.save(mealEntity);
    }

    @Override
    public Iterable<MealEntity> getMeal() {
        return mealRepository.findAll();
    }

    @Override
    public void deleteMealById(Long id) {
        mealRepository.deleteById(id);
    }

    @Override
    public MealEntity updateMealById(Long id, Meal updatedMeal) {
        Optional<MealEntity> optionalExistingMeal = mealRepository.findById(id);

        if (optionalExistingMeal.isPresent()){
            MealEntity existingMeal = optionalExistingMeal.get();

            existingMeal.setName(updatedMeal.getName());
            existingMeal.setPrice(updatedMeal.getPrice());
            existingMeal.setDescription(updatedMeal.getDescription());
            existingMeal.setCategory(updatedMeal.getCategory());

            return mealRepository.save(existingMeal);
        }
        else {
            System.out.println("Error");
        }
        return null;
    }
}
