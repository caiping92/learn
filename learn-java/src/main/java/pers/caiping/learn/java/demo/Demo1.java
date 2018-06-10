package pers.caiping.learn.java.demo;

import org.junit.Test;

/**
 * @author caiping
 * @create 2018/1/24 10:04
 * @Description
 */
public class Demo1 {


    /**
     * retry 使用
     */
    @Test
    public void test1() {

        retry1:
        for (int i = 0; i < 10; i++) {
            retry2:// 2（行4）
            while (i == 5) {
                continue retry1;
            }
            System.out.print(i + " ");
        }
    }

}
