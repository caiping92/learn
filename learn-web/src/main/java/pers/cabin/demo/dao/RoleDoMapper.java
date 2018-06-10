package pers.cabin.demo.dao;

import pers.cabin.demo.domain.RoleDo;

public interface RoleDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleDo record);

    int insertSelective(RoleDo record);

    RoleDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleDo record);

    int updateByPrimaryKey(RoleDo record);
}