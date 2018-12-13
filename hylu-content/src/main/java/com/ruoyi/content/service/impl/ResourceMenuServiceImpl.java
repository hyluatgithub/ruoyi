package com.ruoyi.content.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.content.domain.ResourceMenu;
import com.ruoyi.content.mapper.ResourceMenuMapper;
import com.ruoyi.content.service.IResourceMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网络资源-种子目录 服务层实现
 *
 * @author hylu
 * @date 2018-12-13
 */
@Service
public class ResourceMenuServiceImpl implements IResourceMenuService {
    @Autowired
    private ResourceMenuMapper resourceMenuMapper;

    /**
     * 查询网络资源-种子目录信息
     *
     * @param id 网络资源-种子目录ID
     * @return 网络资源-种子目录信息
     */
    @Override
    public ResourceMenu selectResourceMenuById(Integer id) {
        return resourceMenuMapper.selectResourceMenuById(id);
    }

    /**
     * 查询网络资源-种子目录列表
     *
     * @param resourceMenu 网络资源-种子目录信息
     * @return 网络资源-种子目录集合
     */
    @Override
    public List<ResourceMenu> selectResourceMenuList(ResourceMenu resourceMenu) {
        return resourceMenuMapper.selectResourceMenuList(resourceMenu);
    }

    /**
     * 新增网络资源-种子目录
     *
     * @param resourceMenu 网络资源-种子目录信息
     * @return 结果
     */
    @Override
    public int insertResourceMenu(ResourceMenu resourceMenu) {
        return resourceMenuMapper.insertResourceMenu(resourceMenu);
    }

    /**
     * 修改网络资源-种子目录
     *
     * @param resourceMenu 网络资源-种子目录信息
     * @return 结果
     */
    @Override
    public int updateResourceMenu(ResourceMenu resourceMenu) {
        return resourceMenuMapper.updateResourceMenu(resourceMenu);
    }

    /**
     * 删除网络资源-种子目录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteResourceMenuByIds(String ids) {
        return resourceMenuMapper.deleteResourceMenuByIds(Convert.toStrArray(ids));
    }

}
