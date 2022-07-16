package com.sgg.foodreview.food.dto;

import com.sgg.foodreview.review.dto.ReviewDto;
import com.sgg.foodreview.review.dto.ReviewsDto;
import lombok.Data;

import java.util.List;

@Data
public class FoodDetailResponseDto {
    
    private Long foodId;
    private String foodNm;
    private int foodPrice;
    private String foodDesc;
    private Double rating;
    private Long categoryId;
    private String categoryNm;
    // 리뷰 리스트

    List<ReviewsDto> reviewDtoList;
}
