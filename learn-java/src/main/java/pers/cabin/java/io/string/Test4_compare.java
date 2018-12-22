package pers.cabin.java.io.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * 对字符串进行排序  {"A","Aaa","Abc","aaaA","sdfsA",}
 * 1. 对数组排序
 * 2. for嵌套，换位
 * 3. 比较大小
 * <p>
 * Created by cc on 2016/11/7.
 */
public class Test4_compare {

    /**
     * 按照字典顺序 对字符串进行 排列
     *
     * @param arr
     * @return
     */
    public String[] sortStrArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }

            }
        }
        return arr;
    }

    /**
     * 对 数组中 两个元素 进行交换位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void t1() {
        String s = "a b c AA cc asdf AD asdf 14 2213 213";
        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(sortStrArr(sortStrArr(arr))));
    }
}


