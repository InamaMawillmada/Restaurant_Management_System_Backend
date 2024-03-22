package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.repository.UserRepository;
import com.royalheaven.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    //Setting the user repository for unit test
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    UserRepository userRepository;

    //Register a User
    @Override
    public void setUser(User user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String encryptedPassword = bcrypt.encode(user.getPassword());

        UserEntity userEntity=new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(encryptedPassword);
        userRepository.save(userEntity);
    }

    //View users
    @Override
    public Iterable<UserEntity> getUser() {
        return userRepository.findAll();
    }


    //Authenticate User
    @Override
    public boolean authenticateUser(User user) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

        Optional<UserEntity> opUser = userRepository.findByName(user.getName());
        if (opUser.isPresent()) {
            UserEntity dbUser = opUser.get();
            if (bcrypt.matches(user.getPassword(), dbUser.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    //Search a user by name
    @Override
    public Iterable<UserEntity> getUsersByName(String name) {
        return userRepository.findAllByName(name);
    }
}
