package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 清洁衣物对象 clean_clothes
 *
 * @author lusenzhu
 * @date 2020-10-22
 */
public class CleanClothes extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 衣物清洗编号
     */
    private String cleanClothesId;

    /**
     * 酒店订单号
     */
    @Excel(name = "j酒店订单号")
    private String orderId;

    /**
     * 房间编号
     */
    @Excel(name = "房间编号")
    private String roomCode;

    /**
     * 房号
     */
    @Excel(name = "房号")
    private Long roomNum;

    /**
     * 入住人
     */
    @Excel(name = "入住人")
    private String user;
    /*备注*/
    private String remark;

    /**
     * 清洁状态
     */
    @Excel(name = "清洁状态")
    private String status;

    /**
     * 清洗费用
     */
    @Excel(name = "清洗费用")
    private Long cleanCost;

    /**
     * 添加时间
     */
    @Excel(name = "添加时间")
    private String addTime;

    private String bookTakeClothesTime;

    public void setCleanClothesId(String cleanClothesId) {
        this.cleanClothesId = cleanClothesId;
    }

    public String getCleanClothesId() {
        return cleanClothesId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomNum(Long roomNum) {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() {
        return roomNum;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCleanCost(Long cleanCost) {
        this.cleanCost = cleanCost;
    }

    public Long getCleanCost() {
        return cleanCost;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddTime() {
        return addTime;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBookTakeClothesTime() {
        return bookTakeClothesTime;
    }

    public void setBookTakeClothesTime(String bookTakeClothesTime) {
        this.bookTakeClothesTime = bookTakeClothesTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("cleanClothesId", getCleanClothesId())
                .append("orderId", getOrderId())
                .append("roomCode", getRoomCode())
                .append("roomNum", getRoomNum())
                .append("user", getUser())
                .append("status", getStatus())
                .append("cleanCost", getCleanCost())
                .append("addTime", getAddTime())
                .append("remark", getRemark())
                .append("bookTakeClothesTime", getBookTakeClothesTime())
                .toString();
    }
}
