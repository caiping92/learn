import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * 切割字符串
 * 中文 不能切半个
 * TODO 没有达到目标效果
 * Created by caiping on 2017/9/11.
 */
public class TestCutString {

    private static String CHARSET_NAME = "GBK";

    public static boolean isChinesChar(char c) throws UnsupportedEncodingException {
        return String.valueOf(c).getBytes(CHARSET_NAME).length > 1;
    }

    /**
     * 切割字符串，
     * @param origin 原字符串
     * @param count 长度
     * @return
     */
    public static String cutString(String origin,int count) throws UnsupportedEncodingException {

        if (origin != null && "".equals(origin)) {
            origin = new String(origin.getBytes(), CHARSET_NAME); //字符串在统一转化成 gbk格式
            if (count > 0 && count < origin.length()) {
                StringBuffer stringBuffer = new StringBuffer();

                char c;
                for (int i = 0; i<count-1;i++) {
                    c = origin.charAt(i);
                    stringBuffer.append(c);
                    if (isChinesChar(c)) {
                        --count;    //TODO
                    }
                }
                return stringBuffer.toString();
            }
        }
        return origin;
    }


    @Test
    public void testCutString() throws UnsupportedEncodingException {

        String s = "哈是ASBdafs";
        System.out.println(cutString(s,1));
        System.out.println(cutString(s,2));
        System.out.println(cutString(s,3));
        System.out.println(cutString(s,4));
        System.out.println(cutString(s,5));
        System.out.println(cutString(s,6));
        System.out.println(cutString(s,7));
        System.out.println(cutString(s,8));
        System.out.println(cutString(s,9));
        System.out.println(cutString(s,10));
        System.out.println(cutString(s,11));

    }
}
