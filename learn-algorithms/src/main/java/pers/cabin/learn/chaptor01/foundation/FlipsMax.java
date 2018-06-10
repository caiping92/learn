package pers.cabin.learn.chaptor01.foundation;

/**
 * Created by caiping on 2017/9/15.
 */
public class FlipsMax {

    /**
     * 比较两个计数器的大小，返回 增加次数 较多的 计数器
     * @param x
     * @param y
     * @return
     */
    public static Counter max(Counter x, Counter y) {
        if (x == null && y == null) {
            return null;
        }
        if (x != null) {
            if (y == null) {
                return x;
            } else {
                if (x.tally() > y.tally()) {
                    return x;
                } else {
                    return y;
                }
            }
        }
        return y;
    }
}
