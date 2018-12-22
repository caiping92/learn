package pers.cabin.java.design.dm08_FilterPattern;

import java.util.List;

/**
 * 为标准（Criteria）创建一个接口。
 * Created by caiping on 2017/3/2.
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);
}
