package com.sgg.foodreview.reviewlike.service;

import com.sgg.foodreview.entity.ReviewLike;
import com.sgg.foodreview.reviewlike.dto.ReviewLikeResquestParam;
import com.sgg.foodreview.reviewlike.repository.ReviewLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class ReviewLikeServiceImpl implements ReviewLikeService {

    @Autowired
    ReviewLikeRepository reviewLikeRepository;

    @Override
    public ResponseEntity<String> insert(ReviewLikeResquestParam resquestParam) {
        Long lkId = resquestParam.getLkId();
        Long rvId = resquestParam.getRvId();
        Long memberId = resquestParam.getMemberId();

        try {
            if(isEmpty(rvId)){
                return new ResponseEntity<String>("PUT Response", HttpStatus.FORBIDDEN);
            }
            ReviewLike reviewLike = null;
            // insert
            if(isEmpty(lkId)){
                reviewLike = new ReviewLike();
                reviewLike.setReviewId(rvId);

                reviewLikeRepository.save(reviewLike);
            }
            // update
            else{
                reviewLike = reviewLikeRepository.findTopByLikeId(lkId);
                if(isNull(reviewLike)){
                    return new ResponseEntity<String>("PUT Response", HttpStatus.NO_CONTENT);
                }
                reviewLikeRepository.delete(reviewLike);
            }

            return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("PUT Response", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
