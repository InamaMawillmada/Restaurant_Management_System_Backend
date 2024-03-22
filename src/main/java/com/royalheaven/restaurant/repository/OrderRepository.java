package com.royalheaven.restaurant.repository;

import com.royalheaven.restaurant.dao.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity,Long> {
}
