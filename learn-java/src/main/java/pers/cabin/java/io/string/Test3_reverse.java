package pers.cabin.java.io.string;

import org.junit.Test;

/**
 * 字符串翻转
 * Integer 翻转
 * <p>
 * Strintg s= “abc”  ->  cba
 * Stromg s2 = “-abc” -> -cba
 * Created by cc on 2016/11/7.
 */
public class Test3_reverse {

    public String reverseStr(String str) {
        return reverse(str);
    }

    public String reverseInteger(Integer str) {
        String s = str + "";
        String[] t = s.split("");
        if (t[0].equals("-")) {
            s = s.substring(1);
            return "-" + reverse(s);
        } else {
            return reverse(s);
        }

    }

    private String reverse(String str) {

        String[] arr = str.split("");
        String[] temp = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[arr.length - i - 1] = arr[i];
        }
        return arrToStr(temp);
    }

    private String arrToStr(String[] arr) {
        String temp = "";
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
        }
        return temp;
    }

    @Test
    public void test() {

        String s = "-abc";
        Integer i = -123;

        String res_s = reverseStr(s);
        System.out.println(s + " -> " + res_s);

        String res_i = reverseInteger(i);
        System.out.println(i + " -> " + res_i);

    }

}
