package chuanglin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 李雷和韩梅梅坐前后排，上课想说话怕被老师发现，所以改为传小纸条。为了不被老师发现他们纸条上说的是啥，他们约定了如下方法传递信息：
 将26个英文字母（全为大写），外加空格，一共27个字符分成3组，每组9个。也就是ABCDEFGHI是第一组，JKLMNOPQR是第二组，STUVWXYZ*是第三组（此处用*代表空格）。 然后根据传递纸条那天的日期，改变字母的位置。
 先根据月份数m，以整个分组为单位进行循环左移，移动(m-1)次。
 然后根据日期数d，对每个分组内的字符进行循环左移，移动(d-1)次。
 以3月8日为例，首先移动分组，3月需要循环左移2次，变成：
 STUVWXYZ*，ABCDEFGHI，JKLMNOPQR
 然后每组内的字符，8日的话需要循环左移7次，最终的编码为：
 Z*STUVWXY，HIABCDEFG，QRJKLMNOP
 对于要传递信息中的每个字符，用组号和组内序号两个数字来表示。
 如果在3月8日传递信息“HAPPY”，那么H位于第2组的第1个，A位于第2组第3个，P位于第3组第9个，Y位于第1组第9个，所以纸条上会写成：
 21 23 39 39 19
 现在给定日期和需要传递的信息，请输出应该写在纸条上的编码。

 输入规范：
 每个输入包含两行。第一行是用空格分隔的两个数字，第一个数字是月份，第二个数字是日子。输入保证是一个合法的日期。
 第二行为需要编码的信息字符串，仅由A~Z和空格组成，长度不超过1024个字符。
 输出规范：
 对每个输入，打印对应的编码，数字之间用空格分隔，每个输出占一行。

 输入示例1:
 1 1
 HI
 输出示例1:
 18 19

 输入示例2:
 3 8
 HAPPY
 输出示例2:
 21 23 39 39 19
 输入示例3:
 2 14
 I LOVE YOU
 输出示例3:
 35 25 18 12 29 31 25 23 12 28
 * Created by caiping on 2017/9/28.
 */
public class Test1 {

    private static final char BLANK = ' ';

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        String in = null;
        while ( in == null||in.equals("")) {
            System.out.println("请输入对应的日期，例如：3月8日：3 8");
            in = input.nextLine().trim();
        }
        String[] arr = in.split(" ",2);
        String str_month = arr[0].trim();
        String str_day = arr[1].trim();

        Integer m = null;
        Integer d = null;
        String encodeStr = null;
        try {
            m = Integer.parseInt(str_month.trim());
            if (m < 1 || m > 12) {
                System.out.println("输入的不是一个月份");
                return;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("输入的不是一个数字");
            return;
        }

        try {
            d = Integer.parseInt(str_day);

            //判断日期是否符合要求
            boolean ilegal =  checkDayIsIlegal(m, d);
            if (!ilegal) {
                System.out.println(m+" 月中没有 "+d);
                return;
            }

            //进行编码
            //获取需要编码的字符串
            System.out.println("输入需要加密的字符串 大写A-Z 或者空格");
//            String pattern = "[A-Z\\s]+";
            try {
//                encodeStr = input.next(pattern);
                encodeStr = input.nextLine();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("需要解码的字符不符合要求");
            }

            //获取编码
             String res =  getCode(encodeStr,m,d);
            System.out.println(res);


        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("输入的不是一个数字");
        }finally {
            input.close();
        }
    }

    /**
     * 获取编码
     *
     * TODO 使用枚举，或者 三切分法
     * @param encodeStr 需要被编码的字符串
     * @param m 月份
     * @param d 日期
     * @return 返回 例如： 35 25 18 12 29 31 25 23 12 28
     */
    private static String getCode(String encodeStr, Integer m, Integer d) {

        String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + BLANK;
        char[] source1 = {'A','B','C','D','E','F','G','H','I'};
        char[] source2 = {'J','K','L','M','N','O','P','Q','R'};
        char[] source3 = {'S','T','U','V','W','X','Y','Z',BLANK};

        if (encodeStr == null || encodeStr.trim().equals("")) {
            return null;
        }
        if (m == null || d == null) {
            return null;
        }

        //月份加密
        int[] zu = {1,2,3};//分别代表 1 组 2 组 3 组
        int[] res_zu = moveArrayElement(zu, m);

        //天数加密
        moveArrayElement(source1,d);
        moveArrayElement(source2,d);
        moveArrayElement(source3,d);

        //合并为新的 源
        List newSource = new ArrayList();
        for (int a=0;a<res_zu.length;a++) {
            int i1 = res_zu[a];
            switch (i1) {
                case 1:{
                    for (int zz=0;zz<source1.length;zz++) {
                        newSource.add(source1[zz]);
                    }
                    break;
                }
                case 2:{
                    for (int zz=0;zz<source2.length;zz++) {
                        newSource.add(source2[zz]);
                    }
                    break;
                }
                case 3:{
                    for (int zz=0;zz<source3.length;zz++) {
                        newSource.add(source3[zz]);
                    }
                    break;
                }
            }
        }

        //获取字符串的位置
        char[] split = encodeStr.toCharArray();
        List<String> res_list = new ArrayList<String>();

        for (int i=0;i<split.length;i++) { //一个一个查找
            char aim = split[i];
            int index = (newSource.indexOf(aim))%3+1;
            int resZuIndex = newSource.size() % 9;
            res_list.add((resZuIndex+1) + index + "");
            resZuIndex=-1;
            index = -1;
        }

        String res = null;
        for (int i=0;i<res_list.size();i++) {
            if (i != res_list.size() - 1) {//不是最后一个
                res += res_list.get(i)+BLANK;
            }
            res += res_list.get(i);
        }

        return res;
    }




    public static int[] moveArrayElement(int[] array, int k) {
        int length = array.length;
        // 右移newk + n * length个位置，和右移newk个位置效果是一样的
        int newk = k % length;
        int[] newArray = new int[length];
        // 重复length次把元素从旧位置移到新位置
        for(int i = 0; i < length; i++) {
            // 求出元素新的位置
            int newPosition = (i + newk) % length;
            newArray[newPosition] = array[i];
        }
        return newArray;
    }

    public static char[] moveArrayElement(char[] array, int k) {
        int length = array.length;
        // 右移newk + n * length个位置，和右移newk个位置效果是一样的
        int newk = k % length;
        char[] newArray = new char[length];
        // 重复length次把元素从旧位置移到新位置
        for(int i = 0; i < length; i++) {
            // 求出元素新的位置
            int newPosition = (i + newk) % length;
            newArray[newPosition] = array[i];
        }
        return newArray;
    }

    /**
     * 检查日期是否符合要求
     * @param m
     * @param d
     * @return
     */
    private static boolean checkDayIsIlegal(Integer m, Integer d) {
        return true;
    }

}
