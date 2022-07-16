package com.sgg.foodreview.food.dto;

import lombok.Data;

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
}
