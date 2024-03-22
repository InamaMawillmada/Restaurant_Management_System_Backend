package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity,Long> {
}
