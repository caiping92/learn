package pers.cabin.jichu.a2_io.string;

import org.junit.Test;

/**
 * 去除字符串两端的空白
 * Created by cc on 2016/11/7.
 */
public class Test7 {

    public String strTrim(String str) {
        //TODO 初始化空格角标
        int leftIndex = 0, rightIndex = str.length() - 1;
        //判断不是空格为止
        while (str.charAt(leftIndex) == ' ' && leftIndex <= rightIndex) {
            leftIndex++;
        }
        while (str.charAt(rightIndex) == ' ' && leftIndex <= rightIndex) {
            rightIndex++;
        }
        return str.substring(leftIndex, rightIndex);
    }

    @Test
    public void t() {

        " ".trim();
    }
}
