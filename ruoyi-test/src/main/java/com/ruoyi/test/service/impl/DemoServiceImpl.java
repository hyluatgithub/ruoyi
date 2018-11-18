package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.DemoMapper;
import com.ruoyi.test.domain.Demo;
import com.ruoyi.test.service.IDemoService;
import com.ruoyi.common.support.Convert;

/**
 * 测试 服务层实现
 * 
 * @author hylu
 * @date 2018-11-18
 */
@Service
public class DemoServiceImpl implements IDemoService 
{
	@Autowired
	private DemoMapper demoMapper;

	/**
     * 查询测试信息
     * 
     * @param id 测试ID
     * @return 测试信息
     */
    @Override
	public Demo selectDemoById(Integer id)
	{
	    return demoMapper.selectDemoById(id);
	}
	
	/**
     * 查询测试列表
     * 
     * @param demo 测试信息
     * @return 测试集合
     */
	@Override
	public List<Demo> selectDemoList(Demo demo)
	{
	    return demoMapper.selectDemoList(demo);
	}
	
    /**
     * 新增测试
     * 
     * @param demo 测试信息
     * @return 结果
     */
	@Override
	public int insertDemo(Demo demo)
	{
	    return demoMapper.insertDemo(demo);
	}
	
	/**
     * 修改测试
     * 
     * @param demo 测试信息
     * @return 结果
     */
	@Override
	public int updateDemo(Demo demo)
	{
	    return demoMapper.updateDemo(demo);
	}

	/**
     * 删除测试对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDemoByIds(String ids)
	{
		return demoMapper.deleteDemoByIds(Convert.toStrArray(ids));
	}
	
}
