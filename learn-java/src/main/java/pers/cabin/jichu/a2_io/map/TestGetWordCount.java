package pers.cabin.jichu.a2_io.map;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * 获取字符串的个数
 * a(2)  b(3)  g(1)  ....
 * <p>
 * Created by cc on 2016/11/10.
 */
public class TestGetWordCount {

    /**
     * 将字符串 编程键值对
     * 键：字符
     * 值：累计结果
     *
     * @param str
     * @param regx 传入字符串切的方法的 规则（正则表达式）
     * @return 字符-出现次数 的Map结果
     */
    public Map<String, Integer> getWordCountAsMap(String str, String regx) {
        Map<String, Integer> rest = new TreeMap<String, Integer>();
        String[] arrStr = str.split(regx);
        for (int i = 0; i < arrStr.length; i++) {
            String k = arrStr[i];
            if (k != null && !k.equals("")) {
                if (rest.containsKey(k)) {
                    rest.put(k, (rest.get(k) + 1));
                } else {
                    rest.put(k, 1);
                }
            }
        }
        return rest;
    }

    /**
     * 返回 将一个字符串 返回，出现的次数的结果
     *
     * @param str
     * @return 返回的结果为一个字符串，例如 ：  a(1),B(1),c(1),d(1),E(1)
     */
    public String getResult(String str, String regx) {
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, Integer> count = getWordCountAsMap(str, regx);
        for (Map.Entry entry : count.entrySet()) {
            stringBuffer.append(entry.getKey() + "(" + entry.getValue() + ")" + ", ");
        }
        return stringBuffer.substring(0, stringBuffer.lastIndexOf(",")).toString();
    }

    @Test
    public void test1() {
        String str = "adasfdsfsaaaasaadaeWEQAdfdsfsf";
        System.out.println(getResult(str, ""));
    }

    @Test
    public void test2() {
        String string = "ha hai hello nice nice to meet you hao are you ";
        System.out.println(getResult(string, " "));
    }

    @Test
    public void test3() {
        Properties prop = new Properties();
        java.util.Properties properties = System.getProperties();
        properties.keySet();
        prop.keySet();
        prop.stringPropertyNames();

    }

}
