package pers.cabin.jichu.a6_java._iterable;

/**
 * Created by caiping on 2017/10/11.
 */
public class TestMyString {
    public static void main(String[] args){

        MyString t = new MyString("abcd123");

        System.out.println(t);
        for (Character c : t) {
            System.out.print(c+" ");
        }
        System.out.println();
        System.out.println(t);
    }

}
