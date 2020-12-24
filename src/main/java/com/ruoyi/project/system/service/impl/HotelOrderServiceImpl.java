package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.HotelOrderMapper;
import com.ruoyi.project.system.domain.HotelOrder;
import com.ruoyi.project.system.service.IHotelOrderService;

/**
 * 订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
@Service
public class HotelOrderServiceImpl implements IHotelOrderService 
{
    @Autowired
    private HotelOrderMapper hotelOrderMapper;

    /**
     * 查询订单信息
     * 
     * @param orderId 订单信息ID
     * @return 订单信息
     */
    @Override
    public HotelOrder selectHotelOrderById(String orderId)
    {
        return hotelOrderMapper.selectHotelOrderById(orderId);
    }

    /**
     * 查询订单信息列表
     * 
     * @param hotelOrder 订单信息
     * @return 订单信息
     */
    @Override
    public List<HotelOrder> selectHotelOrderList(HotelOrder hotelOrder)
    {
        return hotelOrderMapper.selectHotelOrderList(hotelOrder);
    }

    /**
     * 新增订单信息
     * 
     * @param hotelOrder 订单信息
     * @return 结果
     */
    @Override
    public int insertHotelOrder(HotelOrder hotelOrder)
    {
        return hotelOrderMapper.insertHotelOrder(hotelOrder);
    }

    /**
     * 修改订单信息
     * 
     * @param hotelOrder 订单信息
     * @return 结果
     */
    @Override
    public int updateHotelOrder(HotelOrder hotelOrder)
    {
        return hotelOrderMapper.updateHotelOrder(hotelOrder);
    }

    /**
     * 批量删除订单信息
     * 
     * @param orderIds 需要删除的订单信息ID
     * @return 结果
     */
    @Override
    public int deleteHotelOrderByIds(String[] orderIds)
    {
        return hotelOrderMapper.deleteHotelOrderByIds(orderIds);
    }

    /**
     * 删除订单信息信息
     * 
     * @param orderId 订单信息ID
     * @return 结果
     */
    @Override
    public int deleteHotelOrderById(String orderId)
    {
        return hotelOrderMapper.deleteHotelOrderById(orderId);
    }


}
