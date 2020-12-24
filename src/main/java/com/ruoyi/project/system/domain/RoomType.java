package com.ruoyi.project.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 房间类型对象 room_type
 *
 * @author lusenzhu
 * @date 2020-11-19
 */
public class RoomType 
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private String roomTypeName;

    /** 房间面积 */
    @Excel(name = "房间面积")
    private String roomArea;

    /** 床型 */
    @Excel(name = "床型")
    private String bedType;

    /** 是否有窗 */
    @Excel(name = "是否有窗")
    private String havewindows;

    /** 价格 */
    @Excel(name = "价格")
    private Long price;

    /** $column.columnComment */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "价格", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addtime;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setRoomTypeName(String roomTypeName)
    {
        this.roomTypeName = roomTypeName;
    }

    public String getRoomTypeName()
    {
        return roomTypeName;
    }
    public void setRoomArea(String roomArea)
    {
        this.roomArea = roomArea;
    }

    public String getRoomArea()
    {
        return roomArea;
    }
    public void setBedType(String bedType)
    {
        this.bedType = bedType;
    }

    public String getBedType()
    {
        return bedType;
    }
    public void setHavewindows(String havewindows)
    {
        this.havewindows = havewindows;
    }

    public String getHavewindows()
    {
        return havewindows;
    }
    public void setPrice(Long price)
    {
        this.price = price;
    }

    public Long getPrice()
    {
        return price;
    }
    public void setAddtime(Date addtime)
    {
        this.addtime = addtime;
    }

    public Date getAddtime()
    {
        return addtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("roomTypeName", getRoomTypeName())
                .append("roomArea", getRoomArea())
                .append("bedType", getBedType())
                .append("havewindows", getHavewindows())
                .append("price", getPrice())
                .append("addtime", getAddtime())
                .toString();
    }
}