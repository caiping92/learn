package pers.cabin.java.struct.list;

/**
 * 双向链表
 *
 * @author caiping
 */
public class Demo3_DoublyLinkerdList {

    private Link first;
    private Link last;

    //	--------------
    public Demo3_DoublyLinkerdList() {
        super();
        first = null;
        last = null;
    }

    //	------------------------
    public boolean isEmpty() {
        return first == null;
    }

    //	---------------------------
    public void insertFirst(long d) {    //在头部插入
        Link newLink = new Link(d);

        if (this.isEmpty()) {
            this.last = newLink;
        } else {
            this.first.setPrevious(newLink);    //newLink <- old first
            newLink.setNext(this.first);        //newLink -> old first
            this.first = newLink;                    //first -> newLink
        }

    }

    //	--------------------------------------
    public void insertLast(long d) {
        Link newLink = new Link(d);
        if (this.isEmpty()) {
            this.first = newLink;
        } else {
            this.last.setNext(newLink);
            newLink.setPrevious(last);
        }
        this.last = newLink;
    }

    //	-------------------------------------
    public Link deleteFirst() {
        Link tmp = this.first;
        if (this.first == null) {
            last = null;
        } else {
            this.last.getPrevious().setNext(null);
        }
        this.first = this.first.getNext();
        return tmp;
    }

    //	----------------------------------------
    public Link deleteLast() {
        Link tmp = last;
        if (this.first.getNext() == null) {    //该链表只有一个元素
            this.first = null;    //删除该元素
        } else {
            this.last.getPrevious().setNext(null);
        }
        this.last = this.last.getPrevious();
        return tmp;
    }

    //	------------------------------------------
    public boolean insertAfter(long key, long d) {
        if (this.isEmpty()) {        //如过该链表为空，则 直接在首部差入该元素，无需查找
            this.insertFirst(d);
            return true;
        }
        Link current = this.first;    //从第一个元素开始查找
        while (current.getdData() != key) {
            current = current.getNext();
            if (current == null) {
                return false;
            }
        }    //End while
        Link newLink = new Link(d);

        if (current == last) {
            newLink.setNext(null);
            last = newLink;
        } else {
            newLink.setNext(current.getNext());
            current.getNext().setPrevious(newLink);
        }
        newLink.setPrevious(current);
        current.setNext(newLink);
        return true;
    }

}

class Link {
    private long dData;
    private Link next;
    private Link previous;

    //	--------------------------------
    public long getdData() {
        return dData;
    }

    public void setdData(long dData) {
        this.dData = dData;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }

    //	------------------------------------------
    public Link(long dData) {
        super();
        this.dData = dData;
    }

    //	------------------------------------------
    public void displayLink() {
        System.out.print(dData + " ");
    }

}
