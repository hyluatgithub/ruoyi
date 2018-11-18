package com.ruoyi.web.controller.demo;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.test.domain.Demo;
import com.ruoyi.test.service.IDemoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 测试 信息操作处理
 * 
 * @author hylu
 * @date 2018-11-18
 */
@Controller
@RequestMapping("/test/demo")
public class DemoController extends BaseController
{
    private String prefix = "test/demo";
	
	@Autowired
	private IDemoService demoService;
	
	@RequiresPermissions("test:demo:view")
	@GetMapping()
	public String demo()
	{
	    return prefix + "/demo";
	}
	
	/**
	 * 查询测试列表
	 */
	@RequiresPermissions("test:demo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Demo demo)
	{
		startPage();
        List<Demo> list = demoService.selectDemoList(demo);
		return getDataTable(list);
	}
	
	/**
	 * 新增测试
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存测试
	 */
	@RequiresPermissions("test:demo:add")
	@Log(title = "测试", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Demo demo)
	{		
		return toAjax(demoService.insertDemo(demo));
	}

	/**
	 * 修改测试
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Demo demo = demoService.selectDemoById(id);
		mmap.put("demo", demo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存测试
	 */
	@RequiresPermissions("test:demo:edit")
	@Log(title = "测试", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Demo demo)
	{		
		return toAjax(demoService.updateDemo(demo));
	}
	
	/**
	 * 删除测试
	 */
	@RequiresPermissions("test:demo:remove")
	@Log(title = "测试", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(demoService.deleteDemoByIds(ids));
	}
	
}
