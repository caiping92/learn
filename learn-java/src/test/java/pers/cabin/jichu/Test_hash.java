package pers.cabin.jichu;

/**
 * Created by caiping on 2017/10/20.
 */
public class Test_hash {


    public static void main(String[] args){
        String str = "hahah";
        System.out.println(str.hashCode());
        System.out.println(hash(str));
        System.out.println((6 - 1) & hash(str));

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
