package com.sgg.foodreview.reviewlike.service;

import com.sgg.foodreview.entity.ReviewLike;
import com.sgg.foodreview.reviewlike.dto.ReviewLikeResquestParam;
import com.sgg.foodreview.reviewlike.repository.ReviewLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Service
public class ReviewLikeServiceImpl implements ReviewLikeService {

    @Autowired
    ReviewLikeRepository reviewLikeRepository;

    @Override
    public ResponseEntity<String> reviewLike(ReviewLikeResquestParam resquestParam) {
        Long lkId = resquestParam.getLkId();
        Long memberId = resquestParam.getMemberId();
        String likeYn = resquestParam.getLikeYn();
        try {

            ReviewLike reviewLike = reviewLikeRepository.findTopByLikeId(lkId);
            if (isNull(reviewLike)) {
                return new ResponseEntity<String>("PUT Response", HttpStatus.NO_CONTENT);
            }
            reviewLike = new ReviewLike();
            LocalDateTime now = LocalDateTime.now();

            reviewLikeRepository.save(reviewLike);

            return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("PUT Response", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
