package com.sgg.foodreview.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="test")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Test {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    private String category_nm;
    private String category_desc;
    private String new_id;
    private String update_id;
    private LocalDateTime new_dt;
    private LocalDateTime update_dt;
}
