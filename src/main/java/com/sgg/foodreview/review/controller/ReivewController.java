package com.sgg.foodreview.review.controller;

import com.sgg.foodreview.Result;
import com.sgg.foodreview.entity.Image;
import com.sgg.foodreview.review.dto.ReviewDto;
import com.sgg.foodreview.review.dto.UploadFile;
import com.sgg.foodreview.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/sgg/food-review/review")
@RequiredArgsConstructor
public class ReivewController {


    private final ReviewService reviewService;

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    @PostMapping("/upload")
    public ResponseEntity<Result> saveFile(@RequestParam(value = "img", required = false) MultipartFile img,
                                   @RequestPart("myReview") ReviewDto review) throws IOException {


        if (!img.isEmpty()) {
            String originalFilename = img.getOriginalFilename();
            String storeFileName = reviewService.createStoreFileName(originalFilename);
            img.transferTo(new File(getFullPath(storeFileName)));
        }

        reviewService.regReview(review);
        return ResponseEntity.ok(new Result("200", "게시글 작성"));

    }

}


