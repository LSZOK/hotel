package com.ruoyi.project.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 客户信息对象 client
 *
 * @author ruoyi
 * @date 2020-10-21
 */
public class Client {
    private static final long serialVersionUID = 1L;

    /**
     * 顾客编号
     */
    private String clientId;

    /**
     * 顾客姓名
     */
    @Excel(name = "顾客姓名")
    private String clientName;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;

    /**
     * 电话
     */
    @Excel(name = "电话")
    private String phone;

    /**
     * 房号
     */
    @Excel(name = "房号")
    private Long roomNum;

    /**
     * 总费用
     */
    @Excel(name = "总费用")
    private Long totalCost;

    /**
     * 会员等级
     */
    @Excel(name = "会员等级")
    private Long menberLevel;

    /**
     * 身份证
     */
    @Excel(name = "身份证")
    private String idCard;

    private String openId;


    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addTime;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setRoomNum(Long roomNum) {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() {
        return roomNum;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public void setMenberLevel(Long menberLevel) {
        this.menberLevel = menberLevel;
    }

    public Long getMenberLevel() {
        return menberLevel;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("clientId", getClientId())
                .append("clientName", getClientName())
                .append("sex", getSex())
                .append("phone", getPhone())
                .append("roomNum", getRoomNum())
                .append("totalCost", getTotalCost())
                .append("menberLevel", getMenberLevel())
                .append("idCard", getIdCard())
                .append("addTime", getAddTime())
                .append("openId", getOpenId())
                .toString();
    }
}
