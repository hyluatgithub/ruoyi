package com.ruoyi.web.controller.modules.content;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.content.domain.Content;
import com.ruoyi.content.service.IContentService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 内容管理主表 信息操作处理
 *
 * @author hylu
 * @date 2018-11-18
 */
@Controller
@RequestMapping("/content/content")
public class ContentController extends BaseController {
    private String prefix = "modules/content";

    @Autowired
    private IContentService contentService;

    @RequiresPermissions("content:content:view")
    @GetMapping()
    public String content() {
        return prefix + "/content";
    }

    /**
     * 查询内容管理主列表
     */
    @RequiresPermissions("content:content:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Content content) {
        startPage();
        List<Content> list = contentService.selectContentList(content);
        return getDataTable(list);
    }

    /**
     * 新增内容管理主
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存内容管理主
     */
    @RequiresPermissions("content:content:add")
    @Log(title = "内容管理主", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Content content) {
        return toAjax(contentService.insertContent(content));
    }

    /**
     * 修改内容管理主
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        Content content = contentService.selectContentById(id);
        mmap.put("content", content);
        return prefix + "/edit";
    }

    /**
     * 修改保存内容管理主
     */
    @RequiresPermissions("content:content:edit")
    @Log(title = "内容管理主", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Content content) {
        return toAjax(contentService.updateContent(content));
    }

    /**
     * 删除内容管理主
     */
    @RequiresPermissions("content:content:remove")
    @Log(title = "内容管理主", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(contentService.deleteContentByIds(ids));
    }

}
