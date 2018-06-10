package pers.cabin.jichu.a3_typeofstru.test2_recursion;

import java.util.Arrays;

public class Test1_BinarySearch {

    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);
        arr.insert(12);

    }
}

class OrdArray {
    private long[] arr;
    private int nElems;
    private int idx;

    //	--------------
    public OrdArray(int nElems) { //初始化容器大小
        super();
        this.nElems = nElems;
        this.arr = new long[nElems];
    }

    //------------
    public int size() {
        return this.arr.length;
    }

    //	--------------
    public int find(long searchKey) {
        return recFind(searchKey, 0, this.nElems - 1);
    }

    /**
     * 二分查找
     *
     * @param searchKey  需要查找的值
     * @param lowerBound 起始位置
     * @param upperBound 结束位置
     * @return 返回插入值的角标
     */
    private int recFind(long searchKey, int lowerBound, int upperBound) {

        int curIn = (lowerBound + upperBound) / 2;//中间值的角标

        if (arr[curIn] == searchKey) {
            return curIn;
        } else if (lowerBound > upperBound) {    //左边大于 右边，停止二分查找，不能找到该元素
            return -1; //不能找到
        } else {
            if (this.arr[curIn] < searchKey) {
                return recFind(searchKey, curIn + 1, this.arr.length - 1);
            } else {
                return recFind(searchKey, lowerBound, curIn - 1);
            }
        }
    }

    //	-------------------
    public void insert(long value) {
        this.quickSort(this.arr);
        for (int i = 0; i < this.nElems; i++) {
            if (arr[i] == 0) {
                arr[this.idx++] = value;
            }
        }
    }

    //	------------------------
    public <T> void quickSort(long[] arr) {

        Arrays.sort(arr);
    }

    //	-----------------
    public void displayArr() {
        for (int i = 0; i < this.nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

