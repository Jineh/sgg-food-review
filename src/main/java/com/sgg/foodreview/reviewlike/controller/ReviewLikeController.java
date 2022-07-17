package com.sgg.foodreview.reviewlike.controller;

import com.sgg.foodreview.category.dto.CategoryListResponseParam;
import com.sgg.foodreview.entity.ReviewLike;
import com.sgg.foodreview.food.dto.FoodDetailRequestParam;
import com.sgg.foodreview.food.dto.FoodDetailResponseDto;
import com.sgg.foodreview.food.dto.FoodResponseDto;
import com.sgg.foodreview.food.service.FoodService;
import com.sgg.foodreview.review.dto.ReviewsDto;
import com.sgg.foodreview.review.service.ReviewService;
import com.sgg.foodreview.reviewlike.dto.ReviewLikeResquestParam;
import com.sgg.foodreview.reviewlike.service.ReviewLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgg/food-review/review")
public class ReviewLikeController {

    @Autowired
    ReviewLikeService reviewLikeService;

    @PutMapping(value="/like")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<String> reviewLike(@RequestBody ReviewLikeResquestParam resquestParam){

        return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
    }


}
