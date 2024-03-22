package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.IngredientEntity;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<IngredientEntity,Long> {
}
