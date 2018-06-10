package pers.cabin.learn.chaptor01.sort;

/**
 * 快速排序
 * 一种分治的排序算法
 * 将一个数组分成2个子数组，两部分独立地排序
 * 当两个子数组都有序时，整个数组就有序了
 *
 * 三向切分的快速排序：
 *      从左到右比那里数组一次，维护一个指针 lt 是的 a[low.. lt-1[中的所有元素小于v
 *      一个指针 gt 是的 arr[gt+1 ... high] 中的所有元素都大于v
 *      一个指针 i 是的 arr[lt..i-1] 中的所有元素都等于v
 *      arr[i ... gt]中的元素还没有确定
 *
 *      arr[i] < v , arr[lt] arr[i] 交换，将 lt 和 i+1
 *      arr[i]> v , arr[gt] arr[i] 交换，gt--1
 *      arr[i] = v ,i++
 *      这些操作都会保证数组元素不变切缩小gt-i的值（这样循环才能结束），除非和切分元素相等，否则其他元素都会被替换掉
 *
 * Created by caiping on 2017/9/16.
 */
public class Quick implements Sort {
    @Override
    public void sort(Comparable[] arr) {
        sort(arr,0, arr.length-1);
    }

    private void sort(Comparable[] arr, int low, int high) {

        if (high <= low) {
            return;
        }

        int lt = low, i = low + 1, gt = high;
        Comparable v = arr[low];

        while (i <= gt) {
            int cmp = arr[i].compareTo(v);

            if (cmp < 0) {
                exch(arr, lt++, i++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }

        //现在arr[low,...lt-1] <v =a[lt...gt] <a[gt+1..high] 成立
        sort(arr, low, lt - 1);
        sort(arr, gt+1, high);
    }

    //---------
    public static void main(String[] args){
        Quick quick = new Quick();
        Integer[] arr = {11, 2, 1, 25, 4, -1};
//        String[] arr ={"A","a","B","b","M","","m"};
        quick.show(arr);
        quick.sort(arr);
        quick.show(arr);
    }
}
