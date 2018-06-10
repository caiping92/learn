package mogujie;

import java.util.Scanner;

/**
 * Created by caiping on 2017/9/23.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入年份：");
        int year = sc.nextInt();
        System.out.print("请输入月份：");
        int month = sc.nextInt();
        System.out.print("请输入日：");
        int day = sc.nextInt();

        int currentYearCount = getCurrentYearCount(year, month, day);
        System.out.println(year + "年" + month + "月" + day + "日是" + year + "年的第" + currentYearCount + "天");
    }

    /**
     * 获取当前日期的是当前年的第几天
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int getCurrentYearCount(int year, int month, int day) {
        int count = 0;//默认第0天
        int days = 0;//一个月有多少天
        if (year > 0 && month > 0 && month < 13 && day > 0 && day < 32) {
            for (int i = 1; i < month; i++) {
                switch (i) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        days = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        days = 30;
                        break;
                    case 2: {
                        if ((year % 4 == 0 && year % 1 != 0) || (year % 400 == 0)) {
                            days = 29;
                        } else {
                            days = 28;
                        }
                        break;
                    }
                }
                count += days;
            }
            count += day;
        }
        return count;
    }
}
