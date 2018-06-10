package migu;

import java.util.Scanner;

/**
 *
 * 小明很喜欢打字，今天小红给了小明一个字符串。这个字符串只包含大写和小写字母。我们知道，按下CapsLock键，可以切换大小写模式。我们在小写模式时候，同时按下shift+字母键，就能写出大写字母。在大写模式的时候，按下shift+字母键，就能写出小写字母。现在问题来了，给你一个字符串，问你最少使用多少个按键，就可以写出这个字符串呢？注意，按shift和字母键，算两次按键。开始时均为小写状态
 * Created by caiping on 2017/10/20.
 */
public class Test_1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入有几个：");
        String str_len = scanner.nextLine();
        System.out.println("请分别输入字符串长度，没输入一个后回车确定");

        String[] input = new String[Integer.parseInt(str_len)];
        for(int i=0;i<input.length;i++) {
            System.out.println("请输入地"+(i+1)+"个字符串");
            input[i] = scanner.nextLine();
        }
        int[] resu = new int[input.length];
        getTotalKeyPress(input,resu,false);

        //输出返回结果
        for (int i=0;i<resu.length;i++) {
            System.out.println(resu[i]);
        }
    }

    /**
     * 每个字符串需要敲几下
     * input.length=resu.length; 否则失败
     * @param input
     * @param resu
     * @param isCapslock 大小写是否开启
     */
    private static void getTotalKeyPress(String[] input, int[] resu,boolean isCapslock) {
        if (input.length != resu.length) {
            throw new RuntimeException("输入的结果和返回的结果 数组大小不一致，必须一致，一个字符串对应一次键盘的敲入");
        }
        for (int i=0;i<resu.length;i++) {
            resu[i]=getSigleStrKeyPress(input[i],isCapslock);
        }
    }


    /**
     *
     * 两个相同的代替一个capslock建
     *
     * 利用二叉树 记录  利用二叉树 ，二叉树的值为 true  or false  然后 遍历二叉树的值，求出最小值
     *
     * AAaAaaaA
     *
     * @param str
     * @param isCapslock
     * @return
     */
    private static int getSigleStrKeyPress(String str, boolean isCapslock) {

        int count = 0;
        if (str == null) {
            return -1;
        }
        if (str.length() == 1) {
            char[] chars = str.toCharArray();
            if (Character.isLowerCase(chars[0])) {
                if (!isCapslock) {//没有开启大写键
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        //2个以上




        return count;
    }
}
