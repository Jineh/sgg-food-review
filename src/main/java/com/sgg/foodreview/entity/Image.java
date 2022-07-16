package com.sgg.foodreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "IMAGE")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "img_id", unique = true, nullable = false)
    private Long imgId;

    @Column(name = "img_nm")
    private String imgNm;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "img_extension")
    private String imgExtension;
}
