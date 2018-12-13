package com.ruoyi.web.controller.modules.content;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.content.handle.MusicUserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.content.domain.MusicUser;
import com.ruoyi.content.service.IMusicUserService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;

/**
 * 用户 信息操作处理
 * 
 * @author hylu
 * @date 2018-11-30
 */
@Controller
@RequestMapping("/content/musicUser")
public class MusicUserController extends BaseController
{
	@Autowired
	private MusicUserUtils musicUserUtils;

    private String prefix = "modules/musicUser";
	
	@Autowired
	private IMusicUserService musicUserService;
	
	@RequiresPermissions("content:musicUser:view")
	@GetMapping()
	public String musicUser()
	{
	    return prefix + "/musicUser";
	}
	
	/**
	 * 查询用户列表
	 */
	@RequiresPermissions("content:musicUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(MusicUser musicUser)
	{
		startPage();
        List<MusicUser> list = musicUserService.selectMusicUserList(musicUser);
		return getDataTable(list);
	}
	
	/**
	 * 删除用户
	 */
	@RequiresPermissions("content:musicUser:remove")
	@Log(title = "用户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(musicUserService.deleteMusicUserByIds(ids));
	}

	/**
	 * 获取关注用户列表
	 */
	@PostMapping("/getFollows")
	@ResponseBody
	public AjaxResult getFollows()
	{
        System.setProperty("proxyHost", "39.108.219.137");
        System.setProperty("proxyPort", "8118");
		musicUserUtils.start(new ArrayList<>());
		return new AjaxResult();
	}

}
