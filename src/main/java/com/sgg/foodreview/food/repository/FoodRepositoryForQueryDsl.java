package com.sgg.foodreview.food.repository;

import com.sgg.foodreview.food.dto.FoodDetailResponseDto;
import com.sgg.foodreview.food.dto.FoodResponseDto;

import java.util.List;

public interface FoodRepositoryForQueryDsl{
    List<FoodResponseDto> foodList(Long categotyId);

    FoodDetailResponseDto findFoodDetailByFoodId(Long id);
}
