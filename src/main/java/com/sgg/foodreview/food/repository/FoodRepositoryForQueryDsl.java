package com.sgg.foodreview.food.repository;

import com.sgg.foodreview.food.dto.FoodResponseDto;

import java.util.List;

public interface FoodRepositoryForQueryDsl {
    List<FoodResponseDto> findAllByOOrderByFdNmAsc();
}
