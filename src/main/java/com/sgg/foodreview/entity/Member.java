package com.sgg.foodreview.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MEMBER")
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id", unique = true, nullable = false)
    private Long memberId;

    @Column(name = "member_nm")
    private String memberNm;

    @Column(name = "member_role")
    private String memberRole;

    @Column(name = "member_pwd")
    private String memberPwd;
}

