package com.sgg.foodreview.reviewlike.repository;

import com.sgg.foodreview.entity.ReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long>, ReivewLikeRepositoryForQueryDsl {
    ReviewLike findTopByLikeId(Long var1);
}
