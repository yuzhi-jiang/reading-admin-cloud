package com.yefeng.adminbook.service;

import cn.zealon.readingcloud.common.pojo.book.Book;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yefeng.adminbook.vo.BookListVO;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookService.java
 * @Description TODO
 * @createTime 2022年07月17日 09:52:00
 */
public interface BookService extends IService<Book> {

    Boolean addBook(Book book);

    BookListVO getBookList(Integer page, Integer limit);

    Boolean deleteBook(String bookId);

    Boolean updateBook(Book book);

    Book getBookById(String bookId);
}
