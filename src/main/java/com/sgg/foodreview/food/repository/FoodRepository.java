package com.sgg.foodreview.food.repository;

import com.sgg.foodreview.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

//    List<FoodResponseDto> findAllByOOrderByFdNmAsc();
}
