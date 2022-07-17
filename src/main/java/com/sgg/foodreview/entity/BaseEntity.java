package com.sgg.foodreview.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "new_id")
    private String newId;

    @LastModifiedBy
    @Column(name = "update_id")
    private String updateId;

    @CreatedDate
    @Column(name = "new_dt", updatable = false)
    private LocalDateTime newDt;

    @LastModifiedDate
    @Column(name = "update_dt")
    private LocalDateTime updateDt;


}
