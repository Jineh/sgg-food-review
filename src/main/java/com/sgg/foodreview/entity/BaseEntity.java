package com.sgg.foodreview.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "new_id")
    private String newId;

    @Column(name = "update_id")
    private String updateId;

    @Column(name = "new_dt")
    private LocalDateTime newDt;

    @Column(name = "update_dt")
    private LocalDateTime updateDt;


}
