package pers.cabin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.cabin.demo.domain.RoleDo;
import pers.cabin.demo.service.RoleService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caiping on 2017/3/17.
 */
@Controller
@RequestMapping("/t")
public class DemoController {

    @Autowired
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("")
    public String test(HttpServletRequest request) {
        request.setAttribute("role", roleService.getRoleById(1));
        return "test/test";
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public RoleDo getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }
}
