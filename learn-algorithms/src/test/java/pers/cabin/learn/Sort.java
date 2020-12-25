package pers.cabin.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean greater(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    public <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 冒泡排序
     * O(n^2)
     * 重在冒泡，当前元素和之前的元素进行比较
     *
     * @param arr
     * @param comparator
     * @param <T>
     */
    public <T> void sortByMaoPao(T[] arr, Comparator<T> comparator) {

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[i], arr[j]) < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 选择排序
     * O(n^2)
     * 重在选择最大的/最小的，当前值和后面的值进行比较
     *
     * @param arr
     * @param comparator
     * @param <T>
     */
    public <T> void sortByXuanZe(T[] arr, Comparator<T> comparator) {

        for (int i = 0, maxIndex = arr.length - 2; i <= maxIndex; i++) {
            int tmp = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[tmp], arr[j]) < 0) {
                    tmp = j;
                }
            }
            swap(arr, i, tmp);
        }
    }


    /**
     * 插入排序。重点在 将数据分为两部分，有序和无序，从第一个元素开始，一次对数据进行插入排序，就像扑克牌排序
     * O(n^2)
     *
     * @param arr
     * @param comparator
     * @param <T>
     */
    public <T> void sortByChaRu(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(arr[j - 1], arr[j]) < 0) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }

    }

    /**
     * 希尔排序。 对插入排序的优化。缩短交换次数
     *
     * @param arr
     * @param comparator
     * @param <T>
     */
    public <T> void sortByXiEr(T[] arr, Comparator<T> comparator) {


        //确定宽度
        int h = 1;
        int maxH = arr.length / 2;
        while (h < maxH) {
            h = 2 * h + 1;
        }

        for (; h >= 1; h--) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (comparator.compare(arr[j - h], arr[j]) < 0) {
                        swap(arr, j - h, j);
                    } else {
                        break;
                    }
                }
            }
        }


    }

    /**
     * O(nlogn)
     *
     * @param arr
     */
    public void sortByGuiBing(Comparable[] arr) {
        Comparable[] assis = new Comparable[arr.length];
        int low = 0;
        int high = arr.length - 1;
        sortByGuiBing(arr, low, high, assis);
    }

    public void sortByGuiBing(Comparable[] arr, int low, int high, Comparable[] assis) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sortByGuiBing(arr, low, mid, assis);
        sortByGuiBing(arr, mid + 1, high, assis);
        sortByGuiBingMerge(arr, low, mid, high, assis);

    }

    public void sortByGuiBingMerge(Comparable[] arr, int low, int mid, int high, Comparable[] assis) {
        int i = low;
        int plow = low;
        int phigh = mid + 1;
        while (plow <= mid && phigh <= high) {
            if (arr[plow].compareTo(arr[phigh]) < 0) {
                assis[i++] = arr[phigh++];
            } else {
                assis[i++] = arr[plow++];
            }
        }

        while (plow <= mid) {
            assis[i++] = arr[plow++];
        }
        while (phigh <= high) {
            assis[i++] = arr[phigh++];
        }
        for (int j = low; j <= high; j++) {
            arr[j] = assis[j];
        }
    }

    /**
     * O(nlogn) ~ O(n^2)
     * 平均情况O(nlogn)
     *
     * @param arr
     */
    public void sortByQuick(Comparable[] arr) {

        int plow = 0;
        int phigh = arr.length - 1;

        sortByQuick(arr, plow, phigh);
    }

    private void sortByQuick(Comparable[] arr, int plow, int phigh) {

        if (phigh <= plow) {
            return;
        }
        int p = partition(arr, plow, phigh);
        sortByQuick(arr, plow, p - 1);
        sortByQuick(arr, p + 1, phigh);
    }

    /**
     * 对数组进行分组
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int partition(Comparable[] arr, int low, int high) {

        //默认分界值为第一个
        Comparable key = arr[low];
        int left = low;
        int right = high + 1;
        while (true) {
            //找出比分解值小的元素
            while (less(key, arr[--right])) {
                if (right == low) {
                    break;
                }
            }
            //找出比分解值大的元素
            while (less(arr[++left], key)) {
                if (left >= high) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                swap(arr, left, right);
            }
        }
        swap(arr, low, right);
        return right;
    }


    @Test
    public void testMaoPao() {

        Integer[] arr = {1, 5, 4, 5, 7, 9, 0, 7, 85, 5, 7};

        System.out.println("before: " + Arrays.toString(arr));
        sortByMaoPao(arr, (a, b) -> a - b);
        System.out.println("after: " + Arrays.toString(arr));

    }

    @Test
    public void testXuanZe() {

        Integer[] arr = {1, 5, 4, 5, 7, 9, 0, 7, 85, 5, 7};

        System.out.println("before: " + Arrays.toString(arr));
        sortByXuanZe(arr, (a, b) -> a - b);
        System.out.println("after: " + Arrays.toString(arr));

    }

    @Test
    public void testChaRu() {

        Integer[] arr = {1, 5, 4, 5, 7, 9, 0, 7, 85, 5, 7};

        System.out.println("before: " + Arrays.toString(arr));
        sortByChaRu(arr, (a, b) -> a - b);
        System.out.println("after: " + Arrays.toString(arr));
        sortByChaRu(arr, (a, b) -> b - a);
        System.out.println("after: " + Arrays.toString(arr));

    }

    @Test
    public void testXiEr() {

        Integer[] arr = {1, 5, 4, 5, 7, 9, 0, 7, 85, 5, 7};

        System.out.println("before: " + Arrays.toString(arr));
        sortByXiEr(arr, (a, b) -> a - b);
        System.out.println("after: " + Arrays.toString(arr));

    }

    @Test
    public void testGuiBing() {

        Integer[] arr = {1, 5, 4, 5, 7, 9, 0, 7, 85, 5, 7};

        System.out.println("before: " + Arrays.toString(arr));
        sortByGuiBing(arr);
        System.out.println("after: " + Arrays.toString(arr));

    }

    @Test
    public void testQuick() {

        Integer[] arr = {1, 5, 4, 5, 7, 9, 0, 7, 85, 5, 7};

        System.out.println("before: " + Arrays.toString(arr));
        sortByQuick(arr);
        System.out.println("after: " + Arrays.toString(arr));

    }
}
