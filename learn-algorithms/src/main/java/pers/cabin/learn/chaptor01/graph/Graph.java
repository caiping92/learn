package pers.cabin.learn.chaptor01.graph;

import pers.cabin.learn.chaptor01.Bag;

/**
 * 无向图api
 * Created by caiping on 2017/9/18.
 */
public class Graph {

    private final int V;
    private int E;
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[])new Bag[V];
        for (int v=0 ;v<V;v++) {
            adj[v] = new Bag<>();
        }
    }

    // 顶点数
    public int V() {
        return this.V;
    }

    //边数
    public int E() {
        return this.E;
    }

    //向 图中增加一条边 v-w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    //和v相邻的所有顶点
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

}
