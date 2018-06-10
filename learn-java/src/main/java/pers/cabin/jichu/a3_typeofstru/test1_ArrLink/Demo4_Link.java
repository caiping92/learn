package pers.cabin.jichu.a3_typeofstru.test1_ArrLink;

public class Demo4_Link {
    private long dData;
    private Demo4_Link next;
    private Demo4_Link previous;

    //	--------------------------------
    public long getdData() {
        return dData;
    }

    public void setdData(long dData) {
        this.dData = dData;
    }

    public Demo4_Link getNext() {
        return next;
    }

    public void setNext(Demo4_Link next) {
        this.next = next;
    }

    public Demo4_Link getPrevious() {
        return previous;
    }

    public void setPrevious(Demo4_Link previous) {
        this.previous = previous;
    }

    //	------------------------------------------
    public Demo4_Link(long dData) {
        super();
        this.dData = dData;
    }

    //	------------------------------------------
    public void displayLink() {
        System.out.print(dData + " ");
    }
}
