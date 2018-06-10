package pers.cabin.learn.chaptor01;

import java.util.*;
import java.util.function.Consumer;

/**
 * 背包是一种不支持删除元素的集合数据类型
 *  目的：收集帮助用力收集元素并迭代遍历所有收集的元素
 * Created by caiping on 2017/9/15.
 */
public class Bag<Item> implements Iterable<Item> {

    private Node<Item> first;
    /**
     * 背包大小
     */
    private int  n;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public Bag() {
    }

    /**
     * 添加一个元素
     * @param item
     */
    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    /**
     * 背包是否weinull
     * @return
     */
    public boolean isEmpty() {
        if (first == null || n == 0) {
            return true;
        }
        return false;
    }

    /**
     * 背包大小
     * @return
     */
    public int size() {
        return n;
    }


    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {

    }

    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }
}
