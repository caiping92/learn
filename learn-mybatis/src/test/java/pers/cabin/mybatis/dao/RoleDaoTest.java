package pers.cabin.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pers.cabin.mybatis.utils.MybatisUtil;
import pers.cabin.mybatis.domain.Role;
import pers.cabin.mybatis.spring.SpringUtils;

import java.util.List;

/**
 * Created by caiping on 2017/3/12.
 */
public class RoleDaoTest {

    private RoleMapper roleMapper = null;

    private SqlSession sqlSession = null;

    @Before
    public void setUp() {
        sqlSession = MybatisUtil.getSqlSessionFactory().openSession();
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @Test
    public  void testInsertRole() {
        Role r = new Role("Mybatis","Mybatis Generator 生成");

        roleMapper.insert(r);

        sqlSession.commit();
    }

    @Test
    public  void testSelectAll() {
        List<Role> roles = roleMapper.selectAll();
        for (Role r : roles) {
            System.out.println(r);

        }
    }

    @Test
    public void testSelectByPrimaryKey() {
        Role role = roleMapper.selectByPrimaryKey(1);
        System.out.println(role);
    }

    @Test
    public void testMybatisSpring() {
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        RoleMapper roleMapper = (RoleMapper) applicationContext.getBean("roleMapper");

        List<Role> roles = roleMapper.selectAll(); for (Role r : roles) {
            System.out.println(r);

        }

    }

    @Test
    public void testSelectOne() {
        List<Role> roles = sqlSession.selectList("pers.caiping.mybatis.domain.Role.selectAll");
        for (Role r : roles) {
            System.out.println(r);
        }
    }
}
