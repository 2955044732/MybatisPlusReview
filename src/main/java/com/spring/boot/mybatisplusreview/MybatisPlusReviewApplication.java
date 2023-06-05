package com.spring.boot.mybatisplusreview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.spring.boot.mybatisplusreview.mapper")//可以写在配置类中
public class MybatisPlusReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusReviewApplication.class, args);
    }

}
