package com.sgg.foodreview.review.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.querydsl.core.types.dsl.StringTemplate;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ReviewsDto {
    private int rating;

    private String reviewText;

    private Long reviewId;

    private String imgPath;


    private String newDt;

    private Long likeId;


}
