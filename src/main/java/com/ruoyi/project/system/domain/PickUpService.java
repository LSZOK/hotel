package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 接机服务对象 pick_up_service
 *
 * @author lusenzhu
 * @date 2020-11-29
 */
public class PickUpService {
    private static final long serialVersionUID = 1L;

    /**
     * 接机编号
     */
    private String pickUpId;

    /**
     * 接机类型 0 汽车 1火车 3动车 4飞机
     */
    @Excel(name = "接机类型 0 汽车 1火车 3动车 4飞机")
    private String pickUpType;

    /**
     * 接机日期
     */
    @Excel(name = "接机日期")
    private String pickUpTime;

    /**
     * 航班号
     */
    @Excel(name = "航班号")
    private String flightNumber;

    /**
     * 抵达时间
     */
    @Excel(name = "抵达时间")
    private String arriveTime;

    /**
     * 人数
     */
    @Excel(name = "人数")
    private String persionNum;

    /**
     * 客户编号
     */
    @Excel(name = "客户编号")
    private String clientId;

    /**
     * 联系人
     */
    @Excel(name = "联系人")
    private String clientName;

    /**
     * 联系电话
     */
    @Excel(name = "联系电话")
    private String phone;

    /**
     * 操作人
     */
    @Excel(name = "操作人")
    private String operator;

    /**
     * 添加时间
     */
    @Excel(name = "添加时间")
    private String addTime;

    /**
     * 备注
     */
    private String remark;

    private String status;

    public void setPickUpId(String pickUpId) {
        this.pickUpId = pickUpId;
    }

    public String getPickUpId() {
        return pickUpId;
    }

    public void setPickUpType(String pickUpType) {
        this.pickUpType = pickUpType;
    }

    public String getPickUpType() {
        return pickUpType;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setPersionNum(String persionNum) {
        this.persionNum = persionNum;
    }

    public String getPersionNum() {
        return persionNum;
    }

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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddTime() {
        return addTime;
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("pickUpId", getPickUpId())
                .append("pickUpType", getPickUpType())
                .append("pickUpTime", getPickUpTime())
                .append("flightNumber", getFlightNumber())
                .append("arriveTime", getArriveTime())
                .append("persionNum", getPersionNum())
                .append("clientId", getClientId())
                .append("clientName", getClientName())
                .append("phone", getPhone())
                .append("remark", getRemark())
                .append("operator", getOperator())
                .append("addTime", getAddTime())
                .append("status", getStatus())
                .toString();
    }
}
