package pers.cabin.learn.chaptor01.sort;

/**
 * 插入排序
 *  例如：整理桥牌，一张一张来，将每一张牌插入到其他已经有序的牌中
 *
 *
 * Created by caiping on 2017/9/15.
 */
public class Insertion implements Sort {
    @Override
    public void sort(Comparable[] arr) {

        int n = arr.length;

        for (int i=1;i<n;i++) {
            //将 arr[i] 插入到剩下的元素中
            for (int j=i;j>0&& less(arr[j],arr[j-1]);j--) {
                exch(arr,j,j-1);
            }
        }
    }

//    --------------
    public static void main(String[] args){
        Insertion insertion = new Insertion();
        Integer[] arr = {11, 2, 1, 25, 4, -1};
//        String[] arr ={"A","a","B","b","M","","m"};
        insertion.show(arr);
        insertion.sort(arr);
        insertion.show(arr);
    }
}
