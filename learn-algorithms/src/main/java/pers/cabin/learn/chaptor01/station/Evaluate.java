package pers.cabin.learn.chaptor01.station;

import java.util.Stack;

/**
 * + - * / biaodashi 运算器
 *
 * stack 应用场景
 *
 * Created by caiping on 2017/9/15.
 */
public class Evaluate {


    /**
     * 计算表达式的值
     *
     * 双栈表达式求值
     * @param str
     * @return
     */
    public static Double evl(String str) {
        if (str == null || str.trim().equals("")) {
            return null;
        }
        //双栈，一个存 运算符，一个存值
        java.util.Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        str = str.trim();

        String[] sourcs = str.split("");
        String t = null;
        //字符串解析
        for (int i=0;i<sourcs.length;i++) {
            t=sourcs[i];
            if (t.equals("(")) {

            } else if (t.equals("+")) {
                ops.push(t);
            } else if (t.equals("-")) {
                ops.push(t);
            } else if (t.equals("*")) {
                ops.push(t);
            } else if (t.equals("/")) {
                ops.push(t);
            } else if (t.equals(")")) { //如果为 “)”则弹栈
                String op = ops.pop();
                Double v = vals.pop();

                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    if (v != 0) {
                        v = vals.pop() / v;
                    }
                }
                vals.push(v);

            } else {
                try {
                    vals.push(Double.parseDouble(t));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    throw new RuntimeException(t+" 不是数值！");
                }

            }
        }
        return vals.pop();


    }
}
