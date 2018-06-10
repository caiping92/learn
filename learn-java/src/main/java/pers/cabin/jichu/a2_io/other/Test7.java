package pers.cabin.jichu.a2_io.other;

/**
 * Created by cc on 2016/11/14.
 */
public class Test7 {

    public int aaa() {
        int x = 1;

        try {
            return ++x;
        } catch (Exception e) {

        } finally {
            ++x;
        }
        return x;
    }

    public static void main(String[] args) {
        Test7 t = new Test7();
        int y = t.aaa();
        System.out.println(y);
    }
}
