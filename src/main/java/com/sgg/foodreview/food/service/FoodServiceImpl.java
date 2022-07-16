package com.sgg.foodreview.food.service;

import com.sgg.foodreview.food.dto.FoodResponseDto;
import com.sgg.foodreview.food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    FoodRepository foodRepository;

    @Transactional
    @Override
    public List<FoodResponseDto> foodList(){

        String rating = "4.5";

        return foodRepository.findAll()
                .stream()
                .map(FoodResponseDto::new)
                .collect(Collectors.toList());
    }


}
