package com.sgg.foodreview.food.controller;

import com.sgg.foodreview.food.dto.FoodDetailRequestParam;
import com.sgg.foodreview.food.dto.FoodDetailResponseDto;
import com.sgg.foodreview.food.dto.FoodResponseDto;
import com.sgg.foodreview.food.service.FoodService;
import com.sgg.foodreview.review.dto.ReviewDto;
import com.sgg.foodreview.review.dto.ReviewsDto;
import com.sgg.foodreview.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgg/food-review/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @Autowired
    ReviewService reviewService;

    @GetMapping(value="/food-list")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FoodResponseDto> foodList(){
        List<FoodResponseDto> responseDtos = foodService.foodList();
        return responseDtos;
    }

    @PostMapping(value="/food-dtl")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public FoodDetailResponseDto foodList(@RequestBody FoodDetailRequestParam foodId){

        Long fdId = Long.valueOf(foodId.getFoodId());
        FoodDetailResponseDto responseDtos = foodService.foodDetail(fdId);
        List<ReviewsDto> reviewDtoList = reviewService.getReviewList(fdId);

        responseDtos.setReviewDtoList(reviewDtoList);
        return responseDtos;
    }
}
