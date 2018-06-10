package pers.cabin.jichu.a1_jichu.Exception;

/**
 * Created by cc on 2016/11/3.
 */
public class Test {

    private static String output = "";

    private static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
            output += "1";
        } catch (Exception e) {
//            e.printStackTrace();
            output += "2";
        } finally {
            output += "3";
        }
        output += "4";
    }

    public static void main(String[] args) {
        foo(0);
        System.out.println(output);//134
        foo(1);
        System.out.println(output);//13423
    }
}

