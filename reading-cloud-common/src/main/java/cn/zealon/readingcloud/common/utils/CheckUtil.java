package cn.zealon.readingcloud.common.utils;


import cn.zealon.readingcloud.common.Excpetion.CheckFailException;

/**
 * @author yefeng
 * @version 1.0.0
 * @ClassName CheckUtil.java
 * @Description 这是一个检查工具类 ，检查是否用户是否符合要求
 * @createTime 2022年05月05日 22:48:00
 */
public class CheckUtil {

    public  enum CheckRex {
        User_Rex("^[a-zA-Z][a-zA-Z0-9_]{4,15}$", "用户名必须以字母开头，长度在5-16之间，只能包含字符、数字和下划线"),
        Password_Rex("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}$", "密码必须包含大小写字母和数字的组合，长度在8-16之间"),
        phone_Rex("^1[34578]\\d{9}$", "手机号格式错误"),
        email_Rex("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", "邮箱格式错误"),
        ;
        private String regx;
        private String ErrMessage;
        CheckRex(String rex, String errMessage) {
            this.regx = rex;
            this.ErrMessage = errMessage;
        }
    }
    /**
     * @param str  str
     * @param Regx regx
     * @return {@link Boolean }
     * @throws @throws CheckFailException 检查没有异常
     * @title checkByRegx
     * @author yefeng
     * @description TODO
     * @updateTime 2022/05/07
     */
    private static Boolean checkByRegx(String str, CheckRex Regx) throws CheckFailException {
        if (str.matches(Regx.regx)) {
           return true;
        }
        throw new CheckFailException(Regx.ErrMessage);
//        return false;
    }
    /**
     * @param userName 用户名
     * @return {@link Boolean }
     * @throws
     * @title checkUser
     * @author yefeng
     * @description TODO
     * @updateTime 2022/05/07
     */
    public static Boolean checkUser(String userName)  {

        return checkByRegx(userName, CheckRex.User_Rex);
    }

    public static Boolean checkPassword(String password) {
        return checkByRegx(password, CheckRex.Password_Rex);
    }

    public static Boolean checkEmail(String email) {
        return checkByRegx(email, CheckRex.email_Rex);
    }

    public static Boolean checkPhone(String phone) {
        return checkByRegx(phone, CheckRex.phone_Rex);
    }
    public static void main(String[] args) {
        CheckUtil.checkUser("jiangshao1");
        CheckUtil.checkPhone("13160963907");
        CheckUtil.checkPassword("Jiangshao1");
        CheckUtil.checkEmail("Jiangshao1");
    }

}
