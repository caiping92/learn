package pers.cabin.jichu.a3_typeofstru.typeofStructure.homework1;

/**
 * 实现一个基于有序链表的优先级队列。
 * 队列的删除操作应个具有最小关键字的链接点
 *
 * @author caiping
 */
public class Test1 {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        priorityQueue.addNode("11");
        priorityQueue.addNode("a");
        priorityQueue.addNode("b");
        priorityQueue.addNode("c");
        priorityQueue.addNode("aa");
        priorityQueue.addNode("bb");
        priorityQueue.addNode("cc");

        priorityQueue.showPriorityQueue();
    }
}

class PriorityQueue {
    private Node first;
    private Node last;

    //	--------------------------
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

    //	-----------------------------------------
    public PriorityQueue() {
        super();
        // TODO Auto-generated constructor stub
    }

    //	---------------------------------
    public void addNode(String s) {
        Node newNode = new Node(s);

        if (this.getFirst() == null) {
            this.first = newNode;
            this.setLast(newNode);
            return;
        }

        //找出需要插入的位置
        Node current = this.getFirst();
        while (priority(newNode, current)) {
            if (current == last) {
                break;
            }
            current = current.getNext();
        }//End while

        //插入节点
        if (newNode.getS().compareTo(this.getFirst().getS()) < 0) {
            newNode.setNext(this.getFirst());
            this.setFirst(newNode);

        } else if (current == this.getLast()) {
            current.setNext(newNode);
            this.setLast(newNode);
        } else {
            Node tmp = current.getNext();
            current.setNext(newNode);
            newNode.setNext(tmp);
        }
    }

    public void showPriorityQueue() {
        Node current = this.getFirst();
        if (current == null) {
            System.out.println("此单项队列为空");
            return;
        }

        while (current != this.getLast()) {
            current.showNode();
            current = current.getNext();
        }
        System.out.println();//换行。因为Node 中的showNode 没有换行

    }

    /**
     * 判断两个节点的优先级
     *
     * @param newNode 需要插入的节点
     * @param current 比较的节点
     * @return true --> 插入节点(newNode) 优于 当前节点(current)
     */
    public boolean priority(Node newNode, Node current) {
        return newNode.getS().compareTo(current.getS()) > 0;
    }
}

class Node {
    private String s;
    private Node next;
    private Node privous;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrivous() {
        return privous;
    }

    public void setPrivous(Node privous) {
        this.privous = privous;
    }

    //	---------------------------------
    public Node(String s) {
        super();
        this.s = s;
    }

    //	------------------------------
    public void showNode() {
        System.out.print("{" + this.getS() + "} ");
    }

}