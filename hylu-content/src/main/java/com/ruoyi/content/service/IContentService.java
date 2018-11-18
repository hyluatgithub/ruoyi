package com.ruoyi.content.service;

import com.ruoyi.content.domain.Content;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容管理主 服务层
 * 
 * @author hylu
 * @date 2018-11-18
 */
public interface IContentService
{
	/**
     * 查询内容管理主信息
     * 
     * @param id 内容管理主ID
     * @return 内容管理主信息
     */
	public Content selectContentById(Integer id);
	
	/**
     * 查询内容管理主列表
     * 
     * @param content 内容管理主信息
     * @return 内容管理主集合
     */
	public List<Content> selectContentList(Content content);
	
	/**
     * 新增内容管理主
     * 
     * @param content 内容管理主信息
     * @return 结果
     */
	public int insertContent(Content content);
	
	/**
     * 修改内容管理主
     * 
     * @param content 内容管理主信息
     * @return 结果
     */
	public int updateContent(Content content);
		
	/**
     * 删除内容管理主信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteContentByIds(String ids);
	
}
