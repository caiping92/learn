package pers.cabin.java.struct.recursion;

import org.junit.Test;

/**
 * Hanio塔问题
 *
 * @author caiping
 */
public class Test3_Towers {

    @Test
    public void testDoTowers() {
        doTowers(4, 4, 'A', 'B', 'C');
    }

    /**
     * @param nDisks 盘子总数
     * @param topN   第几个盘子
     * @param from   源座
     * @param inter  中间座
     * @param to     目标座
     */
    public void doTowers(int nDisks, int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(nDisks, topN - 1, from, to, inter);    //from-->inter
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(nDisks, topN - 1, inter, from, to);    //inter-->to

        }
    }
}

