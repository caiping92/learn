package pers.cabin.jichu.a2_io.other;

import java.io.UnsupportedEncodingException;

/**
 * Created by cc on 2016/11/14.
 */
public class Test9 {

    public static void main(String[] args) {

        String str = "ab哈哈aa谢谢";
        String charset = "utf-8";
        int len = 0;
        try {
            len = str.getBytes(charset).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < len; i++) {
            System.out.println(str + "截取" + (i + 1) + "长度得结果时：" + cutStringByByte(str, (i + 1), charset));
        }

    }

    /**
     * 截取字符串
     *
     * @param str     被截取字符串
     * @param len     被截取字符串长度 按照byte长度截取
     * @param charset 字符串编码 支持 gbk，utf-8
     * @return
     */
    public static String cutStringByByte(String str, int len, String charset) {
        byte[] bytes = null;
        try {
            bytes = str.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int count = 0;
        for (int i = len - 1; i >= 0; i--) { //从有往左判断，若连续负数得个数，从而得到右边是否舍弃相应的byte数据
            if (bytes[i] < 0) {
                count++;
            } else {
                break;
            }
        }
        try {
            if (charset.equalsIgnoreCase("GBK")) {
                if ((count % 2) == 0) {
                    return new String(bytes, 0, len, charset);
                } else {
                    return new String(bytes, 0, len - 1, charset);
                }
            } else if (charset.equalsIgnoreCase("UTF-8")) {
                if ((count % 3) == 0) {
                    return new String(bytes, 0, len, charset);
                } else if ((count % 3) == 1) {
                    return new String(bytes, 0, len - 1, charset);
                } else if ((count % 3) == 2) {
                    return new String(bytes, 0, len - 2, charset);
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
