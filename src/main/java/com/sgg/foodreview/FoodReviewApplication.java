package com.sgg.foodreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class FoodReviewApplication {

//    public static final String APPLICATION_LOCATIONS = "spring.config.location="
//            + "classpath:application.properties,";


    public static void main(String[] args) {
        SpringApplication.run(FoodReviewApplication.class, args);

    }

    @Bean
    public AuditorAware<String> auditorProvider(){
        //return () -> Optional.of(UUID.randomUUID().toString());
        return () -> Optional.of("user1");
    }



}
