package cn.gson.oasys;

import java.io.File;

/**
 * @ClassName PathDemo
 * @Description: TODO
 * @Author gmf
 * @Date 2020/3/16
 * @Version V1.0
 **/
public class PathDemo {
    public static void main(String[] args) {
        String path = PathDemo.class.getResource("/").getPath();
        System.out.println("path = " + path);
        System.out.println(System.getProperty("user.dir"));
        System.out.println(new File(path).getParentFile());
        System.out.println();
    }
}
