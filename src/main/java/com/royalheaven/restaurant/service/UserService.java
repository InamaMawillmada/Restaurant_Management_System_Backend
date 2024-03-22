package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.User;


public interface UserService {
    void setUser(User user);


    Iterable<UserEntity> getUser();



    public boolean authenticateUser(User user);

    //Search User
    Iterable<UserEntity> getUsersByName(String name);


}
