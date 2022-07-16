package com.sgg.foodreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FOOD")
public class Food extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fd_id", unique = true, nullable = false)
    private Long foodId;

    @Column(name = "category_id")
    private Long categoryId;


    @Column(name = "fd_nm")
    private String foodNm;

    @Column(name = "fd_price")
    private int foodPrice;

    @Column(name = "fd_desc")
    private String foodDesc;

    @Column(name = "img_id")
    private Long imgId;


}
