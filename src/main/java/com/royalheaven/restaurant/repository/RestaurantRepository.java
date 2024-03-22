package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity,Long> {
}
