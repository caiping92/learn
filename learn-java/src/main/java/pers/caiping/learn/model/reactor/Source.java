package pers.caiping.learn.model.reactor;

import java.util.Date;

/**
 * @author caiping
 * @create 2018/2/5 17:10
 * @Description
 */
public class Source {
    private Date date = new Date();
    private String id = date.toString() + "_" + System.identityHashCode(date);

    @Override
    public String toString() {
        return id;
    }
}
