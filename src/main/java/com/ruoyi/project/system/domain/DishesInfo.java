package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 菜品信息对象 dishes_info
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
public class DishesInfo
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 菜品编号 */
    private String dishesId;

    @Excel(name = "菜品名称")
    private String dishesName;

    /** 菜品类型 */
    @Excel(name = "菜品类型")
    private Long dishesType;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    @JsonIgnore
    private String beginTime;

    /** 结束时间 */
    @JsonIgnore
    private String endTime;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String addTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDishesId(String dishesId)
    {
        this.dishesId = dishesId;
    }

    public String getDishesId()
    {
        return dishesId;
    }
    public void setDishesType(Long dishesType) 
    {
        this.dishesType = dishesType;
    }

    public Long getDishesType() 
    {
        return dishesType;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setAddTime(String addTime)
    {
        this.addTime = addTime;
    }

    public String getAddTime()
    {
        return addTime;
    }

    public String getDishesName() {
        return dishesName;
    }

    public void setDishesName(String dishesName) {
        this.dishesName = dishesName;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dishesId", getDishesId())
            .append("dishesName",getDishesName())
            .append("dishesType", getDishesType())
            .append("picture", getPicture())
            .append("price", getPrice())
            .append("description", getDescription())
            .append("addTime", getAddTime())
            .toString();
    }
}
