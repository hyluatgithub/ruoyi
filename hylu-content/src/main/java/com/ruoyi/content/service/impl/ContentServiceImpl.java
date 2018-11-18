package com.ruoyi.content.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.content.mapper.ContentMapper;
import com.ruoyi.content.domain.Content;
import com.ruoyi.content.service.IContentService;
import com.ruoyi.common.support.Convert;

/**
 * 内容管理主 服务层实现
 * 
 * @author hylu
 * @date 2018-11-18
 */
@Service
public class ContentServiceImpl implements IContentService 
{
	@Autowired
	private ContentMapper contentMapper;

	/**
     * 查询内容管理主信息
     * 
     * @param id 内容管理主ID
     * @return 内容管理主信息
     */
    @Override
	public Content selectContentById(Integer id)
	{
	    return contentMapper.selectContentById(id);
	}
	
	/**
     * 查询内容管理主列表
     * 
     * @param content 内容管理主信息
     * @return 内容管理主集合
     */
	@Override
	public List<Content> selectContentList(Content content)
	{
	    return contentMapper.selectContentList(content);
	}
	
    /**
     * 新增内容管理主
     * 
     * @param content 内容管理主信息
     * @return 结果
     */
	@Override
	public int insertContent(Content content)
	{
	    return contentMapper.insertContent(content);
	}
	
	/**
     * 修改内容管理主
     * 
     * @param content 内容管理主信息
     * @return 结果
     */
	@Override
	public int updateContent(Content content)
	{
	    return contentMapper.updateContent(content);
	}

	/**
     * 删除内容管理主对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteContentByIds(String ids)
	{
		return contentMapper.deleteContentByIds(Convert.toStrArray(ids));
	}
	
}
