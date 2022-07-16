package com.sgg.foodreview.food.dto;

import com.sgg.foodreview.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FoodResponseDto {
    private final Long foodId;
    private final String foodNm;
    private final String foodDesc;
    private final Integer foodPrice;
    private final String rating;

    public FoodResponseDto(Food food, String rating){
        this.foodId = food.getFoodId();
        this.foodNm = food.getFoodNm();
        this.foodDesc = food.getFoodDesc();
        this.foodPrice = food.getFoodPrice();
        this.rating = rating;
    }

    public FoodResponseDto(Food food) {
        this.foodId = food.getFoodId();
        this.foodNm = food.getFoodNm();
        this.foodDesc = food.getFoodDesc();
        this.foodPrice = food.getFoodPrice();

        this.rating = "0.0";
    }
}
