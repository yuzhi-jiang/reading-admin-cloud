package cn.zealon.readingcloud.common.constant;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName MqConstant.java
 * @Description TODO
 * @createTime 2022年07月10日 21:16:00
 */
public class MqConstant {

    //交换机
    public final static String BOOK_EXCHANGE="book.topic";

    //监听增加/修改队列
    public final static String BOOK_INSERT_QUEUE="book.insert.queue";
    //监听删除队列
    public final static String BOOK_DELETE_QUEUE="book.delete.queue";

    //增加或修改的routingKey
    public final static String BOOK_INSERT_KEY="book.insert";
    //删除的routingKey
    public final static String BOOK_DELETE_KEY="book.delete";


}
