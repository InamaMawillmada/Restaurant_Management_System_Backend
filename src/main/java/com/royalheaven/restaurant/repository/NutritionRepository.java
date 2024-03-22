package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.NutritionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionRepository extends CrudRepository<NutritionEntity,Long> {
}
