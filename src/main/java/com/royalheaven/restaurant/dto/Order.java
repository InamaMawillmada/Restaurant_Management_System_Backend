package com.royalheaven.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String meal;
    private int price;
    private String customer_name;
    private int quantity;
}
