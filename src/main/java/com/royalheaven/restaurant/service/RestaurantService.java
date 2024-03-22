package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.RecipeEntity;
import com.royalheaven.restaurant.dao.RestaurantEntity;
import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.Recipe;
import com.royalheaven.restaurant.dto.Restaurant;
import com.royalheaven.restaurant.dto.User;

public interface RestaurantService {

    void setRestaurant(Restaurant restaurant);

    Iterable<RestaurantEntity> getRestaurant();
    public void deleteRestaurantById(Long id);
    public RestaurantEntity updateRestaurantById(Long id, Restaurant updatedRestaurant);
}
