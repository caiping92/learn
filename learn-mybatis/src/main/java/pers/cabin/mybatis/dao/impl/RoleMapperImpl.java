package pers.cabin.mybatis.dao.impl;

import pers.cabin.mybatis.dao.RoleMapper;
import pers.cabin.mybatis.domain.Role;

import java.util.List;

/**
 * 不建议这样使用
 * Created by caiping on 2017/3/16.
 */
public class RoleMapperImpl extends BaseDaoImpl implements RoleMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.getSqlSessionTemplate().delete("pers.caiping.mybatis.dao.RoleMapper.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(Role record) {
        return this.getSqlSessionTemplate().insert("pers.caiping.mybatis.dao.RoleMapper.insert.",record);
    }

    @Override
    public int insertSelective(Role record) {
        return this.getSqlSessionTemplate().insert("pers.caiping.mybatis.dao.RoleMapper.insertSelective",record);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return this.getSqlSessionTemplate().selectOne("pers.caiping.mybatis.dao.RoleMapper.selectByPrimaryKey",id);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return this.getSqlSessionTemplate().update("pers.caiping.mybatis.dao.RoleMapper.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return this.getSqlSessionTemplate().update("pers.caiping.mybatis.dao.RoleMapper.updateByPrimaryKey",record);
    }

    @Override
    public List<Role> selectAll() {
        return this.getSqlSessionTemplate().selectList("pers.caiping.mybatis.dao.RoleMapper.selectAll");
    }
}
