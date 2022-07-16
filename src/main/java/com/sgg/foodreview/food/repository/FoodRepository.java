package com.sgg.foodreview.food.repository;

import com.sgg.foodreview.entity.Food;
import com.sgg.foodreview.food.dto.FoodResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

//    List<FoodResponseDto> findAllByOOrderByFdNmAsc();
}
