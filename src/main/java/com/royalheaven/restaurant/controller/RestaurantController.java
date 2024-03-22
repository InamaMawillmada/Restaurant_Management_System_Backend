package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dao.RestaurantEntity;
import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.Meal;
import com.royalheaven.restaurant.dto.Restaurant;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.service.RestaurantService;
import com.royalheaven.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    //Send a restaurant to the database
    @PostMapping
    public void setRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.setRestaurant(restaurant);
    }

    //Get a restaurant from the database
    @GetMapping
    public Iterable<RestaurantEntity> getRestaurants(){
        return restaurantService.getRestaurant();
    }
    @PutMapping("/{restaurantId}")
    public RestaurantEntity updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant updatedRestaurant) {
        return restaurantService.updateRestaurantById(restaurantId,updatedRestaurant);
    }


}
