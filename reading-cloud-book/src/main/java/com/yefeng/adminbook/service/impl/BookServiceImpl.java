package com.yefeng.adminbook.service.impl;

import cn.zealon.readingcloud.common.cache.RedisBookKey;
import cn.zealon.readingcloud.common.pojo.book.Book;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.adminbook.service.BookService;
import com.yefeng.adminbook.vo.BookListVO;
import com.yefeng.adminbook.dao.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookServiceImpl.java
 * @Description TODO
 * @createTime 2022年07月17日 09:55:00
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {


    @Override
    public Boolean addBook(Book book) {
        return baseMapper.insert(book) > 0;
    }

    @Override
    public BookListVO getBookList(Integer page, Integer limit) {
        //传入参数：当前页 和 每页显示记录数
        Page<Book> userPage = new Page<>(page, limit);
        //调用mp分页查询方法
        //调用mp分页查询过程中，底层会封装，把所有分页数据分装到page对象中
        Page<Book> bookPage = baseMapper.selectPage(userPage, null);

        //获取分页数据
        List<Book> records = bookPage.getRecords();
        //获取总记录数
        long total = bookPage.getTotal();
        //获取总页数
        long pages = bookPage.getPages();
        //获取当前页
        long current = bookPage.getCurrent();

        BookListVO booklistVO = new BookListVO();
        booklistVO.setBooks(records);
        booklistVO.setTotal(total);
        booklistVO.setPages(pages);
        booklistVO.setCurrent(current);
        return booklistVO;
    }

    @Override
    public Boolean deleteBook(String bookId) {
        QueryWrapper<Book> wrapper = new QueryWrapper<Book>().eq("book_id", bookId);
        int delete = baseMapper.delete(wrapper);
        System.out.println(delete);
        return delete>0;
//        String key = RedisBookKey.getBookKey(bookId);
//        return baseMapper.delete() > 0;
    }

    @Override
    public Boolean updateBook(Book book) {
        return baseMapper.updateById(book) > 0;
    }

    @Override
    public Book getBookById(String bookId) {
        return baseMapper.selectOne(new QueryWrapper<Book>().eq("book_id", bookId));
    }
}
