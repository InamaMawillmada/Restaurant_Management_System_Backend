package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.MealEntity;
import com.royalheaven.restaurant.dao.RestaurantEntity;
import com.royalheaven.restaurant.dto.Restaurant;
import com.royalheaven.restaurant.repository.RestaurantRepository;
import com.royalheaven.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public void setRestaurant(Restaurant restaurant) {
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setName(restaurant.getName());
        restaurantEntity.setLocation(restaurant.getLocation());
        restaurantEntity.setOpenHours(restaurant.getOpenHours());
        restaurantRepository.save(restaurantEntity);
    }

    @Override
    public Iterable<RestaurantEntity> getRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public RestaurantEntity updateRestaurantById(Long id, Restaurant updatedRestaurant) {
        Optional<RestaurantEntity> optionalExistingRestaurant = restaurantRepository.findById(id);

        if (optionalExistingRestaurant.isPresent()){
            RestaurantEntity existingRestaurant = optionalExistingRestaurant.get();

            existingRestaurant.setName(updatedRestaurant.getName());
            existingRestaurant.setLocation(updatedRestaurant.getLocation());
            existingRestaurant.setOpenHours(updatedRestaurant.getOpenHours());

            return restaurantRepository.save(existingRestaurant);
        }
        else {
            System.out.println("Error");
        }
        return null;
    }
}
