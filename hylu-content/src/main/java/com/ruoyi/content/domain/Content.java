package com.ruoyi.content.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.base.BaseEntity;
import java.util.Date;

/**
 * 内容管理主表 m_content
 * 
 * @author hylu
 * @date 2018-11-18
 */
public class Content extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键编码 */
	private Integer id;
	/** 标题 */
	private String title;
	/** 类型编码 */
	private String typeCode;
	/** 类型名称 */
	private String typeName;
	/** 内容子项目编码 */
	private String itemCode;
	/** 内容子项目名称 */
	private String itemName;
	/** 内容主体 */
	private String content;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setTypeCode(String typeCode) 
	{
		this.typeCode = typeCode;
	}

	public String getTypeCode() 
	{
		return typeCode;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setItemCode(String itemCode) 
	{
		this.itemCode = itemCode;
	}

	public String getItemCode() 
	{
		return itemCode;
	}
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	public String getItemName() 
	{
		return itemName;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("typeCode", getTypeCode())
            .append("typeName", getTypeName())
            .append("itemCode", getItemCode())
            .append("itemName", getItemName())
            .append("content", getContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
