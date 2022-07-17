package com.sgg.foodreview.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseDto {
    private Long foodId;
    private String foodNm;
    private String foodDesc;
    private int foodPrice;
    private Long categoryId;
    private Double rating;
    private String newDt;
    private String imgPath;

//    public FoodResponseDto(Food food, String rating){
//        this.foodId = food.getFoodId();
//        this.foodNm = food.getFoodNm();
//        this.foodDesc = food.getFoodDesc();
//        this.foodPrice = food.getFoodPrice();
//        this.rating = rating;
//    }
//
//    public FoodResponseDto(Food food) {
//        this.foodId = food.getFoodId();
//        this.foodNm = food.getFoodNm();
//        this.foodDesc = food.getFoodDesc();
//        this.foodPrice = food.getFoodPrice();
//
//        this.rating = "0.0";
//    }
}
