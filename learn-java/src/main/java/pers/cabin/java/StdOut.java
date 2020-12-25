package pers.cabin.java;

public class StdOut {
    private StdOut(){}

    public static <T> void println(T t) {
        System.out.println(t);
    }

    public static <T> void print(T t) {
        System.out.print(t);
    }
}
