package com.sgg.foodreview.reviewlike.service;

import com.sgg.foodreview.reviewlike.dto.ReviewLikeResquestParam;
import org.springframework.http.ResponseEntity;

public interface ReviewLikeService {

    ResponseEntity<String> insert(ReviewLikeResquestParam resquestParam);

}
