package pers.cabin.java.struct.list;

public class Demo2_LinkList {

    private Demo2_Link first;
//	---------------------

    public Demo2_LinkList() {
        super();
        this.first = null;    // 可以不要，引用类型在创建之初会自动赋值 null
    }

    //	---------------------
    public boolean isEmpty() {    //判断链表是否为空，只需要判断第一个是否为空即可
        return first == null;
    }
//	-----------------------------

    /**
     * 在该链表中头部插入一个节点
     *
     * @param i iData
     * @param d dData
     */
    public void insertFirst(int i, double d) {
        Demo2_Link newLink = new Demo2_Link(i, d);
        newLink.setNext(this.first);//就链表头部节点为该节点的下一个
        this.first = newLink;//头部节点为该节点
    }
//	------------------------------------------------

    /**
     * 返回 被删除的头部节点
     *
     * @return
     */
    public Demo2_Link deleteFirst() {
        if (this.first == null) {    //如过为空链表，也就是首即额点没有，则返回空，也就是没有删除节点
            return null;
        }

        Demo2_Link tmp = this.first;
        this.first = tmp.getNext();
        return tmp;
    }

    //	---------------------------------
    public void displayList() {
        System.out.println("List (first -> last): ");
        Demo2_Link current = this.first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println(" ");
    }

    //----------------------
    public static void main(String[] args) {
        Demo2_LinkList theList = new Demo2_LinkList();

        theList.insertFirst(1, 1.99);
        theList.insertFirst(2, 2.99);
        theList.insertFirst(3, 3.99);
        theList.insertFirst(4, 4.99);

        theList.displayList();
    }
}
