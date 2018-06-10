package pers.cabin.jichu.a6_java._default;

/**
 * Created by caiping on 2017/9/21.
 */
public interface A {
    default String a(String string) {
        if (string == null) {
            return "hello a";
        }
        return string;
    }

    Integer a1();
}
