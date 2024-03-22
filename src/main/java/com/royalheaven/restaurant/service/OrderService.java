package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.OrderEntity;
import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.Order;
import com.royalheaven.restaurant.dto.User;

public interface OrderService {
    void setOrder(Order order);

    Iterable<OrderEntity> getOrder();

    public void deleteOrderById(Long id);
}
