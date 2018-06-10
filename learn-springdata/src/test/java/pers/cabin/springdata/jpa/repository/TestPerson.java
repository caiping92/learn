package pers.cabin.springdata.jpa.repository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import pers.cabin.springdata.jpa.po.Person;
import pers.cabin.springdata.jpa.dao.PersonDao;
import pers.cabin.springdata.jpa.utils.ApplicationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Person 实体类测试以及相关crud操作
 * Created by caiping on 2017/6/11.
 */
public class TestPerson {

    private PersonDao personDao = null;

    @Before
    public void setUp() {
        personDao = ApplicationUtils.getApplicationContext().getBean(PersonDao.class);
    }

    @Test
    public void testInitPerson() {
        ApplicationUtils.getApplicationContext();
    }

    @Test
    @Transactional
    public void testInsertPerson() {

        List list = new ArrayList<Person>();

        for (int i=0;i<10;i++) {
            Person  p1 = new Person();
            p1.setUsername("李"+i+"o");
            p1.setAge(i * 2);
            p1.setCode("513022199" + i + "050409" + i);

            list.add(p1);
        }

        personDao.save(list);

    }

    @Test
    @Transactional
    public void testModifyPerson() {
        Person p = new Person();

        p.setId(1);
        p.setUsername("李0-修改测试");

        personDao.save(p);

    }
}
