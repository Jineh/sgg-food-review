package com.sgg.foodreview.review.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sgg.foodreview.entity.*;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.sgg.foodreview.entity.QImage.*;
import static com.sgg.foodreview.entity.QReview.*;
import static com.sgg.foodreview.entity.QReviewLike.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ImageRepository imageRepository;
    private final EntityManager em;
    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;  // S3 버킷 이름


    @Value("${file.dir}")
    private String fileDir;


    public String getFullPath(String filename) {
        return fileDir + filename;
    }


    public void regReview(ReviewDto reviewDto, MultipartFile img) throws IOException {

        File uploadFile = convert(img)  // 파일 변환할 수 없으면 에러
                .orElseThrow(() -> new IllegalArgumentException("error: MultipartFile -> File convert fail"));

        String path = upload(uploadFile, "img");


//        if (!img.isEmpty()) {
            String originalFilename = img.getOriginalFilename();
            String storeFileName = createStoreFileName(originalFilename);
//            String path = getFullPath(storeFileName);
//            img.transferTo(new File(path));

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


    // S3로 파일 업로드하기
    private String upload(File uploadFile, String dirName) {
        String fileName = dirName + "/" + UUID.randomUUID() + uploadFile.getName();   // S3에 저장된 파일 이름
        String uploadImageUrl = putS3(uploadFile, fileName); // s3로 업로드
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    // S3로 업로드
    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }


    // 로컬에 저장된 이미지 지우기
    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("File delete success");
            return;
        }
        log.info("File delete fail");
    }


    // 로컬에 파일 업로드 하기
    private Optional<File> convert(MultipartFile file) throws IOException {
        File convertFile = new File(System.getProperty("user.home") + "/" + file.getOriginalFilename());
        if (convertFile.createNewFile()) { // 바로 위에서 지정한 경로에 File이 생성됨 (경로가 잘못되었다면 생성 불가능)
            try (FileOutputStream fos = new FileOutputStream(convertFile)) { // FileOutputStream 데이터를 파일에 바이트 스트림으로 저장하기 위함
                fos.write(file.getBytes());
            }
            return Optional.of(convertFile);
        }

        return Optional.empty();
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




    public List<ReviewsDto> getReviewList(Long fdId, int check) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        List<ReviewsDto> rvs = null;

        StringTemplate formattedDate = Expressions.stringTemplate(
                "DATE_FORMAT({0}, {1})"
                , review.newDt
                , ConstantImpl.create("%Y/%m/%d"));

        if (check == 0) {
            rvs = queryFactory
                    .select(Projections.fields(ReviewsDto.class,
                            review.reviewId,
                            review.reviewStar.as("rating"),
                            review.reviewText,
                            image.imgPath,
                            formattedDate.as("newDt"),
                            reviewLike.likeId))
                    .from(review, image)
                    .leftJoin(reviewLike).on(review.reviewId.eq(reviewLike.reviewId))
                    .where(review.imgId.eq(image.imgId).and(review.foodId.eq(fdId)))
                    .orderBy(review.newDt.desc())
                    .fetch();

            return rvs;
        }

        if (check == 1) {
             rvs = queryFactory
                    .select(Projections.fields(ReviewsDto.class,
                            review.reviewId,
                            review.reviewStar.as("rating"),
                            review.reviewText,
                            image.imgPath,
                            formattedDate.as("newDt"),
                            reviewLike.likeId))
                    .from(review, image)
                     .leftJoin(reviewLike).on(review.reviewId.eq(reviewLike.reviewId))
                     .where(review.imgId.eq(image.imgId).and(review.foodId.eq(fdId)))
                    .orderBy(review.reviewStar.desc())
                    .fetch();
            

        }

        return rvs;

    }
}
