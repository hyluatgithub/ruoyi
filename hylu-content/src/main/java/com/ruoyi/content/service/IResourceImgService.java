package com.ruoyi.content.service;

import com.ruoyi.content.domain.ResourceImg;

import java.util.List;

/**
 * 网络资源-资源详情(图片) 服务层
 *
 * @author hylu
 * @date 2018-12-13
 */
public interface IResourceImgService {
    /**
     * 查询网络资源-资源详情(图片)信息
     *
     * @param id 网络资源-资源详情(图片)ID
     * @return 网络资源-资源详情(图片)信息
     */
    public ResourceImg selectResourceImgById(Integer id);

    /**
     * 查询网络资源-资源详情(图片)列表
     *
     * @param resourceImg 网络资源-资源详情(图片)信息
     * @return 网络资源-资源详情(图片)集合
     */
    public List<ResourceImg> selectResourceImgList(ResourceImg resourceImg);

    /**
     * 新增网络资源-资源详情(图片)
     *
     * @param resourceImg 网络资源-资源详情(图片)信息
     * @return 结果
     */
    public int insertResourceImg(ResourceImg resourceImg);

    /**
     * 修改网络资源-资源详情(图片)
     *
     * @param resourceImg 网络资源-资源详情(图片)信息
     * @return 结果
     */
    public int updateResourceImg(ResourceImg resourceImg);

    /**
     * 删除网络资源-资源详情(图片)信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResourceImgByIds(String ids);

}
