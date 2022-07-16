package com.sgg.foodreview.repository.category;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sgg.foodreview.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryRepositoryImpl{

    @PersistenceContext
    EntityManager em;

//    List<String> getCategoryNm(){
//        JPAQueryFactory queryFactory = new JPAQueryFactory()
//    }
    void saveTest(){
        Category category = new Category();
        em.persist(category);
    }


}
