package com.yefeng.adminbook.service.impl;

import cn.zealon.readingcloud.common.pojo.book.BookChapter;
import com.yefeng.adminbook.dao.BookChapterMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookChapterImplTest.java
 * @Description TODO
 * @createTime 2022年07月17日 14:11:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BookChapterImplTest {
    @Autowired
    BookChapterMapper bookChapterMapper;

    @Test
    void updateChapterContent() {
        BookChapter chapter=new BookChapter();
        chapter.setId(5);
        chapter.setContent("<p>测dsfsdf试</p>");
        int flag = bookChapterMapper.updateById(chapter);
        System.out.println(flag);
    }

    @Test
    void addChapter() {
        BookChapter chapter=new BookChapter();
//        chapter.setId(6);
        chapter.setBookId(30);
        chapter.setName("第2五章");
        chapter.setLockStatus(false);
        chapter.setSortNumber(5);
        chapter.setContent("<p>测dsfsddff试654;</sdf>");
        chapter.setCreater("yefeng");
        chapter.setCreateTime(new Date());
        int flag = bookChapterMapper.insert(chapter);
        System.out.println(flag);
    }

    @Test
    void getChapter() {
    }

    @Test
    void getChapterList() {
    }

    @Test
    void deleteChapter() {
    }

    @Test
    void testDeleteChapter() {
    }

    @Test
    void testAddChapter() {
    }
}