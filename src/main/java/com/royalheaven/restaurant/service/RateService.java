package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.OrderEntity;
import com.royalheaven.restaurant.dao.RateEntity;
import com.royalheaven.restaurant.dto.Order;
import com.royalheaven.restaurant.dto.Rate;

public interface RateService {
    void setRate(Rate rate);

    Iterable<RateEntity> getRate();
}
