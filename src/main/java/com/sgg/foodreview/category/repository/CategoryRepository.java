package com.sgg.foodreview.category.repository;

import com.sgg.foodreview.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryForQueryDsl {

}
