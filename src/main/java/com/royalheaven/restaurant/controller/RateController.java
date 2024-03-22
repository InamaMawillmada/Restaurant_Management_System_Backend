package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.RateEntity;
import com.royalheaven.restaurant.dao.UserEntity;
import com.royalheaven.restaurant.dto.Rate;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/rate")
public class RateController {
    @Autowired
    RateService rateService;

    @PostMapping
    public void setRate(@RequestBody Rate rate){
        rateService.setRate(rate);
    }

    @GetMapping
    public Iterable<RateEntity> getRates(){
        return rateService.getRate();
    }
}
