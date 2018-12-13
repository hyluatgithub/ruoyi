package com.ruoyi.content.domain;

import com.ruoyi.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 网络资源-资源详情(图片)表 web_resource_img
 *
 * @author hylu
 * @date 2018-12-13
 */
public class ResourceImg extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 归属项
     */
    private Integer parentId;
    /**
     * 归属项标题
     */
    private String parentTitle;
    /**
     * 编码
     */
    private String name;
    /**
     * 资源地址
     */
    private String url;
    /**
     * 创建时间
     */
    private Date createTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("parentId", getParentId())
                .append("parentTitle", getParentTitle())
                .append("name", getName())
                .append("url", getUrl())
                .append("createTime", getCreateTime())
                .toString();
    }
}
