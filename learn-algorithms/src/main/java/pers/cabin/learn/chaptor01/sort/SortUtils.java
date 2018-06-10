package pers.cabin.learn.chaptor01.sort;

/**
 * Created by caiping on 2017/9/15.
 */
public class SortUtils {

    private static Selection selection = new Selection();

    private static Insertion insertion = new Insertion();

    /**
     * 选择排序
     * @param arr
     */
    public static void select(Comparable[] arr) {
        selection.sort(arr);
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertion(Comparable[] arr) {
        insertion.sort(arr);
    }
}
