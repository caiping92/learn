package pers.cabin.demo.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pers.cabin.demo.domain.RoleDo;

/**
 * Created by caiping on 2017/3/17.
 */
public class RoleMapperTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        RoleDoMapper roleDoMapper = (RoleDoMapper) applicationContext.getBean("roleDoMapper");

        RoleDo roleDo = roleDoMapper.selectByPrimaryKey(1);
        System.out.println(roleDo.getNote());
    }
}
