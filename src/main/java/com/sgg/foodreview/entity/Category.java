package com.sgg.foodreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CATEGORY")
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", unique = true, nullable = false)
    private Long categoryId;

    @Column(name = "category_nm")
    private String categoryNm;

    @Column(name = "category_desc")
    private String categoryDesc;
}
