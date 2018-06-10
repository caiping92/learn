package pers.cabin.jichu.a2_io.other;

import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by cc on 2016/11/10.
 */
public class Test1 {

    @Test
    public void test1() {

        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }

    @Test
    public void test2() {

//        Runtime
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec("D:\\mySoft\\QQ\\Bin\\QQ.exe");
            Thread.sleep(10000);
            process.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {

        Date date = new Date();

        DateFormat format = new SimpleDateFormat();
        String res = format.format(date);

        System.out.println(res);

    }

    @Test
    public void test4() {

        Date date = new Date();

//        DateFormat dateFormat = DateFormat.getInstance();

//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        String date_str = dateFormat.format(date);
        System.out.println(date_str);

        try {
            Date res = DateFormat.getDateInstance().parse("2016-11-10");
            System.out.println(res);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5() {

        Date date = new Date();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(format.format(date));

        String str_date = "1992-05-04 11:12:01";
        try {
            System.out.println(format.parse(str_date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 两个日期相隔多少天
     */
    @Test
    public void test6() {
        String date1 = "2016-11-4";
        String date2 = "2016-11-10";

        try {
            System.out.println(getXianggeDay(date1, date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * 不包含当天
     *
     * @param s1
     * @param s2
     * @return
     * @throws ParseException
     */
    public long getXianggeDay(String s1, String s2) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = format.parse(s1);
        Date d2 = format.parse(s2);

        long t1 = d1.getTime();
        long t2 = d2.getTime();
        long temp = Math.abs(t1 - t2);
        return temp / 1000 / 60 / 60 / 24;
    }
}
