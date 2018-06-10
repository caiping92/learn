package pers.cabin.jichu.a2_io.stringbuffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by cc on 2016/11/7.
 */
public class Test {

    @org.junit.Test
    public void t() {
        StringBuffer sb = new StringBuffer();
        sb.append("abcdefgh");
        sb.reverse();

        System.out.println(sb.toString());
        char c = 'c';
        String.valueOf(c);

        String s = "";

    }

    @org.junit.Test
    public void t2() {

        System.out.println(String.valueOf(1));
        System.out.println(Character.valueOf(' '));
        System.out.println("123" + 1);
        try {
            System.out.println(Integer.valueOf("123") + 1);
            System.out.println(Integer.parseInt("1234" + 1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

//        new BigDecimal(
        char[] chs = {'a', 'b'};
        "abc".valueOf(chs);

    }

    @org.junit.Test
    public void test3() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("caiping", "12");
        map.put("caiping", "24");

        System.out.println("--利用 EntrySet 增强for循环--------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("--利用 EntrySet 普通for循环-------------------");

        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("--利用keySet 和map.get（key）-------------------");
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }

    }

}
