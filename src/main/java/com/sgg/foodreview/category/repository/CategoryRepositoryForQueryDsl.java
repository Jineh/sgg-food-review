package com.sgg.foodreview.category.repository;

import com.sgg.foodreview.category.dto.CategoryListResponseParam;

import java.util.List;

public interface CategoryRepositoryForQueryDsl {

    List<CategoryListResponseParam> categoryList();

}
