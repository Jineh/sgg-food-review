package com.sgg.foodreview.reviewlike.controller;

import com.sgg.foodreview.reviewlike.dto.ReviewLikeResquestParam;
import com.sgg.foodreview.reviewlike.service.ReviewLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sgg/food-review/review-like")
public class ReviewLikeController {

    @Autowired
    ReviewLikeService reviewLikeService;

    @PutMapping(value="/upsert")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<String> upsert(@RequestBody ReviewLikeResquestParam resquestParam){

        return reviewLikeService.upsert(resquestParam);
    }


}
