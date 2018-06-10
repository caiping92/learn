package pers.cabin.learn.chaptor01.sort;

/**
 * 选择排序
 * 1.找到数组中最小的那个元素
 * 2.将他和数组的第一个元素交换位置（）如果是第一个元素，那么就是最小元素和自己交换
 * 3.再剩下的元素中找到最小元素，将它与第二个元素交换位置。
 * 4.重复
 *
 * 不断在选择最小元素
 *
 * Created by caiping on 2017/9/15.
 */
public class Selection implements Sort {

    @Override
    public void sort(Comparable[] arr) {
        //将arr 升序排列
        if (arr == null) {
            return;
        }
        int n = arr.length;
        for (int i=0;i<n;i++) {
            int min = i; //最小的元素
            for (int j=i+1;j<n;j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exch(arr,i,min);
        }
    }


    //---------
    public static void main(String[] args){
        Selection selection = new Selection();
//        Integer[] arr = {11, 2, 1, 25, 4, -1};
        String[] arr ={"A","a","B","b","M","","m"};
        selection.show(arr);
        selection.sort(arr);
        selection.show(arr);
    }

}
