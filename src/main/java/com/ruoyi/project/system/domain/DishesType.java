package com.ruoyi.project.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 菜品类型对象 dishes_type
 *
 * @author lusenzhu
 * @date 2020-10-13
 */
public class DishesType {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private Long id;

    /**
     * 菜品名称
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dishesTypeName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    @JsonIgnore
    private String beginTime;

    /**
     * 结束时间
     */
    @JsonIgnore
    private String endTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDishesTypeName(String dishesTypeName) {
        this.dishesTypeName = dishesTypeName;
    }

    public String getDishesTypeName() {
        return dishesTypeName;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddTime() {
        return addTime;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dishesTypeName", getDishesTypeName())
                .append("addTime", getAddTime())
                .toString();
    }
}
