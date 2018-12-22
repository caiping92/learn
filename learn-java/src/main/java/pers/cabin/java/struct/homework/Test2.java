package pers.cabin.java.struct.homework;

/**
 * 实现一个基于双向链表的双端队列。使用者能够执行双端队列的基本操作
 *
 * @author caiping
 */
public class Test2 {

    public static void main(String[] args) {
        DoublyQueue queue = new DoublyQueue();

        Data d1 = new Data("張三", 13);
        Data d2 = new Data("李四", 14);
        Data d3 = new Data("王五", 15);
        Data d4 = new Data("趙六", 16);
        Data d5 = new Data("田七", 17);
        Data d6 = new Data("胡八", 18);

        queue.addLast(d1);
        queue.addLast(d2);
        queue.addLast(d3);
        queue.addLast(d4);
        queue.addLast(d5);
        queue.addFirst(d6);

        System.out.println("--插入完毕-------------");
        queue.showDoublyQueue();
        System.out.println();

        System.out.println();
        System.out.println("--移除队首-------------");
        queue.removeFirst();
        queue.showDoublyQueue();
        System.out.println();

        System.out.println();
        System.out.println("--移除队尾-------------");
        queue.removeLast();
        queue.showDoublyQueue();

    }
}

//=====================================================

/**
 * 双向链表的双向队列
 *
 * @author caiping
 */
class DoublyQueue {

    private class Node {
        Data data;
        Node next;
        Node previous;

        //		-------------------------
        public Node(Data data) {
            super();
            this.data = data;
        }

        //		------------------------
        public void showNode() {
            System.out.print(this.data.toString());
        }

    }//End Node

    //	-----------------------------
    private Node first;
    private Node last;

    //	-----------------------------
    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    //	---------------------------------
    public DoublyQueue() {
        super();
    }

    //	-----------------
    public boolean isEmpty() {
        return this.getFirst() == null;
    }

//----------------

    public void addFirst(Data newData) {
        Node newNode = new Node(newData);
        if (this.getFirst() == null) {
            this.setFirst(newNode);
            this.setLast(newNode);
            return;
        }
        this.getFirst().previous = newNode;
        newNode.next = this.getFirst();
        this.setFirst(newNode);

    }

    public void addLast(Data newData) {
        Node newNode = new Node(newData);
        if (this.isEmpty()) {
            this.setLast(newNode);
            this.setFirst(newNode);
            return;
        }
        this.getLast().next = newNode;
        newNode.previous = this.getLast();
        this.setLast(newNode);

    }

    //	---------------
    public void removeFirst() {
        Node temp = this.getFirst().next;
        temp.previous = null;
        this.setFirst(temp);
    }

    public void removeLast() {
        Node temp = this.getLast().previous;
        temp.next = null;
        this.setLast(temp);
    }

    //	-------------------
    public void showDoublyQueue() {
        if (isEmpty()) {
            System.out.println("此队列为： null");
            return;
        }
        Node current = this.getFirst();
        while (true) {
            current.showNode();
            current = current.next;
            if (current == null) {
                break;
            }

        }
    }
}

//================================
class Data {

    private String name;
    private int age;

    //	-----
    public Data(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //	-----
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//	-----------

    @Override
    public String toString() {
        return "[name:" + name + ", ag:" + age + "] ";
    }

}