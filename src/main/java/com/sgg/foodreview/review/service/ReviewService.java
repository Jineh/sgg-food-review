package com.sgg.foodreview.review.service;

import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sgg.foodreview.entity.Image;
import com.sgg.foodreview.entity.QImage;
import com.sgg.foodreview.entity.QReview;
import com.sgg.foodreview.entity.Review;
import com.sgg.foodreview.review.dto.ReviewDto;
import com.sgg.foodreview.review.dto.ReviewsDto;
import com.sgg.foodreview.review.repository.ImageRepository;
import com.sgg.foodreview.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.sgg.foodreview.entity.QImage.*;
import static com.sgg.foodreview.entity.QReview.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ImageRepository imageRepository;
    private final EntityManager em;





    @Value("${file.dir}")
    private String fileDir;


    public String getFullPath(String filename) {
        return fileDir + filename;
    }


    public void regReview(ReviewDto reviewDto, MultipartFile img) throws IOException {


        if (!img.isEmpty()) {
            String originalFilename = img.getOriginalFilename();
            String storeFileName = createStoreFileName(originalFilename);
            String path = getFullPath(storeFileName);
            img.transferTo(new File(path));

            Image image = new Image();
            image.setImgExtension("jpg");
            image.setImgNm(originalFilename);
            image.setImgPath(path);

            imageRepository.save(image);


            em.flush();
            em.clear();

            Long imgId = image.getImgId();

            Review review = new Review();
            review.setReviewStar(reviewDto.getRating());
            review.setReviewText(reviewDto.getReviewText());
            review.setFoodId(reviewDto.getFoodId());
            review.setImgId(imgId);

            reviewRepository.save(review);

        }
        else{

        }







    }

    public String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }




    public List<ReviewsDto> getReviewList(Long fdId){

        StringTemplate formattedDate = Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , review.newDt
                , ConstantImpl.create("%Y/%m/%d"));

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<ReviewsDto> rvs = queryFactory
                .select(Projections.fields(ReviewsDto.class,
                        review.reviewId,
                        review.reviewStar.as("rating"),
                        review.reviewText,
                        image.imgPath,
                        formattedDate.as("newDt")
                ))
                .from(review, image)
                .where(review.imgId.eq(image.imgId).and(review.foodId.eq(fdId)))
                .fetch();


        return rvs;


    }
}
