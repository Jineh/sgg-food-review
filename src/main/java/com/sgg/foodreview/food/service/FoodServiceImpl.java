package com.sgg.foodreview.food.service;

import com.sgg.foodreview.category.dto.CategoryListResponseParam;
import com.sgg.foodreview.category.repository.CategoryRepository;
import com.sgg.foodreview.category.repository.CategoryRepositoryImpl;
import com.sgg.foodreview.food.dto.FoodDetailResponseDto;
import com.sgg.foodreview.food.dto.FoodResponseDto;
import com.sgg.foodreview.food.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<FoodResponseDto> foodList(Long categotyId){
        return foodRepository.foodList(categotyId);
    }

    @Override
    public FoodDetailResponseDto foodDetail(Long foodId) {
        return foodRepository.findFoodDetailByFoodId(foodId);
    }

    @Override
    public List<CategoryListResponseParam> categoryList() {
        return categoryRepository.categoryList();
    }


}
