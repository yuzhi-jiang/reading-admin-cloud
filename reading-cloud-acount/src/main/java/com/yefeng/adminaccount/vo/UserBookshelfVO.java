package com.yefeng.adminaccount.vo;

import lombok.Data;

/**
 * 书架VO
 * @author: zealon
 * @since: 2020/4/15
 */
@Data
public class UserBookshelfVO {

    private Integer id;

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 图书id
     */
    private String bookId;

    private String bookName;

    private String authorName;

    private String imgUrl;

    /**
     * 图书最后章节id
     */
    private Integer lastChapterId;

    /**
     * 最后阅读时间
     */
    private Long lastReadTime;
}
