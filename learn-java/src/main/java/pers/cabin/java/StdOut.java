package pers.cabin.java;

public class StdOut {

    private static final String DEFAULT_LINE_STR = "-";

    public static <T> void println(T t) {
        System.out.println(t);
    }

    public static <T> void print(T t) {
        System.out.print(t);
    }

    public static void line() {
        line(20);
    }

    public static void line(int width) {
        repeat(DEFAULT_LINE_STR, width);
    }

    public static void repeat(String v, int width) {
        for (int i = 0; i < width; i++) {
            print(v);
        }
        println("");
    }

    private StdOut(){}

}
