package com.sgg.foodreview.food.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sgg.foodreview.entity.QFood;
import com.sgg.foodreview.entity.QReview;
import com.sgg.foodreview.food.dto.FoodResponseDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements FoodRepositoryForQueryDsl{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<FoodResponseDto> findAllByOrderByFdNmAsc(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QFood qFood = QFood.food;
        QReview qReview = QReview.review;
        QReview qReview2 = new QReview("qReview2");
        BooleanBuilder builder = new BooleanBuilder();

        List<FoodResponseDto> list = queryFactory
                .select(
                        Projections.fields(
                                FoodResponseDto.class
                                ,qFood.foodId
                                ,qFood.foodNm
                                ,qFood.foodDesc
                                ,qFood.foodPrice
                                // rating
                                ,ExpressionUtils.as(
                                        JPAExpressions.select(
                                                qReview.reviewStar.avg()
                                        ).from(qReview)
                                                .where(qReview.foodId.eq(qFood.foodId))
//                                        JPAExpressions.select(qReview.reviewStar.sum().divide(
//                                                JPAExpressions.select(qReview.foodId.count())
//                                                        .from(qReview2)
//                                                        .where(qReview2.foodId.eq(qFood.foodId))
//                                                ))
//                                                .from(qReview)
//                                                .where(qReview.foodId.eq(qFood.foodId))
                                ,"rating")
                        )
                ).from(qFood)
                .orderBy(qFood.foodNm.asc())
                .fetch();
                ;

        return list;
    }
}
