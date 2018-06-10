package pers.cabin.learn.chaptor01.sort;

/**
 * 希尔排序
 * 基于插入排序的快速的排序算法
 * 对于大规模乱序数组插入排序很慢，因为他只是会交换相邻的元素，
 * 思想：
 * 使用数组中惹你间隔为h的元素都是有序的。这样的数组被称为h有序数组。
 * 如果h很大，我们就能将元素移动到很远的地方，为实现更小的h有序创造方便。
 * 对于任意以1结尾的h序列，我们都能够将数组进行排序
 * Created by caiping on 2017/9/15.
 */
public class Shell implements Sort {
    //---------
    public static void main(String[] args) {
        Shell shell = new Shell();
        Integer[] arr = {11, 2, 1, 25, 4, -1};
//        String[] arr ={"A","a","B","b","M","","m"};
        shell.show(arr);
        shell.sort(arr);
        shell.show(arr);
    }

    //TODO 有问题！！！
    @Override
    public void sort(Comparable[] arr) {
        //将 arr[] 按升序排列
        int N = arr.length;
        int h = 1;

        while (h < (N / 3)) {
            h = 3 * h + 1;// 1,4,13,40,121...,
        }
        while (h >= 1) {
            //将h数组变为h有序
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) { //如果 j 元素比 j-h要大，则交换位置
                    exch(arr, j, j - h);
                }
                h = h / 3;
            }
        }
    }

}
