package pers.cabin.demo.service;

import org.springframework.stereotype.Service;
import pers.cabin.demo.domain.RoleDo;

/**
 * Created by caiping on 2017/3/17.
 */
@Service
public interface RoleService {
    RoleDo getRoleById(int id);
}
