package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.OrderEntity;
import com.royalheaven.restaurant.dto.Order;
import com.royalheaven.restaurant.repository.OrderRepository;
import com.royalheaven.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void setOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setMeal(order.getMeal());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setQuantity(order.getQuantity());
        orderEntity.setCustomer_name(order.getCustomer_name());

        orderRepository.save(orderEntity);
    }

    @Override
    public Iterable<OrderEntity> getOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
