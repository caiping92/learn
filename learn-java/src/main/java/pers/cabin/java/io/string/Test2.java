package pers.cabin.java.io.string;

/**
 * Created by cc on 2016/11/4.
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "abc";
        String s_1 = new String("abc");
        System.out.println(s == s_1);
        System.out.println(s.equals(s_1));

        String s2 = s.replace("a", "d");
        String s3 = s.replace("M", "n");
        System.out.println(s == s2);
        System.out.println(s == s3);

    }
}
