package chuanglin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by caiping on 2017/9/28.
 */
public class Test4 {

    public static void main(String[] args) {
        char[] s1 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
        char[] s2 = { 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R' };
        char[] s3 = { 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ' };
        char[] s4 = new char[s1.length];

        Scanner sc = new Scanner(System.in

        );

        String s = sc.nextLine();
        String[] str = s.split(" ");

        // 月份
        int m = Integer.parseInt(str[0]);
        // 日期
        int d = Integer.parseInt(str[1]);

        // 月份旋转
        if ((m - 1) % 3 == 1) {
            s4 = s1;
            s1 = s2;
            s2 = s3;
            s3 = s4;
        } else if ((m - 1) % 3 == 2) {
            s4 = s1;
            s1 = s3;
            s3 = s2;
            s2 = s4;
        }

        // 日期旋转
        Arrayreverse(d, s1);
        Arrayreverse(d, s2);
        Arrayreverse(d, s3);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < str.length; i++) {
            if (i != str.length - 1) {
                sb.append(str[i]).append(" ");
            } else {
                sb.append(str[i]);
            }

        }
        sb.toString();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            list.add(jiami(ch, s1, s2, s3));
        }

        for (String str1 : list) {
            System.out.print(str1);
            System.out.print(" ");
        }

    }

    /**
     * 加密
     *
     * @param ch
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    private static String jiami(char ch, char[] s1, char[] s2, char[] s3) {
        String s = null;

        for (int i = 0; i < s1.length; i++) {
            if (ch == s1[i]) {
                s = "1" + (i + 1);
            }
        }
        for (int i = 0; i < s2.length; i++) {
            if (ch == s2[i]) {
                s = "2" + (i + 1);
            }
        }
        for (int i = 0; i < s3.length; i++) {
            if (ch == s3[i]) {
                s = "3" + (i + 1);
            }
        }

        return s;
    }

    /**
     * 日期旋转 数组旋转
     *
     * @param d
     *            日期
     * @param s
     *            数组
     */
    private static void Arrayreverse(int d, char[] s) {
        int len = s.length;
        int a = (d - 1) % len;
        char[] ch = new char[a];
        for (int i = 0; i < a; i++) {
            ch[i] = s[i];
        }
        // 旋转
        for (int i = 0; i < len; i++) {
            if (i < len - a) {
                s[i] = s[i + a];
            } else {
                s[i] = ch[i - (len - a)];
            }
        }
    }
}
