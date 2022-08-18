package com.yefeng.adminbook.vo;

import cn.zealon.readingcloud.common.pojo.book.Book;
import lombok.Data;

import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BooklistVO.java
 * @Description TODO
 * @createTime 2022年07月17日 13:18:00
 */
@Data
public class BookListVO {
    private List<Book> books;
    private Long total;
    private Long pages;
    private Long current;
}
