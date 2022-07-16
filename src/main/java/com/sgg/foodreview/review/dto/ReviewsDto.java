package com.sgg.foodreview.review.dto;

import lombok.Getter;

@Getter
public class ReviewsDto {
    private int rating;

    private String reviewText;

    private Long reviewId;

    private String imgPath;
}
