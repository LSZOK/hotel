package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 会员等级对象 membership_level
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
public class MembershipLevel
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 会员名称 */
    @Excel(name = "会员名称")
    private String membershipName;

    /** 折扣 */
    @Excel(name = "折扣")
    private double discount;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMembershipName(String membershipName) 
    {
        this.membershipName = membershipName;
    }

    public String getMembershipName() 
    {
        return membershipName;
    }
    public void setDiscount(double discount)
    {
        this.discount = discount;
    }

    public double getDiscount()
    {
        return discount;
    }
    public void setAddTime(Date addTime) 
    {
        this.addTime = addTime;
    }

    public Date getAddTime() 
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("membershipName", getMembershipName())
            .append("discount", getDiscount())
            .append("addTime", getAddTime())
            .toString();
    }
}
