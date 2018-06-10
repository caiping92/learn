package pers.cabin.jichu.a2_io.string;

/**
 * String 类的特点：
 * 字符串对象一旦被初始化就不会被改变
 * Created by cc on 2016/11/4.
 */
public class Test1 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        String a = "abc";           //常量池中创建字符串
        String b = new String("abc");//在堆内存中创建字符串，一个 new 一个常量池中创建
        System.out.println(a == b);//String 类中覆盖了 自己的 hashCode 和 equals方法
    }

    /**
     * 常量池中
     */
    private static void test1() {
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);//String 类中覆盖了 自己的 hashCode 和 equals方法
    }
}

