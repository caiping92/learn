package pers.cabin.common.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import pers.cabin.common.domain.SysFileDO;
import pers.cabin.common.service.SysFileService;
import pers.cabin.common.utils.FileType;
import pers.cabin.common.utils.FileUtil;
import pers.cabin.common.utils.PageUtils;
import pers.cabin.common.utils.Query;
import pers.cabin.common.utils.Result;

/**
 * 文件上传
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
@Controller
@RequestMapping("/common/sysFile")
public class SysFileController extends BaseController {

	public static final String CLASSPATH = SysFileController.class.getClassLoader().getResource("").getPath();
	public static final String upDir = SysFileController.CLASSPATH.substring(0,
			SysFileController.CLASSPATH.length() - 1);
	@Autowired
	private SysFileService sysFileService;

	@GetMapping()
	@RequiresPermissions("common:sysFile:sysFile")
	String SysFile(Model model) {
		Map<String, Object> params = new HashMap<>();
		return "common/file/file";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<SysFileDO> sysFileList = sysFileService.list(query);
		int total = sysFileService.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("common:bComments")
	String add() {
		return "common/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("common:bComments")
	String edit(Long id, Model model) {
		SysFileDO sysFile = sysFileService.get(id);
		model.addAttribute("sysFile", sysFile);
		return "common/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("common:info")
	public Result info(@PathVariable("id") Long id) {
		SysFileDO sysFile = sysFileService.get(id);
		return Result.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:save")
	public Result save(SysFileDO sysFile) {
		if (sysFileService.save(sysFile) > 0) {
			return Result.ok();
		}
		return Result.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("common:update")
	public Result update(@RequestBody SysFileDO sysFile) {
		sysFileService.update(sysFile);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public Result remove(Long id, HttpServletRequest request) {
		//String fileName = upDir + "/static/" + sysFileService.get(id).getUrl();
		String fileName = request.getSession().getServletContext()
				+ sysFileService.get(id).getUrl();
		if (sysFileService.remove(id) > 0) {
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return Result.error("数据库记录删除成功，文件删除失败");
			}
			return Result.ok();
		} else {
			return Result.error();
		}

	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:remove")
	public Result remove(@RequestParam("ids[]") Long[] ids) {
		if ("test".equals(getUsername())) {
			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		sysFileService.batchRemove(ids);
		return Result.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
    Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return Result.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.RenameToUUID(fileName);
		// String filePath = ".//static//upload//";
		// String filePath = upDir + "/static/upload/";
		String filePath = request.getSession().getServletContext().getRealPath("upload/");
		SysFileDO sysFile = new SysFileDO(FileType.fileType(fileName), "/upload/" + fileName, new Date());
		try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
		} catch (Exception e) {
			return Result.error();
		}
		if (sysFileService.save(sysFile) > 0) {
			return Result.ok();
		}
		return Result.error();
	}
}
