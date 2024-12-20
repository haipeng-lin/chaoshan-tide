package com.tide.cultural.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tide.common.annotation.Excel;
import com.tide.common.core.domain.BaseEntity;

/**
 * 节日类别对象 tide_festival_category
 * 
 * @author haipeng-lin
 * @date 2024-11-20
 */
public class FestivalCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private String id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 封面 */
    @Excel(name = "封面")
    private String coverImg;

    /** 排序 */
    @Excel(name = "排序")
    private Long orderNum;

    /** 显示状态（1-显示，2-不显示） */
    @Excel(name = "显示状态", readConverterExp = "1=-显示，2-不显示")
    private Long status;

    /** 删除标志（1-未删除，2-已删除） */
    private Long delFlag;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setCoverImg(String coverImg) 
    {
        this.coverImg = coverImg;
    }

    public String getCoverImg() 
    {
        return coverImg;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .append("coverImg", getCoverImg())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
