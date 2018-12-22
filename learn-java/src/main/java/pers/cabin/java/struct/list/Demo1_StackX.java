package pers.cabin.java.struct.list;

public class Demo1_StackX {
    private int maxSize;
    private int[] stackArray;
    private int top;

    //	---------------
    public Demo1_StackX(int maxSize) {    //constructor 初始化栈
        super();
        this.maxSize = maxSize;
        stackArray = new int[this.maxSize];
        this.top = -1;
    }

    //	-----------
    public void push(int j) {    //put item on top stack，入栈
        stackArray[++top] = j;
    }

    //	-----------
    public int pop() {        //弹栈
        return stackArray[top--];
    }

    //	----------
    public int peek() {        //查看栈顶元素
        return stackArray[top];
    }

    //	--------
    public boolean isEmpty() {    //判断栈是否为空
        return top == -1;
    }

    //	-------------------
    public boolean isFull() {    //判断栈是否为 满元素
        return top == maxSize;
    }

    //	---------------------------
    public int size() {        //栈的大小
        return top + 1;
    }

    //	------------------------
    public int peekN(int n) { //查看栈中的n个位置的 元素
        return stackArray[n];
    }

    //	-------------------------
    public void displayStack(String msg) {
        System.out.println(msg);
        System.out.println("Stack (bottom ->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println();
    }
}
