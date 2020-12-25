package pers.cabin.basic;

import java.util.HashMap;

/**
 * Created by caiping on 2017/10/20.
 */
public class Test_class_init {
    public static int tmp = 1;
    static{
        tmp = 2;
//        System.out.println(tmp);
    }
    public static void main(String[] args){
//        test1();

        HashMap<String, Integer> map = new HashMap<String,Integer>();

        map.put(new String("hh"), 1);
        map.put(new String("hh"), 2);

        System.out.println(map.size());


    }

    private static void test1() {
        System.out.println(tmp);
        tmp = 3;
        System.out.println(tmp);
    }
}

