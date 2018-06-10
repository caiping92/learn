package pers.cabin.system.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.cabin.common.annotation.Log;
import pers.cabin.common.controller.BaseController;
import pers.cabin.common.domain.Tree;
import pers.cabin.common.utils.MD5Utils;
import pers.cabin.common.utils.Result;
import pers.cabin.common.utils.ShiroUtils;
import pers.cabin.system.domain.MenuDO;
import pers.cabin.system.service.MenuService;

@Controller
public class LoginController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    MenuService menuService;

	@Log("请求访问主页")
	@GetMapping({ "/", "", "/index" })
	String Index(Model model) {
		// Tree<MenuDO> menuTree = menuService.getSysMenuTree(getUserId());
		List<Tree<MenuDO>> menus = menuService.listMenuTree(getUserId());
		model.addAttribute("menus", menus);
		model.addAttribute("name", getUser().getName());
		logger.info(getUser().getName());
		return "index";
	}

	@GetMapping("/login")
	String login() {
		return "login";
	}

	@PostMapping("/login_bak")
	String doLogin(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return "redirect:/index";
		} catch (AuthenticationException e) {
			System.out.println("登录失败信息------" + e.getMessage());
			return "redirect:/login";
		}
	}

	@Log("登录")
	@PostMapping("/login")
	@ResponseBody
    Result ajaxLogin(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return Result.ok();
		} catch (AuthenticationException e) {
			return Result.error("用户或密码错误");
		}
	}

	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

	@GetMapping("/403")
	String error403() {
		return "403";
	}

}
