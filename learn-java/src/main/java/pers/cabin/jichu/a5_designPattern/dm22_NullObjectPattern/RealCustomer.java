package pers.cabin.jichu.a5_designPattern.dm22_NullObjectPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class RealCustomer extends AbstractCustomer {
    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}
