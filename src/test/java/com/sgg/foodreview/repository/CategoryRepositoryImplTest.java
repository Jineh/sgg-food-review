package com.sgg.foodreview.repository;

import com.sgg.foodreview.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class CategoryRepositoryImplTest {


    @PersistenceContext
    EntityManager em;

    @Autowired
    CatgoryRepository catgoryRepository;


    @Test
    void saveTest(){
        Category category = new Category();
        em.persist(category);

        category.setCategoryId(1L);

        catgoryRepository.save(category);
    }

}