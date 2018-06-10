package pers.cabin.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.cabin.blog.domain.BContentDO;
import pers.cabin.blog.service.BContentService;
import pers.cabin.common.utils.PageUtils;
import pers.cabin.common.utils.Query;

@RequestMapping("/blog")
@Controller
public class BlogController {
	@Autowired
    BContentService bContentService;

	@GetMapping()
	String blog() {
		return "blog/index/main";
	}

	@ResponseBody
	@GetMapping("/open/list")
	public PageUtils opentList(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<BContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);

		PageUtils pageUtils = new PageUtils(bContentList, total);

		return pageUtils;
	}

	@GetMapping("/open/post/{cid}")
	String post(@PathVariable("cid") Long cid, Model model) {
		BContentDO bContentDO = bContentService.get(cid);
		model.addAttribute("bContent", bContentDO);
		return "blog/index/post";
	}
}
