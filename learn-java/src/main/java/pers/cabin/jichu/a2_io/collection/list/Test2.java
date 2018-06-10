package pers.cabin.jichu.a2_io.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by cc on 2016/11/8.
 */
public class Test2 {

    /**
     * 去除ArrayList中重复元素
     */
    @Test
    public void test1() {

    }

    /**
     * 添加时，判断是否存在 该元素
     *
     * @param list
     * @param t
     * @param <T>
     */
    public <T> void t1(ArrayList list, T t) {
        if (!list.contains(t)) {
            list.add(t);
        }
    }

    /**
     * 去除该集合中的相同元素
     *
     * @param <T>
     */
    public <T> void t2(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++)
                if (list.get(i).equals(list.get(j))) {
                    T remove = list.remove(j);
                }
        }

    }

    @Test
    public void test3() {
        new TreeSet<String>();

//        Collections.synchronizedCollection()
        int[] arr = new int[4];
        List<int[]> l = Arrays.asList(arr);

        List<String> list = new ArrayList<String>();

        Object[] objects = list.toArray();

    }
}
