package pers.cabin.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.cabin.demo.dao.RoleDoMapper;
import pers.cabin.demo.domain.RoleDo;
import pers.cabin.demo.service.RoleService;

/**
 * Created by caiping on 2017/3/17.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDoMapper roleDoMapper;

    public RoleDo getRoleById(int id) {
        return roleDoMapper.selectByPrimaryKey(id);
    }
}
