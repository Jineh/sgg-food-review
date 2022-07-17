package com.sgg.foodreview.food.service;

import com.sgg.foodreview.food.dto.FoodDetailResponseDto;
import com.sgg.foodreview.food.dto.FoodResponseDto;

import java.util.List;

public interface FoodService {
    List<FoodResponseDto> foodList(Long categotyId);

    FoodDetailResponseDto foodDetail(Long foodId);

}
