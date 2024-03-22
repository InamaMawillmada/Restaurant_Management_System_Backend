package com.royalheaven.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recipe {
    private String name;
    private String category;
    private String status;
    private int cost;

}
