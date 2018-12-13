package com.ruoyi.content.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.content.domain.ResourceImg;
import com.ruoyi.content.mapper.ResourceImgMapper;
import com.ruoyi.content.service.IResourceImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网络资源-资源详情(图片) 服务层实现
 *
 * @author hylu
 * @date 2018-12-13
 */
@Service
public class ResourceImgServiceImpl implements IResourceImgService {
    @Autowired
    private ResourceImgMapper resourceImgMapper;

    /**
     * 查询网络资源-资源详情(图片)信息
     *
     * @param id 网络资源-资源详情(图片)ID
     * @return 网络资源-资源详情(图片)信息
     */
    @Override
    public ResourceImg selectResourceImgById(Integer id) {
        return resourceImgMapper.selectResourceImgById(id);
    }

    /**
     * 查询网络资源-资源详情(图片)列表
     *
     * @param resourceImg 网络资源-资源详情(图片)信息
     * @return 网络资源-资源详情(图片)集合
     */
    @Override
    public List<ResourceImg> selectResourceImgList(ResourceImg resourceImg) {
        return resourceImgMapper.selectResourceImgList(resourceImg);
    }

    /**
     * 新增网络资源-资源详情(图片)
     *
     * @param resourceImg 网络资源-资源详情(图片)信息
     * @return 结果
     */
    @Override
    public int insertResourceImg(ResourceImg resourceImg) {
        return resourceImgMapper.insertResourceImg(resourceImg);
    }

    /**
     * 修改网络资源-资源详情(图片)
     *
     * @param resourceImg 网络资源-资源详情(图片)信息
     * @return 结果
     */
    @Override
    public int updateResourceImg(ResourceImg resourceImg) {
        return resourceImgMapper.updateResourceImg(resourceImg);
    }

    /**
     * 删除网络资源-资源详情(图片)对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteResourceImgByIds(String ids) {
        return resourceImgMapper.deleteResourceImgByIds(Convert.toStrArray(ids));
    }

}
