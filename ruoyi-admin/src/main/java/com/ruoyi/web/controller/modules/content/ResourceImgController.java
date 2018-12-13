package com.ruoyi.web.controller.modules.content;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.content.domain.ResourceImg;
import com.ruoyi.content.service.IResourceImgService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络资源-资源详情(图片) 信息操作处理
 *
 * @author hylu
 * @date 2018-12-13
 */
@Controller
@RequestMapping("/content/resourceImg")
public class ResourceImgController extends BaseController {
    private String prefix = "modules/resourceImg";

    @Autowired
    private IResourceImgService resourceImgService;

    @RequiresPermissions("content:resourceImg:view")
    @GetMapping()
    public String resourceImg() {
        return prefix + "/resourceImg";
    }

    /**
     * 查询网络资源-资源详情(图片)列表
     */
    @RequiresPermissions("content:resourceImg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResourceImg resourceImg) {
        startPage();
        List<ResourceImg> list = resourceImgService.selectResourceImgList(resourceImg);
        return getDataTable(list);
    }

    /**
     * 新增网络资源-资源详情(图片)
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存网络资源-资源详情(图片)
     */
    @RequiresPermissions("content:resourceImg:add")
    @Log(title = "网络资源-资源详情(图片)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResourceImg resourceImg) {
        return toAjax(resourceImgService.insertResourceImg(resourceImg));
    }

    /**
     * 修改网络资源-资源详情(图片)
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        ResourceImg resourceImg = resourceImgService.selectResourceImgById(id);
        mmap.put("resourceImg", resourceImg);
        return prefix + "/edit";
    }

    /**
     * 修改保存网络资源-资源详情(图片)
     */
    @RequiresPermissions("content:resourceImg:edit")
    @Log(title = "网络资源-资源详情(图片)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResourceImg resourceImg) {
        return toAjax(resourceImgService.updateResourceImg(resourceImg));
    }

    /**
     * 删除网络资源-资源详情(图片)
     */
    @RequiresPermissions("content:resourceImg:remove")
    @Log(title = "网络资源-资源详情(图片)", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(resourceImgService.deleteResourceImgByIds(ids));
    }

}
