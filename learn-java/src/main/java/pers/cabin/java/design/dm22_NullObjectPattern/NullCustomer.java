package pers.cabin.java.design.dm22_NullObjectPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
