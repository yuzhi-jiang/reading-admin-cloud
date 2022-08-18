package cn.zealon.readingcloud.common.Excpetion;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName CheckFailException.java
 * @Description TODO
 * @createTime 2022年05月05日 23:14:00
 */
public class CheckFailException extends RuntimeException {


    public CheckFailException(String message) {
        super(message);
    }
}
