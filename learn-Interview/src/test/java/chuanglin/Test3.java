package chuanglin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 *   1.获取日期，并进行判断
 2.获取字符串
 3.用 0 1 2 角标，分别对应 source1 source2 source3
 4.对组号进行旋转加密
 5.对每个组中的source1 source2 source3 进行旋转加密

 6.对每个字符串进行查找 index
 7.查找旋转后的组对应的位置

 * Created by caiping on 2017/9/28.
 */
public class Test3 {

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

    private static String getCode(String encodeStr, Integer m, Integer d) {

        if (encodeStr == null || encodeStr.equals("")) {
            return "";
        }
        String aimSource = encodeStr.replaceAll(" ", "*");

        String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ*";
        int innerTotal = 9;
        int zuSize = source.length() / innerTotal;
        String str1 = source.substring(0, innerTotal);
        String str2 = source.substring(innerTotal, innerTotal* 2);
        String str3 = source.substring(innerTotal*2);

        String[] zu = {str1,str2,str3};
        String[] newSourceArr = moveArrayElement(zu, m);

        //组内元素加密
        for (int i=0;i<newSourceArr.length;i++) {
            char[] tmp = newSourceArr[i].toCharArray();
            newSourceArr[i] = new String(moveArrayElement(tmp, d)) ;
        }

        //查找位置
        char[] str_encode = aimSource.toCharArray();
        List<String> position = new ArrayList<>();
        int index = -1;
        for (int i=0;i<str_encode.length;i++) {//对每个位置进行加密
            for (int j=0;j<zuSize;j++) {
                index = zu[j].indexOf(str_encode[i]);
                if (index >= 0) {//在角标i 中查到 index 位置 为当前元素位置
                    position.add((j + 1)+"" + (index + 1));
                    index=-1;
                    break;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<position.size();i++) {
            if (i != position.size() - 1) {
                stringBuffer.append(position.get(i) + " ");
            } else {
                stringBuffer.append(position.get(i));
            }
        }


        return stringBuffer.toString();
    }




    public static String[] moveArrayElement(String[] array, int k) {
        int length = array.length;
        // 右移newk + n * length个位置，和右移newk个位置效果是一样的
        int newk = k % length;
        String[] newArray = new String[length];
        // 重复length次把元素从旧位置移到新位置
        for(int i = 0; i < length; i++) {
            // 求出元素新的位置
            int newPosition = (i + newk) % length;
            newArray[newPosition] = array[i];
        }
        return newArray;
    }

    public static char[] moveArrayElement(char[] array, int k) {
        if (array == null) {
            return new char[0];
        }
        int length = array.length;
        if (length == 0) {
            return new char[0];
        }
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
