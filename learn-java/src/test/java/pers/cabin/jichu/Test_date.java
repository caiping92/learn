package pers.cabin.jichu;

import java.util.Calendar;

/**
 * Created by caiping on 2017/10/19.
 */
public class Test_date {


    public static void main(String[] args){


        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_YEAR);

        System.out.println(i);
    }
}
