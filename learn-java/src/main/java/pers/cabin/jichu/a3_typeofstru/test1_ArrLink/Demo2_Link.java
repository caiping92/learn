package pers.cabin.jichu.a3_typeofstru.test1_ArrLink;

public class Demo2_Link {

    private int iData;
    private double dData;
    private Demo2_Link next;

    //	------------------
    public Demo2_Link(int iData, double dData) {
        super();
        this.iData = iData;
        this.dData = dData;
    }

    //	-----------------------------------------
    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public double getdData() {
        return dData;
    }

    public void setdData(double dData) {
        this.dData = dData;
    }

    public Demo2_Link getNext() {
        return next;
    }

    public void setNext(Demo2_Link next) {
        this.next = next;
    }

    //----------------------------------------
    public void displayLink() {
        System.out.println("{" + iData + "," + dData + "}");
    }
}
