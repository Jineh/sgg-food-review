package com.sgg.foodreview.food.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
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
    public List<FoodResponseDto> findAllByOOrderByFdNmAsc(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QFood qFood = QFood.food;
        QReview qReview = QReview.review;
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
//                                ,ExpressionUtils.as(
//                                        JPAQueryFactory.select(
////                                            qReview.
//                                        ).from(qReview)
//                                                .where(qReview.foodId.eq(qFood.foodId))
//                                ,"rating")
                        )
                ).from(qFood)
                .where(builder)
                .orderBy(qFood.foodNm.asc())
                .fetch()
                ;

        return list;
    }
}
