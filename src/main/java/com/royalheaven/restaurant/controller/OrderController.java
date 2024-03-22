package com.royalheaven.restaurant.controller;


import com.royalheaven.restaurant.dao.OrderEntity;
import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.Order;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public void setOrder(@RequestBody Order order){
        orderService.setOrder(order);
    }

    //Get a student from the database
    @GetMapping
    public Iterable<OrderEntity> getOrders(){
        return orderService.getOrder();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
    }

}
