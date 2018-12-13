package com.ruoyi.web.controller.modules.content;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.content.domain.ResourceMenu;
import com.ruoyi.content.service.IResourceMenuService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络资源-种子目录 信息操作处理
 *
 * @author hylu
 * @date 2018-12-13
 */
@Controller
@RequestMapping("/content/resourceMenu")
public class ResourceMenuController extends BaseController {
    private String prefix = "modules/resourceMenu";

    @Autowired
    private IResourceMenuService resourceMenuService;

    @RequiresPermissions("content:resourceMenu:view")
    @GetMapping()
    public String resourceMenu() {
        return prefix + "/resourceMenu";
    }

    /**
     * 查询网络资源-种子目录列表
     */
    @RequiresPermissions("content:resourceMenu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResourceMenu resourceMenu) {
        startPage();
        List<ResourceMenu> list = resourceMenuService.selectResourceMenuList(resourceMenu);
        return getDataTable(list);
    }

    /**
     * 新增网络资源-种子目录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存网络资源-种子目录
     */
    @RequiresPermissions("content:resourceMenu:add")
    @Log(title = "网络资源-种子目录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResourceMenu resourceMenu) {
        return toAjax(resourceMenuService.insertResourceMenu(resourceMenu));
    }

    /**
     * 修改网络资源-种子目录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        ResourceMenu resourceMenu = resourceMenuService.selectResourceMenuById(id);
        mmap.put("resourceMenu", resourceMenu);
        return prefix + "/edit";
    }

    /**
     * 修改保存网络资源-种子目录
     */
    @RequiresPermissions("content:resourceMenu:edit")
    @Log(title = "网络资源-种子目录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResourceMenu resourceMenu) {
        return toAjax(resourceMenuService.updateResourceMenu(resourceMenu));
    }

    /**
     * 删除网络资源-种子目录
     */
    @RequiresPermissions("content:resourceMenu:remove")
    @Log(title = "网络资源-种子目录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(resourceMenuService.deleteResourceMenuByIds(ids));
    }

}
