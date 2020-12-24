package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.HotelOutMapper;
import com.ruoyi.project.system.domain.HotelOut;
import com.ruoyi.project.system.service.IHotelOutService;

/**
 * 退房信息Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
@Service
public class HotelOutServiceImpl implements IHotelOutService 
{
    @Autowired
    private HotelOutMapper hotelOutMapper;

    /**
     * 查询退房信息
     * 
     * @param outId 退房信息ID
     * @return 退房信息
     */
    @Override
    public HotelOut selectHotelOutById(String outId)
    {
        return hotelOutMapper.selectHotelOutById(outId);
    }

    /**
     * 查询退房信息列表
     * 
     * @param hotelOut 退房信息
     * @return 退房信息
     */
    @Override
    public List<HotelOut> selectHotelOutList(HotelOut hotelOut)
    {
        return hotelOutMapper.selectHotelOutList(hotelOut);
    }

    /**
     * 新增退房信息
     * 
     * @param hotelOut 退房信息
     * @return 结果
     */
    @Override
    public int insertHotelOut(HotelOut hotelOut)
    {
        return hotelOutMapper.insertHotelOut(hotelOut);
    }

    /**
     * 修改退房信息
     * 
     * @param hotelOut 退房信息
     * @return 结果
     */
    @Override
    public int updateHotelOut(HotelOut hotelOut)
    {
        return hotelOutMapper.updateHotelOut(hotelOut);
    }

    /**
     * 批量删除退房信息
     * 
     * @param outIds 需要删除的退房信息ID
     * @return 结果
     */
    @Override
    public int deleteHotelOutByIds(String[] outIds)
    {
        return hotelOutMapper.deleteHotelOutByIds(outIds);
    }

    /**
     * 删除退房信息信息
     * 
     * @param outId 退房信息ID
     * @return 结果
     */
    @Override
    public int deleteHotelOutById(String outId)
    {
        return hotelOutMapper.deleteHotelOutById(outId);
    }
}
