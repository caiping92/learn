package pers.cabin.basic;

import java.math.BigDecimal;

/**
 * Created by caiping on 2017/9/10.
 */
public class TestFloat {


    /**
     *
     * 发行结果并不是我们预想的0.06
     * System.out.println(0.05+0.01); //=>0.060000000000000005
     *
     * 其主要原因是浮点数值采用二进制系统表示，而在二进制系统中无法精确表示1/10。这就好像十进制无法精确表示1/3一样。如果需要在数值计算中不含有任何舍入误差，就应该使用BigDecimal类.
     *
     * IEEE 745 规范
     *
     * @param args
     */
    public static void main(String[] args){

        String lineSeparator = System.getProperty("line.separator");

        float a = 0.05F;
        float b = 0.01F;
        float c = a + b;
        System.out.println(c);
        System.out.println(a*b);

        System.out.println(lineSeparator+"-------------"+lineSeparator);

//        使用 BIgDecimal
        BigDecimal bigDecimal = new BigDecimal(a);
        BigDecimal bigDecimal1 = new BigDecimal(b);

        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(bigDecimal.multiply(bigDecimal1));

    }
}
