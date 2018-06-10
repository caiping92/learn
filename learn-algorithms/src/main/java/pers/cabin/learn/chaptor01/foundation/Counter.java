package pers.cabin.learn.chaptor01.foundation;

/**
 * Created by caiping on 2017/9/15.
 */
public class Counter {

    private String name;
    private long incrementCount;
    private long value;

    /**
     * 创建一个名为 id 的计数器
     * @param name
     * @param start 从哪个数开始计时
     */
   public Counter(String name,long start) {
       this.name = name;
       this.value = start;
    }

    /**
     * 计数器+1
     */
    public void increment() {
//       将计数器的值 增加 1
        this.value++;
        this.incrementCount++;
    }

    /**
     * 该对象创建之后 计数器被增加1 的次数
     * @return
     */
    public long tally() {
        return this.incrementCount;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "name='" + name + '\'' +
                ", incrementCount=" + incrementCount +
                ", value=" + value +
                '}';
    }
}
