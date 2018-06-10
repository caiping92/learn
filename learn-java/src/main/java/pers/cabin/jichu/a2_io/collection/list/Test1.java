package pers.cabin.jichu.a2_io.collection.list;

import pers.cabin.jichu.a2_io.collection.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cc on 2016/11/7.
 */
public class Test1 {
    @Test
    public void test1() {
        Person[] persons = new Person[2];

    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<String>();
        list.add("hah");

        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

    }

    @Test
    public void test3() {
        Color[] values = Color.values();
        for (Color c : values) {
            System.out.println(c);
        }

        System.out.println("---------------------------");

        Color r = Color.valueOf("RED");
        System.out.println(r);

        System.out.println("---------------------------");

        Color red = Color.RED;
        System.out.println(red);

        System.out.println("---------------------------");

        Color b = Color.BLUE;
        System.out.println(b.getName());
        b.setName("蓝色");
        System.out.println(b.getName());

    }
}

enum Color {
    // 这一步相当于初始化  枚举
    RED("红色", "66666"), BLUE();

    //内部自己需要初始化的 方法
    Color() {
    }

    Color(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

    // 给外部访问的方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}