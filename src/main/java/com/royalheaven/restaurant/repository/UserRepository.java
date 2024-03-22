package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
    //If user exist
    Optional<UserEntity> findByName(String name);

    //Search User
    Iterable<UserEntity> findAllByName (String name);
}
