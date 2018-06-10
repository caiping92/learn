package pers.cabin.blog.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pers.cabin.blog.domain.BCommentsDO;
import pers.cabin.blog.service.BCommentsService;
import pers.cabin.common.controller.BaseController;
import pers.cabin.common.utils.PageUtils;
import pers.cabin.common.utils.Query;
import pers.cabin.common.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-08 13:56:45
 */
@Controller
@RequestMapping("/blog/bComments")
public class BCommentsController extends BaseController{
	@Autowired
	private BCommentsService bCommentsService;
	
	@GetMapping()
	//@RequiresPermissions("blog:bComments")
	String bComments(){
	    return "blog/bComments/bComments";
	}
	
	@GetMapping("/list")
	@ResponseBody
	//@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BCommentsDO> bCommentsList = bCommentsService.list(query);
		int total = bCommentsService.count(query);
		
		PageUtils pageUtils = new PageUtils(bCommentsList, total);
		
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/bComments/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,Model model){
		BCommentsDO bContentDO = bCommentsService.get(id);
		model.addAttribute("bContentDO", bContentDO);
	    return "blog/bComments/edit";
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	@ResponseBody
	//@RequiresPermissions("blog:save")
	public Result save(BCommentsDO bComments){
		bCommentsService.save(bComments);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public Result update(BCommentsDO bComments){
		bCommentsService.update(bComments);
		return Result.ok();
	}
	
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public Result remove(Integer id){
		if(bCommentsService.remove(id)>0){
		return Result.ok();
		}
		return Result.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("blog:delete")
	public Result delete(@RequestParam("ids[]") Integer[] ids){
		bCommentsService.batchRemove(ids);
		return Result.ok();
	}
	
}
