package com.yefeng.adminbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookApplication.java
 * @Description TODO
 * @createTime 2022年07月17日 12:19:00
 */
@SpringBootApplication(scanBasePackages={"com.yefeng.adminbook", "cn.zealon.readingcloud.common"})
@MapperScan({"com.yefeng.adminbook.dao"})
@EnableFeignClients(basePackages = {"com.yefeng.adminbook.feign"})
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
