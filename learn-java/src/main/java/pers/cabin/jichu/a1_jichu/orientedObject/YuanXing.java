package pers.cabin.jichu.a1_jichu.orientedObject;

/**
 * 圆形
 * Created by cc on 2016/11/3.
 */
public class YuanXing implements Araeable {
    /**
     * 半径
     */
    private double r;
    private final double PI = 3.14;

    public YuanXing() {
        super();
    }

    public YuanXing(double r) {
        if (r <= 0) {
            throw new NoValueException("传入的数值非法，至少也得大于 0 吧 亲！");
        }
        this.r = r;
    }

    @Override
    public double getArae() {
        System.out.println("半径为" + this.r + "圆形的面积为:" + (PI * this.r) * (PI * this.r));
        return (PI * this.r) * (PI * this.r);
    }
}
