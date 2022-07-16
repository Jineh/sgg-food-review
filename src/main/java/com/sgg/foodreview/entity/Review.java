package com.sgg.foodreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "REVIEW")
public class Review extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rv_id", unique = true, nullable = false)
    private Long reviewId;

    @Column(name = "fd_id")
    private Long foodId;

}
