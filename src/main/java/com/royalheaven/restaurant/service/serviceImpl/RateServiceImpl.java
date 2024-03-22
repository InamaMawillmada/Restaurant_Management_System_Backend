package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.RateEntity;
import com.royalheaven.restaurant.dto.Rate;
import com.royalheaven.restaurant.repository.RateRepository;
import com.royalheaven.restaurant.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    RateRepository rateRepository;

    @Override
    public void setRate(Rate rate) {
        RateEntity rateEntity = new RateEntity();
        rateEntity.setRater_name(rate.getRater_name());
        rateEntity.setReview(rate.getReview());
        rateRepository.save(rateEntity);
    }

    @Override
    public Iterable<RateEntity> getRate() {
        return rateRepository.findAll();
    }
}
