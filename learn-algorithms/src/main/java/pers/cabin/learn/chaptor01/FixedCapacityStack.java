package pers.cabin.learn.chaptor01;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 定容栈
 * Created by caiping on 2017/9/15.
 */
public class FixedCapacityStack<Item>  implements Iterable<Item> {

    private Item[] arr = (Item[]) new Object[1];
    private int n;


    public FixedCapacityStack(int cap) {

    }

    /**
     * 压栈
     * @param item
     */
    public void push(Item item) {

    }

    /**
     * 弹栈（获取栈顶元素，并移除）
     * @return
     */
    public Item pop() {

        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
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
