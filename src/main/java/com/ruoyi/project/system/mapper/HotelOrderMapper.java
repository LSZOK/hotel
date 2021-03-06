package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.HotelOrder;

/**
 * 订单信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
public interface HotelOrderMapper 
{
    /**
     * 查询订单信息
     * 
     * @param orderId 订单信息ID
     * @return 订单信息
     */
    public HotelOrder selectHotelOrderById(String orderId);

    /**
     * 查询订单信息列表
     * 
     * @param hotelOrder 订单信息
     * @return 订单信息集合
     */
    public List<HotelOrder> selectHotelOrderList(HotelOrder hotelOrder);

    /**
     * 新增订单信息
     * 
     * @param hotelOrder 订单信息
     * @return 结果
     */
    public int insertHotelOrder(HotelOrder hotelOrder);

    /**
     * 修改订单信息
     * 
     * @param hotelOrder 订单信息
     * @return 结果
     */
    public int updateHotelOrder(HotelOrder hotelOrder);

    /**
     * 删除订单信息
     * 
     * @param orderId 订单信息ID
     * @return 结果
     */
    public int deleteHotelOrderById(String orderId);

    /**
     * 批量删除订单信息
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelOrderByIds(String[] orderIds);


}
