package com.sgg.foodreview.review.dto;

import lombok.Getter;

@Getter
public class ReviewDto {

    private int rating;

    private String reviewText;

    private Long imgId;

    private Long foodId;

   private Long reviewId;

   private String imgPath;

   private int check;


}
