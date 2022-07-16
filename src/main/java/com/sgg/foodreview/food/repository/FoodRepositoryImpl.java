package com.sgg.foodreview.food.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FoodRepositoryImpl {

    @PersistenceContext
    EntityManager em;
}
