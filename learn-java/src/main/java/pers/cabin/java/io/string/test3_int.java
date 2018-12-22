package pers.cabin.java.io.string;

import org.junit.Test;

/**
 * Created by cc on 2016/11/7.
 */
public class test3_int {

    public int reverseInt(int x) {
        int res;
        if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
            return 0;
        } else if ((x >= -9) && (x <= 9)) {
            return x;
        } else if (x < 0) {
            try {
                res = Integer.parseInt("-" + reverseStr((x < 0 ? -x : x) + ""));
                return res;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        } else {
            try {
                res = Integer.parseInt(reverseStr(x + ""));
                return res;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }

    }

    public String reverseStr(String s) {
        int length = s.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    @Test
    public void test() {
        int t = -123;
        System.out.println(reverseInt(t));

    }

}
