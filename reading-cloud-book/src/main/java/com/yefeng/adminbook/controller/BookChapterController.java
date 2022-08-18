package com.yefeng.adminbook.controller;

import cn.zealon.readingcloud.common.pojo.book.BookChapter;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.common.result.ResultUtil;
import com.yefeng.adminbook.service.BookChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookChapterController.java
 * @Description TODO
 * @createTime 2022年07月17日 10:02:00
 */
@RestController
@Api(tags = "章节管理接口")
public class BookChapterController {
    @Resource
    BookChapterService bookChapterService;

    //    添加章节
    @ApiOperation(value = "添加章节", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "chapter", value = "章节信息", dataType = "BookChapter")
    })
    @PostMapping("chapter")
    public Result addChapter(@RequestBody BookChapter chapter) {
        return ResultUtil.success(bookChapterService.addChapter(chapter));
    }

    //    修改章节内容
    @ApiOperation(value = "修改章节内容", httpMethod = "PUT")
    @ApiImplicitParam(paramType = "query", name = "chapter", value = "章节信息", dataType = "BookChapter")
    @PutMapping("chapter")
    public Result updateChapterContent(@RequestBody BookChapter chapter) {
        return ResultUtil.success(bookChapterService.updateChapterContent(chapter));
    }

    //    查询章节内容
    @ApiOperation(value = "查询章节内容", httpMethod = "GET")
    @ApiImplicitParam(paramType = "query", name = "chapterId", value = "章节id", dataType = "String")
    @GetMapping("chapter/{chapterId}")
    public Result getChapterContent(@PathVariable Integer chapterId) {
        return ResultUtil.success(bookChapterService.getChapter(chapterId));
    }

    //    查询章节列表
    @ApiOperation(value = "查询章节列表", httpMethod = "GET")

    @ApiImplicitParam(paramType = "query", name = "bookId", value = "书本id", dataType = "String")

    @GetMapping("chapter/list/{bookId}")
    public Result getChapterList(@PathVariable String bookId, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        System.out.println(bookId);
        System.out.println(page);
        System.out.println(limit);
        return ResultUtil.success(bookChapterService.getChapterList(bookId, page, limit));
    }

    //    删除章节
    @ApiOperation(value = "删除章节", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "chapterId", value = "章节id", dataType = "String")
    })
    @DeleteMapping("chapter/{bookId}/{chapterId}")
    public Result deleteChapter(@PathVariable String bookId, @PathVariable String chapterId) {
        return ResultUtil.success(bookChapterService.deleteChapter(bookId, chapterId));
    }


    //    删除章节
    @ApiOperation(value = "删除章节", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "chapterId", value = "章节id", dataType = "String")
    })
    @DeleteMapping("chapter/{chapterId}")
    public Result deleteChapter(@PathVariable String chapterId) {
        return ResultUtil.success(bookChapterService.deleteChapter(chapterId));
    }
}
