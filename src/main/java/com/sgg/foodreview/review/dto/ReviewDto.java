package com.sgg.foodreview.review.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {

    private int rating;

    private String reviewText;

    private Long imgId;

    private Long foodId;

   private Long reviewId;

   private String imgPath;

   private int check;


}
