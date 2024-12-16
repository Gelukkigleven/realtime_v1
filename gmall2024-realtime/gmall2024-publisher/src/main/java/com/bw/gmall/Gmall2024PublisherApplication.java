package com.bw.gmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 这段代码定义了一个Spring Boot应用程序的入口类，通过注解配置了自动配置、组件扫描和MyBatis的Mapper扫描，
 使得应用程序能够自动配置和启动，同时能够与数据库进行交互。
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall.mapper")
public class Gmall2024PublisherApplication {
    public static void main(String[] args) {
        SpringApplication.run(Gmall2024PublisherApplication.class,args);
    }
}
