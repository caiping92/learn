package pers.cabin.jichu.a2_io.collection.entity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cc on 2016/11/9.
 */
public class Test1 {

    /**
     * List 底层 判断的是 equals 两个对象 是否相同
     */
    @Test
    public void test1() {
        List<Person> ls = new ArrayList<Person>();
        ls.add(new Person("蔡平", 24));
        ls.add(new Person("蔡平", 24));

        for (Person p : ls) {
            System.out.println(p);
        }
        System.out.println("--------------");
        ls.remove(new Person("蔡平", 24));

        for (Person p : ls) {
            System.out.println(p);
        }

    }

    /**
     * HashSet底层 是 先判断 equals 然后在判断两个对象是否相同
     */
    @Test
    public void test2() {
        Set<Person> set = new HashSet<Person>();

        set.add(new Person("蔡平", 24));
        set.add(new Person("蔡平", 24));

        for (Person p : set) {
            System.out.println(p);
        }

        System.out.println("-------------");

        set.remove(new Person("蔡平", 24));

        for (Person p : set) {
            System.out.println(p);
        }

    }

}
