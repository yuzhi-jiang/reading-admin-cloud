package com.yefeng.adminbook.controller;

import cn.zealon.readingcloud.common.cache.RedisBookKey;
import cn.zealon.readingcloud.common.cache.RedisService;
import cn.zealon.readingcloud.common.constant.MqConstant;
import cn.zealon.readingcloud.common.pojo.book.Book;
import cn.zealon.readingcloud.common.result.Result;
import cn.zealon.readingcloud.common.result.ResultUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yefeng.adminbook.dao.BookMapper;
import com.yefeng.adminbook.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName BookController.java
 * @Description TODO
 * @createTime 2022年07月17日 10:01:00
 */
@Api(tags = "书本管理接口")
@RestController

public class BookAdminController {

    @Resource
    BookService bookService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    //添加书本
    @ApiOperation(value = "添加书本", httpMethod = "POST")
    @PostMapping("book")
    public Result addBook(@RequestBody Book book) {
        Boolean flag = bookService.addBook(book);
        if (flag){
            rabbitTemplate.convertAndSend(MqConstant.BOOK_EXCHANGE,MqConstant.BOOK_INSERT_KEY,book.getBookId());
            return ResultUtil.success("添加成功");
        }else{
            return ResultUtil.error("添加失败");
        }
    }

    //查询书本列表
    @ApiOperation(value = "查询书本列表", httpMethod = "GET")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query", dataType = "int"),
                    @ApiImplicitParam(name = "limit", value = "每页条数", required = true, paramType = "query", dataType = "int")
            }
    )
    @GetMapping("book/list")
    public Result getBookList(Integer page, Integer limit) {
        return ResultUtil.success(bookService.getBookList(page, limit));
    }

    //更新书本信息
    @ApiOperation(value = "更新书本信息", httpMethod = "PUT")
    @PutMapping("book")
    public Result updateBook(@RequestBody Book book) {
        Boolean flag = bookService.updateBook(book);
        if (flag){
            rabbitTemplate.convertAndSend(MqConstant.BOOK_EXCHANGE,MqConstant.BOOK_INSERT_KEY,Long.parseLong(book.getBookId()));
            return ResultUtil.success("修改成功");
        }else{
            return ResultUtil.error("修改失败");
        }
    }

    //查询书本详情
    @ApiOperation(value = "查询书本详情", httpMethod = "GET")
    @GetMapping("book/{bookId}")
    public Result getBook(@PathVariable String bookId) {
        return ResultUtil.success(bookService.getBookById(bookId));
    }


    @Resource
    private RedisService redisService;

    //删除书本
    @ApiOperation(value = "删除书本", httpMethod = "DELETE")
    @DeleteMapping("book/{bookId}")
    public Result deleteBook(@PathVariable String bookId) {
        Boolean flag = false;
        try {
            flag = bookService.deleteBook(bookId);
            if (flag) {
//                redisService.removeCache(RedisBookKey.getBookKey(bookId));
//                rabbitTemplate.convertAndSend(MqConstant.BOOK_EXCHANGE,MqConstant.BOOK_DELETE_KEY,bookId);
                rabbitTemplate.convertAndSend(MqConstant.BOOK_EXCHANGE,MqConstant.BOOK_DELETE_KEY,Long.parseLong(bookId));
                System.out.println("删除成功，发送mq");
            } else {
                return ResultUtil.error("删除" + bookId + "失败");
            }
            return ResultUtil.success("删除" + bookId + "成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("删除" + bookId + (!flag ? "失败":"成功")+" "+e.getMessage());
        }
    }

    @Resource
    BookMapper bookMapper;
//
//    @GetMapping("/test")
//    public Result test() {
//        //传入参数：当前页 和 每页显示记录数
//        Page<Book> userPage = new Page<>(1, 3);
//        //调用mp分页查询方法
//        //调用mp分页查询过程中，底层会封装，把所有分页数据分装到page对象中
//        Page<Book> bookPage = bookMapper.selectPage(userPage, null);
//        System.out.println(bookPage.toString());
//        //获取分页数据
//        List<Book> records = bookPage.getRecords();
////        //获取总记录数
////        long total = bookPage.getTotal();
////        //获取总页数
////        long pages = bookPage.getPages();
////        //获取当前页
////        long current = bookPage.getCurrent();
////        //获取每页显示记录数
////        long size = bookPage.getSize();
////        //获取是否有上一页
////        boolean hasPrevious = bookPage.hasPrevious();
////        //获取是否有下一页
////        boolean hasNext = bookPage.hasNext();
////        System.out.println(records);
//        return ResultUtil.success(records);
//    }

}
