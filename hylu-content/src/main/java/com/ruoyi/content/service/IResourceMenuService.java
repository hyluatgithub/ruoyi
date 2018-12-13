package com.ruoyi.content.service;

import com.ruoyi.content.domain.ResourceMenu;

import java.util.List;

/**
 * 网络资源-种子目录 服务层
 *
 * @author hylu
 * @date 2018-12-13
 */
public interface IResourceMenuService {
    /**
     * 查询网络资源-种子目录信息
     *
     * @param id 网络资源-种子目录ID
     * @return 网络资源-种子目录信息
     */
    public ResourceMenu selectResourceMenuById(Integer id);

    /**
     * 查询网络资源-种子目录列表
     *
     * @param resourceMenu 网络资源-种子目录信息
     * @return 网络资源-种子目录集合
     */
    public List<ResourceMenu> selectResourceMenuList(ResourceMenu resourceMenu);

    /**
     * 新增网络资源-种子目录
     *
     * @param resourceMenu 网络资源-种子目录信息
     * @return 结果
     */
    public int insertResourceMenu(ResourceMenu resourceMenu);

    /**
     * 修改网络资源-种子目录
     *
     * @param resourceMenu 网络资源-种子目录信息
     * @return 结果
     */
    public int updateResourceMenu(ResourceMenu resourceMenu);

    /**
     * 删除网络资源-种子目录信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResourceMenuByIds(String ids);

}
