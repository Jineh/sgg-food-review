package com.sgg.foodreview.food.service;

import com.sgg.foodreview.food.dto.FoodDetailResponseDto;
import com.sgg.foodreview.food.dto.FoodResponseDto;
import com.sgg.foodreview.food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    FoodRepository foodRepository;

    @Override
    @Transactional
    public List<FoodResponseDto> foodList(){
        return foodRepository.foodList();
    }

    @Override
    public FoodDetailResponseDto foodDetail(Long foodId) {
        return foodRepository.findFoodDetailByFoodId(foodId);
    }


}
