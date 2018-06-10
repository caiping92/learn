package pers.cabin.learn.chaptor01.sort;

/**
 * 所有排序的方法都共有的 方法
 * Created by caiping on 2017/9/15.
 */
public interface Sort {

    /**
     * 对数组arr 进行排序
     * @param arr
     */
   void sort(Comparable[] arr);
    /**
     * 判断v 是否比w 小
     * @param v
     * @param w
     * @return
     */
    default boolean less(Comparable v, Comparable w) {
        if (v == null) {
            return true;
        }
        if (w == null) {
            return false;
        }
        return v.compareTo(w)<0;
    }

    /**
     * 交换数组arr 中 i 和j 的位置
     * @param arr
     * @param i
     * @param j
     */
    default void exch(Comparable[] arr, int i, int j) {
        if (arr != null) {
            Comparable tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    /**
     * 打印单行数组
     * @param arr
     */
    default void show(Comparable[] arr) {
        if (arr != null) {
            for (int i=0;i<arr.length;i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 数组 arr 是否是 升序 排列
     * @param arr
     * @return
     */
    default boolean isSortedWithAsc(Comparable[] arr) {
        if (arr != null) {
            for (int i=1;i<arr.length;i++) {
                if (less(arr[i], arr[i - 1])) {
                    return false;
                }
            }
        }
        return true;
    }

    default boolean isSortedWithDesc(Comparable[] arr) {
        if (arr != null) {
            for (int i=1;i<arr.length;i++) {
                if (less(arr[i - 1], arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
