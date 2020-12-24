package com.ruoyi.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 订餐车对象 din_car
 * 
 * @author lusezhu
 * @date 2020-10-22
 */
public class DinCar
{
    private static final long serialVersionUID = 1L;
    public DinCar(){

    }
    /** 餐车号 */
    private String carId;

    /** 菜品信息编号 */
    @Excel(name = "菜品信息编号")
    private Long dishesInfoId;

    /** 菜品名称 */
    @Excel(name = "菜品名称")
    private String dishesName;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderId;

    private String clientId;

    /** 房间编号 */
    @Excel(name = "房间编号")
    private String roomCode;

    /** 房号 */
    @Excel(name = "房号")
    private Long roomNum;

    /** 价格 */
    @Excel(name = "价格")
    private Double price;

    /** 份数 */
    @Excel(name = "份数")
    private Long count;

    /** 小计 */
    @Excel(name = "小计")
    private Double subtotal;

    /** 下单人 */
    @Excel(name = "下单人")
    private String orderUser;
    /*餐车转态*/
    private String status;




    /** 添加时间 */
    @Excel(name = "添加时间")
    private String addTime;

    private  String picture;

    public void setCarId(String carId) 
    {
        this.carId = carId;
    }

    public String getCarId() 
    {
        return carId;
    }
    public void setDishesInfoId(Long dishesInfoId) 
    {
        this.dishesInfoId = dishesInfoId;
    }

    public Long getDishesInfoId() 
    {
        return dishesInfoId;
    }
    public void setDishesName(String dishesName) 
    {
        this.dishesName = dishesName;
    }

    public String getDishesName() 
    {
        return dishesName;
    }
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setRoomCode(String roomCode) 
    {
        this.roomCode = roomCode;
    }

    public String getRoomCode() 
    {
        return roomCode;
    }
    public void setRoomNum(Long roomNum) 
    {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() 
    {
        return roomNum;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setOrderUser(String orderUser)
    {
        this.orderUser = orderUser;
    }

    public String getOrderUser() 
    {
        return orderUser;
    }
    public void setAddTime(String addTime) 
    {
        this.addTime = addTime;
    }

    public String getAddTime() 
    {
        return addTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("carId", getCarId())
            .append("dishesInfoId", getDishesInfoId())
            .append("dishesName", getDishesName())
            .append("orderId", getOrderId())
            .append("roomCode", getRoomCode())
            .append("roomNum", getRoomNum())
            .append("price", getPrice())
            .append("count", getCount())
            .append(" subtotal", getSubtotal())
            .append("orderUser", getOrderUser())
            .append("addTime", getAddTime())
            .append("status",getStatus())
            .append("clientId",getClientId())
            .append("picture",getPicture())
            .toString();
    }
}
