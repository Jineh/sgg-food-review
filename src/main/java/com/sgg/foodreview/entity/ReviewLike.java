package com.sgg.foodreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "REVIEW_LIKE")
public class ReviewLike extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lk_id", unique = true, nullable = false)
    private Long likeId;

    @Column(name = "rv_id")
    private Long reviewId;
}
