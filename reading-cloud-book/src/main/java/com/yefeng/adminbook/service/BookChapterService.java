package com.yefeng.adminbook.service;

import cn.zealon.readingcloud.common.pojo.book.BookChapter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookChapterService.java
 * @Description TODO
 * @createTime 2022年07月17日 10:20:00
 */
public interface BookChapterService extends IService<BookChapter> {

    Boolean addChapter(BookChapter chapter);

    BookChapter getChapter(Integer chapterId);

    Boolean updateChapterContent(BookChapter chapter);

    List<BookChapter> getChapterList(String bookId,Integer page, Integer limit);

    Boolean deleteChapter(String bookId,String chapterId);

    Boolean deleteChapter(String chapterId);
}
