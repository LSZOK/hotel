package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 行李寄存对象 baggage_deposit
 *
 * @author lunsezhu
 * @date 2020-11-27
 */
public class BaggageDeposit {
    private static final long serialVersionUID = 1L;

    /**
     * 行李寄存编号
     */
    private String baggageId;

    /**
     * 客户姓名
     */
    @Excel(name = "客户姓名")
    private String clientName;

    /**
     * 客户openId
     */
    @Excel(name = "客户openId")
    private String clientId;

    /**
     * 行李件数
     */
    @Excel(name = "行李件数")
    private String num;

    /**
     * 经办人
     */
    @Excel(name = "经办人")
    private String operator;

    /**
     * 行李图片
     */
    @Excel(name = "行李图片")
    private String pictures;

    /**
     * 添加时间
     */
    @Excel(name = "添加时间")
    private String addTime;

    /**
     * 领取时间
     */
    @Excel(name = "领取时间")
    private String takeTime;

    private String status;
    private String detail;
    private  String price;

    public void setBaggageId(String baggageId) {
        this.baggageId = baggageId;
    }

    public String getBaggageId() {
        return baggageId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getPictures() {
        return pictures;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setTakeTime(String takeTime) {
        this.takeTime = takeTime;
    }

    public String getTakeTime() {
        return takeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("baggageId", getBaggageId())
                .append("clientName", getClientName())
                .append("clientId", getClientId())
                .append("num", getNum())
                .append("operator", getOperator())
                .append("pictures", getPictures())
                .append("addTime", getAddTime())
                .append("takeTime", getTakeTime())
                .append("status", status)
                .append("detail", getDetail())
                .append("price",getPrice())
                .toString();
    }
}
