package com.sgg.foodreview.food.repository;

import com.sgg.foodreview.food.dto.FoodResponseDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FoodRepositoryImpl {

    @PersistenceContext
    EntityManager em;
}
