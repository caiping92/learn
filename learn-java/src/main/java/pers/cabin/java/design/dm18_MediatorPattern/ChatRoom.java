package pers.cabin.java.design.dm18_MediatorPattern;

import java.util.Date;

/**
 * Created by caiping on 2017/3/3.
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}
