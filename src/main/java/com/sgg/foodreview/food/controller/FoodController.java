package com.sgg.foodreview.food.controller;

import com.sgg.foodreview.food.dto.FoodResponseDto;
import com.sgg.foodreview.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgg/food-review/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping(value="/food-list")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FoodResponseDto> foodList(){
        List<FoodResponseDto> responseDtos = foodService.foodList();
        return responseDtos;
    }
}
