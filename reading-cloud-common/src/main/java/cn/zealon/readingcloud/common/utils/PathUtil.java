package cn.zealon.readingcloud.common.utils;

public class PathUtil {
    public static String getCurrProjectPath(){
        return System.getProperty("user.dir");
    }
    public static String getPathSeparator(){
        return System.getProperty("file.separator");
    }
    public static String getFileSeparator(){
        return System.getProperty("file.separator");
    }
    //获取当前项目的父目录路径
    public static String getCurrProjectParentPath(){
        String currPath = getCurrProjectPath();
        return currPath.substring(0,currPath.lastIndexOf(getPathSeparator()));
    }

    public static void main(String[] args) {
        System.out.println(getCurrProjectPath());
        System.out.println(getCurrProjectParentPath());
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("path.separator"));
    }
}
