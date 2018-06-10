package pers.cabin.jichu.a2_io.string;

import org.junit.Test;

/**
 * 获取字符串中 熟悉俺的次数
 * <p>
 * Created by cc on 2016/11/7.
 */
public class Test5 {

    /**
     * 效率不高
     * 会在内存中产生过多字符串常量
     *
     * @param str
     * @param key
     * @return
     */
    public int getKeyStringCount(String str, String key) {
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(key)) != -1) { //indexOf()  是从左边开始往右边进行读取
            count++;
            str = str.substring(index + key.length());
        }
        return count;
    }

    /**
     * 相对来说 效率好点
     *
     * @param s
     * @param key
     * @return
     */
    public int getKeyStringCount_2(String s, String key) {
        int count = 0;
        int index = 0;
        while ((index = s.indexOf(key, index)) != -1) {
            index += key.length();
            count++;
        }
        return count;
    }

    @Test
    public void t() {
        String s = "aaaaasdfsdfdasdfadasdfasf";
        String key = "aaa";
        System.out.println(getKeyStringCount(s, key));

    }

    @Test
    public void test2() {
        String s = "aaaaasdfsdfdasdfadasdfasf";
        String key = "a";
        System.out.println(getKeyStringCount_2(s, key));
    }
}
