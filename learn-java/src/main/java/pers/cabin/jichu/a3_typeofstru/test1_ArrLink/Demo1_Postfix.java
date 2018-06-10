package pers.cabin.jichu.a3_typeofstru.test1_ArrLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 后缀转换测试
 *
 * @author caiping
 */
public class Demo1_Postfix {

    public static void main(String[] args) throws IOException {

        String input;
        int output;

        while (true) {
            System.out.println("Enter postfix: ");
            System.out.flush();
            input = getString();

            if (input.equals("")) {
                break;
            }
            Demo1_ParsePost parser = new Demo1_ParsePost(input);
            output = parser.doParse(); //通过后缀表达式计算
            System.out.println("计算结果 ：" + output);
        }
    }

    private static String getString() throws IOException {

        BufferedReader buffR = new BufferedReader(new InputStreamReader(System.in));
        String s = buffR.readLine();
        return s;
    }
}
