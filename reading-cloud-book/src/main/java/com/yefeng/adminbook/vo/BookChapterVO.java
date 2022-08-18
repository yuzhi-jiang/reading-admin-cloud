package com.yefeng.adminbook.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookChapterVo.java
 * @Description TODO
 * @createTime 2022年07月17日 14:32:00
 */
@Data
public class BookChapterVO {
    /** 主键ID */
    protected Integer id;

    /**
     * 所属图书
     */
    private Integer bookId;

    /**
     * 章节名称
     */
    private String name;

    /**
     * 章节内容
     */
    private String content;

    /**
     * 锁章状态(0:无,1:锁章)
     */
    private Boolean lockStatus;

    /**
     * 排序
     */
    private Integer sortNumber;

    private Date createTime;

    private Date updateTime;

    private String creater;

    private String updater;
}
