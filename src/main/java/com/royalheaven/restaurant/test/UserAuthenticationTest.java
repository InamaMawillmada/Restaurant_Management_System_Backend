package com.royalheaven.restaurant.test;

import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.repository.UserRepository;

import com.royalheaven.restaurant.service.serviceImpl.UserServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UserAuthenticationTest {

    @Test
    void testAuthenticateUserValidCredentials(){
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

        int id = 5;
        String userName = "testUser";
        String userPassword = "testPassword";
        String userEmail = "testEmail@gmail.com";
        User user = new User(userName,userEmail,userPassword);
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        UserEntity dbUser = new UserEntity(id,userName, userEmail , bCrypt.encode(userPassword));

        when(userRepository.findByName(user.getName())).thenReturn(Optional.of(dbUser));

        boolean result = userService.authenticateUser(user);

        assertTrue(result);
    }

    @Test
    void testAuthenticateUser_InvalidPassword(){
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

        int id = 5;
        String userName = "testUser";
        String userPassword = "testPassword";
        String userEmail = "testEmail@gmail.com";
        User user = new User(userName,userEmail,userPassword);
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        UserEntity dbUser = new UserEntity(id,userName, userEmail , bCrypt.encode("userTestPassword"));

        when(userRepository.findByName(user.getName())).thenReturn(Optional.of(dbUser));

        boolean result = userService.authenticateUser(user);

        assertFalse(result);
    }

    @Test
    void testAuthenticateUser_UserNotFound(){
        UserRepository userRepository = mock(UserRepository.class);
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserRepository(userRepository);

        String userName = "testUser";
        String userPassword = "testPassword";
        String userEmail = "testEmail@gmail.com";
        User user = new User(userName,userEmail,userPassword);

        when(userRepository.findByName(user.getName())).thenReturn(Optional.empty());

        boolean result = userService.authenticateUser(user);

        assertFalse(result);
    }
}
