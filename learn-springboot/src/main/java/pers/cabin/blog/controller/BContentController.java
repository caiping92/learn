package pers.cabin.blog.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.cabin.blog.domain.BContentDO;
import pers.cabin.blog.service.BContentService;
import pers.cabin.common.controller.BaseController;
import pers.cabin.common.utils.PageUtils;
import pers.cabin.common.utils.Query;
import pers.cabin.common.utils.Result;

/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-09 10:03:34
 */
@Controller
@RequestMapping("/blog/bContent")
public class BContentController extends BaseController {
	@Autowired
	BContentService bContentService;

	@GetMapping()
	@RequiresPermissions("blog:bContent:bContent")
	String BContent() {
		return "blog/bContent/bContent";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:bContent:bContent")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);

		List<BContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);

		PageUtils pageUtils = new PageUtils(bContentList, total);

		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("blog:bContent:add")
	String add() {
		return "blog/bContent/add";
	}

	@GetMapping("/edit/{cid}")
	@RequiresPermissions("blog:bContent:edit")
	String edit(@PathVariable("cid") Long cid, Model model) {
		BContentDO bContentDO = bContentService.get(cid);
		model.addAttribute("bContent", bContentDO);
		return "blog/bContent/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@RequiresPermissions("blog:bContent:add")
	@PostMapping("/save")
	public Result save(BContentDO bContent) {
		if ("test".equals(getUsername())) {
			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (bContent.getAllowComment() == null) {
			bContent.setAllowComment(0);
		}
		if (bContent.getAllowFeed() == null) {
			bContent.setAllowFeed(0);
		}
		int count;
		if (bContent.getCid() == null || bContent.getCid().equals("")) {
			count = bContentService.save(bContent);
		} else {
			count = bContentService.update(bContent);
		}
		if (count > 0) {
			return Result.ok().put("cid", bContent.getCid());
		}
		return Result.error();
	}

	/**
	 * 修改
	 */
	@RequiresPermissions("blog:bContent:edit")
	@RequestMapping("/update")
	public Result update(@RequestBody BContentDO bContent) {
		if ("test".equals(getUsername())) {
			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		bContentService.update(bContent);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("blog:bContent:remove")
	@PostMapping("/remove")
	@ResponseBody
	public Result remove(Long id) {
		if ("test".equals(getUsername())) {
			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (bContentService.remove(id) > 0) {
			return Result.ok();
		}
		return Result.error();
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("blog:bContent:batchRemove")
	@PostMapping("/batchRemove")
	@ResponseBody
	public Result remove(@RequestParam("ids[]") Long[] cids) {
		if ("test".equals(getUsername())) {
			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		bContentService.batchRemove(cids);
		return Result.ok();
	}
}
