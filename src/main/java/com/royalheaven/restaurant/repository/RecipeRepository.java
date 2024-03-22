package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.RecipeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity,Long> {
}
