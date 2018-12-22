package pers.cabin.java.base.scanner;

import java.util.Scanner;

/**
 * Created by caiping on 2017/9/22.
 */
public class Demo1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String next = scanner.next();
        System.out.println(next);
        String next1 = scanner.next("\\w");
        System.out.println(next1);
        System.out.println("nextInt");
        System.out.println(scanner.nextInt());

        scanner.close();

    }
}
