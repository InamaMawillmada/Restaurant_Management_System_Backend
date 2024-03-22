package com.royalheaven.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meal {

    private String name;
    private int price;
    private String description;
    private String category;
}
