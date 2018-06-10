package pers.cabin.poiutil.excel;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import pers.cabin.poiutil.excel.vo.Student;
import pers.cabin.poiutil.excel.vo.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 注意，文件路径 没有在  excel相关的 包中实现，若文件路径不存在，那么就必须得重新创建
 * Created by caiping on 2017/3/21.
 */
public class TestExcelUtils {
    /**
     *通过模板，普通方式 创建 Excel
     */
    @Test
    public void test01() {
        ExcelTemplate et = ExcelTemplate.getInstance()
                .readTemplateByClasspath("/excel/user.xls");
        et.createNewRow();
        et.createCell("1111111");
        et.createCell("aaaaaaaaaaaa");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("222222");
        et.createCell("bbbbb");
        et.createCell("b");
        et.createCell("dbbb");
        et.createNewRow();
        et.createCell("3333333");
        et.createCell("cccccc");
        et.createCell("a1");
        et.createCell(12333);
        et.createNewRow();
        et.createCell("4444444");
        et.createCell("ddddd");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell(112);
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("555555");
        et.createCell("eeeeee");
        et.createCell("a1");
        et.createCell("a2a2");
        Map<String,String> datas = new HashMap<String,String>();
        datas.put("title","测试用户信息");
        datas.put("date","2017-03- 12:33");
        datas.put("dep","财务处");
        et.replaceFinalData(datas);
        et.insertSer();
        et.writeToFile("d:/test/poi/test01.xls");
    }

    /**
     * 运用对象封装，通过模板导出到 Excel 中去
     */
    @Test
    public void testObj2Xls() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"aaa","水水水",11));
        users.add(new User(2,"sdf","水水水",11));
        users.add(new User(3,"sdfde","水水水",11));
        users.add(new User(4,"aaa","水水水",11));
        users.add(new User(54,"aaa","水水水",11));
        users.add(new User(16,"aaa","水水水",11));
        ExcelUtil.getInstance().exportObj2ExcelByTemplate(new HashMap<String,String>(),"/excel/user.xls","d:/test/poi/test02.xls", users, User.class, true);
    }

    @Test
    public void testObj2Xls2() {
        List<Student> stus = new ArrayList<Student>();
        stus.add(new Student(1,"张三","1123123", "男"));
        stus.add(new Student(2,"张三","1123123", "男"));
        stus.add(new Student(3,"张三","1123123", "男"));
        stus.add(new Student(4,"张三","1123123", "男"));
        ExcelUtil.getInstance().exportObj2Excel("d:/test/poi/test03.xls",stus, Student.class, false);
    }

    /**
     * BeanUtils 的用法，通过反射得到该对象的 原型链，用于设置或者获取属性
     */
    @Test
    public void testBeanutil() {
        try {
            Class us = User.class;
            Object obj = us.newInstance();
            BeanUtils.copyProperty(obj, "username", "张三");
            String str = BeanUtils.getProperty(obj,"username");
            System.out.println(str);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射
     */
    @Test
    public void testRe() {
        try {
            String method = "setUsername";

            Class us = User.class;
            Object obj = us.newInstance();
            Method m = us.getDeclaredMethod(method,String.class);
            m.invoke(obj, "张三");
            Method m2 = us.getDeclaredMethod("getUsername");
            System.out.println(m2.invoke(obj));
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析 Excel 对象 到 集合中
     */
    @Test
    public void testRead01() {
        List<Object> stus = ExcelUtil.getInstance().readExcel2ObjsByPath("d:/test/poi/test03.xls",Student.class);
        for(Object obj:stus) {
            Student stu = (Student)obj;
            System.out.println(stu);
        }
    }

    /**
     * 解析Excel 到 集合中，
     */
    @Test
    public void testRead02() {
        List<Object> stus = ExcelUtil.getInstance().readExcel2ObjsByPath("d:/test/poi/test02.xls",User.class,1,2);
        for(Object obj:stus) {
            User stu = (User)obj;
            System.out.println(stu);
        }
    }
}
