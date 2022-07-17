package com.sgg.foodreview.reviewlike.repository;

import com.sgg.foodreview.category.dto.CategoryListResponseParam;

import java.util.List;

public interface ReivewLikeRepositoryForQueryDsl {

    List<CategoryListResponseParam> categoryList();

}
