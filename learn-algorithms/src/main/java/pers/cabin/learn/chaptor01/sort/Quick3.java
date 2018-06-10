package pers.cabin.learn.chaptor01.sort;

/**
 * Created by caiping on 2017/9/18.
 */
public class Quick3 {

    public static <T extends Comparable<? super T>> void quickSort(T arr[] ){
        _quickSort(arr, 0, arr.length - 1);
    }
    private static <T extends Comparable<? super T>> int getMiddle(T list[], int low, int high) {
        T temp = list[low];
        while (low<high){
            while (low<high&&list[high].compareTo(temp)>=0){
                high--;
            }
            list[low]=list[high];
            while (low<high&&list[low].compareTo(temp)<=0){
                low++;
            }
            list[high]=list[low];
        }
        list[low] = temp;
        return low;
    }
    private static <T extends Comparable<? super T>> void _quickSort(T[] list, int low, int high) {
        if (low < high) {
            int mid = getMiddle(list, low, high);
            _quickSort(list, low, mid - 1);
            _quickSort(list, mid + 1, high);
        }
    }
}
