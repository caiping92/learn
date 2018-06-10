package pers.cabin.learn.chaptor01.sort;

/**
 * Created by caiping on 2017/9/15.
 */
public class Example {

    public static void sort(Comparable[] arr) {

    }

    /**
     * v 是否比 w 小
     * null 是小的
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        if (v == null) {
            return true;
        }
        if (w == null) {
            return false;
        }
        return v.compareTo(w) < 0;
    }

    /**
     * 交换数组arr i 和j 的位置
     * @param arr
     * @param i
     * @param j
     */
    private static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 打印单行数组
     * @param arr
     */
    public static void show(Comparable[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否有序 (升序)
     */
    public static boolean isSorted(Comparable[] arr) {
        for (int i=1;i<arr.length;i++) {
            if (less(arr[i], arr[i - 1])) { // 后一个比前一个小
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){

        String[] arr = {"a", "1", "2", "3", "aa"};
        show(arr);
        Example.sort(arr);
        show(arr);

    }
}
