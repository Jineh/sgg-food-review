package com.sgg.foodreview.review.service;

import com.sgg.foodreview.entity.Review;
import com.sgg.foodreview.review.dto.ReviewDto;
import com.sgg.foodreview.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public void regReview(ReviewDto reviewDto){


        log.info("파일 저장 regReview-----");
        Review review = new Review();
        review.setReviewStar(reviewDto.getReviewStar());
        review.setReviewText(reviewDto.getReviewText());

        reviewRepository.save(review);

    }

    public String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
