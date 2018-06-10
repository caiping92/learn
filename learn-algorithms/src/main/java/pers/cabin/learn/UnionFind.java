package pers.cabin.learn;

/**
 * 动态连通问题
 *
 * Created by caiping on 2017/9/15.
 */
public class UnionFind {


    private int[] id;//分量id （以触点为作为索引）
    private int count;//分量数量

    /**
     * 以整数标识 初始化 n 个触点
     * @param n
     */
    public UnionFind(int n) {
        this.count = n; //初始化分量id数组
        this.id = new int[n];
        for (int i=0;i<n;i++) {
            id[i] = i;
        }
    }

    /**
     * 在 p q 之间连一条线
     * @param p
     * @param q
     */
    public void union(int p, int q) {

        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {//如果 p q 已经在相同的分量之中，则不采取任何行动
            return;
        }
        for (int i=0;i<id.length;i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    /**
     * p 所在的分量的标识符
     * @param p
     * @return
     */
    public int find(int p) {
        //quick-find
        return id[p];
    }

    /**
     * 如p q 存在与同一个分量中，则返回true
     * @param p
     * @param q
     * @return
     */
    boolean connected( int p ,int q) {
        return find(p) == find(q);
    }

    /**
     * 连通分量的数量
     * @return
     */
    public int count() {
        return this.count;
    }

//    ----test--------
    public static void main(String[] args){
        int n = 1;

        int p=0;
        int q=0;

        UnionFind unionFind = new UnionFind(n);

//        if (unionFind.connected(p, q)) {  //  如果已经连通则忽略
//          continue;
//       }
        unionFind.union(p,q);
        System.out.println(unionFind.count()+" "+"components"); //打印连接

    }
}
