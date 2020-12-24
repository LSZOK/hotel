package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 登记入住对象 check_in
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
public class CheckIn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderId;

    /** 房间编号 */
    @Excel(name = "房间编号")
    private String roomCode;

    /** 房号 */
    @Excel(name = "房号")
    private Long roomNum;

    /** 入住人 */
    @Excel(name = "入住人")
    private String username;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 身份证 */
    @Excel(name = "身份证")
    private String idCard;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operator;

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
    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public void setRoomNum(Long roomNum)
    {
        this.roomNum = roomNum;
    }

    public Long getRoomNum() 
    {
        return roomNum;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }
    public void setAddTime(String addTime)
    {
        this.addTime = addTime;
    }

    public String getAddTime()
    {
        return addTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderId", getOrderId())
            .append("roomCode", getRoomCode())
            .append("roomNum", getRoomNum())
            .append("username", getUsername())
            .append("sex", getSex())
            .append("idCard", getIdCard())
            .append("phone", getPhone())
            .append("remark", getRemark())
            .append("operator", getOperator())
            .append("addTime", getAddTime())
            .toString();
    }
}
