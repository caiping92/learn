package pers.cabin.java.base.orientedObject;

/**
 * 长方形
 * Created by cc on 2016/11/3.
 */
public class ChangfangXing implements Araeable {
    private double chang;
    private double kuan;

    public ChangfangXing() {
        super();
    }

    public ChangfangXing(double chang, double kuan) {
        if (chang <= 0 || kuan <= 0) {
            throw new NoValueException("传入的数值非法，至少也得大于 0 吧 亲！");
        }
        this.chang = chang;
        this.kuan = kuan;
    }

    @Override
    public double getArae() {
        System.out.println("长方形的面积为：" + this.chang * this.kuan);
        return this.chang * this.kuan;

    }
}
