package com.yefeng.adminbook.service.impl;

import cn.zealon.readingcloud.common.pojo.book.BookChapter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yefeng.adminbook.dao.BookChapterMapper;
import com.yefeng.adminbook.service.BookChapterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookChapterImpl.java
 * @Description TODO
 * @createTime 2022年07月17日 10:20:00
 */
@Service
public class BookChapterImpl extends ServiceImpl<BookChapterMapper, BookChapter> implements BookChapterService {

    @Override
    public Boolean addChapter(BookChapter chapter) {
        return baseMapper.insert(chapter) > 0;
    }

    @Override
    public BookChapter getChapter(Integer chapterId) {
        return baseMapper.selectById(chapterId);
    }

    @Override
    public Boolean updateChapterContent(BookChapter chapter) {
        return baseMapper.updateById(chapter) > 0;
    }

    @Override
    public List<BookChapter> getChapterList(String bookId,Integer page, Integer limit) {
        QueryWrapper<BookChapter> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        queryWrapper.orderByAsc("sort_number");
        Page<BookChapter> userPage = new Page<>(page, limit);
        Page<BookChapter> bookChapterPage = baseMapper.selectPage(userPage, queryWrapper);
        return bookChapterPage.getRecords();
    }

    @Override
    public Boolean deleteChapter(String bookId,String chapterId) {

        return baseMapper.deleteByMap(new HashMap<String, Object>(){{
            put("book_id", bookId);
            put("sort_number", chapterId);
        }}) > 0;
    }

    @Override
    public Boolean deleteChapter(String chapterId) {
        return baseMapper.deleteById(chapterId) > 0;
    }
}
