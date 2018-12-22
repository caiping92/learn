package pers.cabin.java.struct.sort;

import org.junit.Test;

public class Test1_Shell {

    @Test
    public void testArrSh() {
        ArrSh arrSh = new ArrSh(10);

        for (int i = 0; i < arrSh.size(); i++) {
            long n = (long) (Math.random() * 99);
            arrSh.insert(n);
        }

        arrSh.displayArrSh();

        arrSh.shellSort();
        arrSh.displayArrSh();
    }

}

class ArrSh {
    private long[] theArr;
    private int nElems;

    //	----------------------
    public ArrSh(int nElems) {
        super();
        theArr = new long[nElems];
    }

    //	-----------------
    public int size() {
        return theArr.length;
    }

    //	-------------------
    public void insert(long value) {
        theArr[nElems] = value;
        nElems++;
    }

    //	--------------
    public void displayArrSh() {
        System.out.print("ArrSh:");
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArr[i] + " ");
        }
        System.out.println(" ");
    }
//	--------------------

    /**
     * <red>该希尔排序 有问题！！！！！</red>
     */
    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = theArr[outer];
                inner = outer;
                while (inner > h - 1 && theArr[inner - h] >= temp) {
                    theArr[inner] = theArr[inner - h];
                    inner = h;
                }

                theArr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
