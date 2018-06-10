package pers.cabin.jichu.a2_io.string;

import org.junit.Test;

/**
 * 获取字符串中相同的 两个 子串
 * 以短的字符串为标准，逐个减少取长的字符串中查找是否有
 * <p>
 * 1.取的是最大子串，则选取两个字符串之间相对较短的字符串
 * 2.取子串，取长字符串中判断是否存在，若存在则不找
 * <p>
 * Created by cc on 2016/11/7.
 */
public class Test6 {

    /**
     * 获取两个字符串中相同的最大子串
     *
     * @param s1 较短的字符串
     * @param s2 较长的字符串
     * @return
     */
    public String getSameStr(String s1, String s2) {
        //确定 s1 s2 两个字符串中的 最短的子串
        String max = null, min = null;
        max = s1.length() > s2.length() ? s1 : s2;
        min = max.equals(s2) ? s1 : s2;

        String sub = "";
        for (int i = 0; i < min.length(); i++) {
            for (int leftIndex = 0, rightIndex = min.length() - i; rightIndex != min.length() + 1; leftIndex++, rightIndex++) {
                sub = min.substring(leftIndex, rightIndex);//切除的子串
                if ((max.indexOf(sub)) != -1) {   //在max 字符串中寻找 是否存在 该子串
                    return sub;
                }
            }
        }
        return "";
    }

    @Test
    public void t() {
        String s1 = "1321sfasdfas23132";
        String s2 = "asdfsfasdfasdfasdfdsadfaadc";
        System.out.println(getSameStr(s1, s2));

    }
}
