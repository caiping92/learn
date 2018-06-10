package pers.cabin.learn.chaptor01.sort;

/**
 * 优先队列
 *
 * Created by caiping on 2017/9/16.
 */
public class MaxPQ<Key extends Comparable> {

    private Key[] pq; //基于堆的完全二叉树
    private int N=0;    //存储于pq[1..N] 中 pq[0] 没有使用

    public MaxPQ(int N) {
        pq = (Key[]) new Comparable[N + 1];
    }

    /**
     * 向优先队列插入一个元素
     * @param key
     */
    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    public Key max() {
        //获取根节点，得到最大元素
        Key max = pq[1];
        //将其和最后一个进行交换
        exch(1, N--);
        //防止对象游离
        pq[N + 1] = null;
        //回复堆的有序性
        sink(1);
        return max;
    }

    public  Key delMax() {
        return null;
    }

    public boolean isEmpty() {
        return this.N==0;
    }

    public int size() {
        return this.N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

    }

    /**
     * 由下至上 的对有序化（上浮）的实现
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 由上至下有序化（下沉）的实现
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
}
