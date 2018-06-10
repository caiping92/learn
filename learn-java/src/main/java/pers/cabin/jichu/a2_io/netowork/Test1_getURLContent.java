package pers.cabin.jichu.a2_io.netowork;

import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cc on 2016/11/24.
 */
public class Test1_getURLContent {

    @Test
    public void test1() {
        String urlStr = "http://www.haitou.cc";
        String reg = "<a\\s.*/a>";

        List<String> result = getResult(urlStr, reg);
        String tmp = null;
        for (int i = 0; i < result.size(); i++) {
            tmp = result.get(i);
            if (tmp.contains("javascript:")) {
                result.remove(i);
            }
        }

        for (String s : result) {
            System.out.println(s);
        }

    }

    /**
     * 对一个 URL进行 抓取，通过 reg 正则表达式 获得相应的内容
     * <p>
     * String urlRegex = "href=\".*\"";
     *
     * @param urlStr
     * @param reg
     */
    public List<String> getResult(String urlStr, String reg) {
        URL url;

//      Pattern.CASE_INSENSITIVE 忽略大小写
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = null;

        List<String> result = new ArrayList<String>();

        try {
            url = new URL(urlStr);
            URLConnection connection = url.openConnection();
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = null;
            while ((line = in.readLine()) != null) {
                matcher = pattern.matcher(line);
                while (matcher.find()) {
                    result.add(matcher.group());
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    @Test
    public void test2() {

        String line = "";
        String reg = "";

        List<String> res = getRegexStr(line, reg);
        for (String s : res) {
            System.out.println(s);
        }

    }

    /**
     * 对line 中的数据 进行 reg 匹配，获取 符合 reg要求的 字符串
     *
     * @param line
     * @param reg
     * @return
     */
    public List<String> getRegexStr(String line, String reg) {
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        List<String> result = new ArrayList<String>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    /**
     * 将文件存到 本地
     *
     * @param in
     * @param path     路径
     * @param filename 文件名
     * @return
     */
    public static boolean storeFileToLocal(InputStream in, String path, String filename) {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new FileOutputStream(new File(path, filename)));
            byte[] buf = new byte[4096];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }

}
