package com.blogs.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blogs.user.dao")
public class BlogsUserApplication {
    public static void main(String[] args){
        SpringApplication.run(BlogsUserApplication.class,args);
    }
}
