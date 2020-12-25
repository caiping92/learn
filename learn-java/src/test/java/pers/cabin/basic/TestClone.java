package pers.cabin.basic;

import java.util.Date;

/**
 * Created by caiping on 2017/9/10.
 */
public class TestClone implements Cloneable{

    private String name;
    private Date date;

    /*
    //浅复制
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    protected Object clone() throws CloneNotSupportedException {
        TestClone obj = (TestClone) super.clone();
        Date date_clone = (Date) this.getDate().clone();
        obj.setDate(date_clone);

        return obj;
    }
//    ----------

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
