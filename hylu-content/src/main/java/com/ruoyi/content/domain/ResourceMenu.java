package com.ruoyi.content.domain;

import com.ruoyi.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 网络资源-种子目录表 web_resource_menu
 *
 * @author hylu
 * @date 2018-12-13
 */
public class ResourceMenu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;
    /**
     * 类型：图片 小说 视频 音乐
     */
    private String type;
    /**
     * 归属类别
     */
    private String item;
    /**
     * 标题
     */
    private String title;
    /**
     * 日期
     */
    private String dateTime;
    /**
     * 封面
     */
    private String cover;
    /**
     * 资源路径
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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover() {
        return cover;
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
                .append("type", getType())
                .append("item", getItem())
                .append("title", getTitle())
                .append("dateTime", getDateTime())
                .append("cover", getCover())
                .append("url", getUrl())
                .append("createTime", getCreateTime())
                .toString();
    }
}
