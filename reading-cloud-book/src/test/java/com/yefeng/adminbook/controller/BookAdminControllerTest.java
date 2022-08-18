package com.yefeng.adminbook.controller;

import cn.zealon.readingcloud.common.constant.MqConstant;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookAdminControllerTest.java
 * @Description TODO
 * @createTime 2022年07月20日 15:48:00
 */
@SpringBootTest
class BookAdminControllerTest {

    @Test
    void addBook() {
    }

    @Test
    void getBookList() {
    }

    @Test
    void updateBook() {
    }

    @Test
    void getBook() {
    }
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    void deleteBook() {
        Long bookId=806800381L;
        rabbitTemplate.convertAndSend(MqConstant.BOOK_EXCHANGE,MqConstant.BOOK_DELETE_KEY,bookId);
    }
}