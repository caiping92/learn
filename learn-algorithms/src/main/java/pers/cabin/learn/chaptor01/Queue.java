package pers.cabin.learn.chaptor01;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by caiping on 2017/9/15.
 */
public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int n;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Queue() {
    }

    /**
     * 添加一个元素
     * @param item
     */
    public void enqueque(Item item) {
        Node<Item> oldLast = last;

        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    /**
     * 删除最早添加的元素， 出队列
     * @return
     */
    public Item dequeque() {

        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    /**
     * 队列是否weinull
     * @return
     */
    public boolean isEmpty() {

        if (first == null || n==0) {
            return true;
        }
        return false;
    }

    /**
     * 队列中的元素数量
     * @return
     */
    public int size() {
        return n;
    }

    //TODO
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    //TODO
    @Override
    public void forEach(Consumer<? super Item> action) {

    }
    //TODO
    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }
}
