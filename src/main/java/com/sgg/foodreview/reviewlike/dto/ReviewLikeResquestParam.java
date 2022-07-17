package com.sgg.foodreview.reviewlike.dto;

import lombok.Data;

@Data
public class ReviewLikeResquestParam {
    private Long lkId;
    private Long memberId;
    private String likeYn;
}
