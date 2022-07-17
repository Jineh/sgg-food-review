package com.sgg.foodreview.reviewlike.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sgg.foodreview.category.dto.CategoryListResponseParam;
import com.sgg.foodreview.category.repository.CategoryRepositoryForQueryDsl;
import com.sgg.foodreview.entity.QCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ReviewLikeRepositoryImpl implements CategoryRepositoryForQueryDsl {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<CategoryListResponseParam> categoryList() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QCategory qCategory = QCategory.category;

        List<CategoryListResponseParam> list = queryFactory
                .select(
                    Projections.fields(
                            CategoryListResponseParam.class
                            ,qCategory.categoryId
                            ,qCategory.categoryNm
                    )
                )
                .from(qCategory)
                .orderBy(qCategory.categoryId.asc())
                .fetch();

        return list;
    }
}
