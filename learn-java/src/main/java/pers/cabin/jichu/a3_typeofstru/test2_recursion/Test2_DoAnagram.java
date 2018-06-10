package pers.cabin.jichu.a3_typeofstru.test2_recursion;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * <p>
 * 思想：
 * 1.如果只有一个字母或单词，者只为它。
 * 2.若2个或者2个以上。取首字母，得到n-1个字母。
 * 3.在n-1个字字母下，继续在不同的位置轮换。例如：
 * <p>
 * abc
 * c; bc/cb; abc/bac/bca,acb/cab/cba
 * <p>
 * n*(n-1)*(n-2)*1	-> 在第一个位置上的数有n中插入法，第二个位置n-1种方法，最后一个位置，只有一种方案
 *
 * @author caiping
 */
public class Test2_DoAnagram {

    @Test
    public void testPL() {
        List<String> data = new LinkedList<String>();
        data.add("1");
        data.add("2");
        data.add("3");
//        data.add("4");  

        List<List<String>> result = pL(data);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    /**
     * 得到全排列的方法
     *
     * @param data 存放要排列的各个元素
     * @return List<List<String>> 结果中的每一个List就是一种可能的排列
     */
    public List<List<String>> pL(List<String> data) {

        if (data.size() == 0) {
            return null;
        }

        List<List<String>> result = new LinkedList<List<String>>();

        if (data.size() == 1) {
            // 如果data中只有一个元素，那么直接得到它的全排列  
            List<String> p = new LinkedList<String>();
            p.add(data.get(0));
            result.add(p);
            return result;
        } else {
            // 否则，去除第一个元素，然后得到剩下的 n-1 个元素的全排列，第一个元素插入到每一种排列中的相应位置上就可以得到所有元素的全排列了  
            // 也就是说， n-1 个元素的全排列中的每一种排列又可以衍生出 n 种排列  
            String first = data.get(0);
            List<String> remainList = data.subList(1, data.size());
            List<List<String>> remainPl = pL(remainList);

            for (int i = 0; i < remainPl.size(); i++) {

                List<String> thisOne = remainPl.get(i);
                for (int j = 0; j <= thisOne.size(); j++) {

                    List<String> copyOne = new LinkedList<String>(thisOne);
                    copyOne.add(j, first);
                    result.add(copyOne);
                }
            }
            return result;
        }
    }
}

class TestA {
    int size;
    int count;
    char[] arrChar = new char[100];

    public void getBianHuan(String input) {
        System.out.println("Enter a word:" + input);
        size = input.length();
        for (int i = 0; i < size; i++) {
            arrChar[i] = input.charAt(i);
            doAnagram(size);
        }
    }

    private void doAnagram(int newSize) {
        if (newSize == 1) {
            return;
        }
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2) {
                diplayWord();
                rotate(newSize);
            }
        }
    }

    private void rotate(int newSize) {
        int position = size - newSize;
        char temp = arrChar[position];
        for (int i = position + 1; i < size; i++) {
            arrChar[i - 1] = arrChar[i];
            arrChar[i - 1] = temp;
        }
    }

    private void diplayWord() {
        // TODO Auto-generated method stub
        if (count < 99) {
            System.out.print(" ");
        }
        if (count < 9) {
            System.out.print(" ");
        }
        System.out.print(" ");
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(arrChar[i]);
        }
        System.out.print("  ");

        if (count % 6 == 0) {
            System.out.println("");
        }
    }

}
