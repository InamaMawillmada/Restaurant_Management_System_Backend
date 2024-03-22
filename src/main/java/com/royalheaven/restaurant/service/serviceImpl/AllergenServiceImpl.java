package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.AllergenEntity;
import com.royalheaven.restaurant.dao.RecipeEntity;
import com.royalheaven.restaurant.dto.Allergen;
import com.royalheaven.restaurant.repository.AllergenRepository;
import com.royalheaven.restaurant.service.AllergenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AllergenServiceImpl implements AllergenService {

    @Autowired
    AllergenRepository allergenRepository;

    @Override
    public void setAllergen(Allergen allergen) {
        AllergenEntity allergenEntity = new AllergenEntity();
        allergenEntity.setName(allergen.getName());
        allergenEntity.setCause(allergen.getCause());
        allergenRepository.save(allergenEntity);
    }

    @Override
    public Iterable<AllergenEntity> getAllergen() {
        return allergenRepository.findAll();
    }

    @Override
    public void deleteAllergenById(Long id) {
        allergenRepository.deleteById(id);
    }

    @Override
    public AllergenEntity updateAllergenById(Long id, Allergen updatedAllergen) {
        Optional<AllergenEntity> optionalExistingAllergen = allergenRepository.findById(id);

        if (optionalExistingAllergen.isPresent()) {
            AllergenEntity existingAllergen = optionalExistingAllergen.get();

            existingAllergen.setName(updatedAllergen.getName());
           existingAllergen.setCause(updatedAllergen.getCause());


            return allergenRepository.save(existingAllergen);
        } else {
            System.out.println("Error");
        }
        return null;
    }
}
