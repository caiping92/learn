package mogujie;

import java.util.Scanner;

/**
 * Created by caiping on 2017/9/23.
 */
public class Test2 {
        public static void main(String[] args) {


            Scanner in = new Scanner(System.in);
            int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};
            int days2[] = {31,29,31,30,31,30,31,31,30,31,30,31};
            while (in.hasNextInt()) {//注意while处理多个case
                String strings[] = in.nextLine().split(" ");
                int allDay = 0;
                if (Integer.parseInt(strings[0])%4==0){
                    allDay = getAllDay(strings, days2);
                    System.out.println(allDay);
                }else {
                    allDay = getAllDay(strings, days);
                    System.out.println(allDay);
                }

            }
        }
        public static int getAllDay(String[] strings,int[] days){
            int allDay = 0;

            int mouth = Integer.parseInt(strings[1]);
            for (int i = 0; i < mouth-1; i++) {
                allDay += days[i];
            }
            allDay += Integer.parseInt(strings[2]);

            return allDay;
        }

}
