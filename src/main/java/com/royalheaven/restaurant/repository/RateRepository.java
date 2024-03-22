package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.RateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<RateEntity,Long> {
}
