package pers.cabin.learn.chaptor01;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by caiping on 2017/9/15.
 */
public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }
    public Stack() {

    }

    /**
     * 压栈
     * @param item
     */
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    /**
     * 弹栈（获取栈顶元素，并移除）
     * @return
     */
    public Item pop() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

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
