package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.HotelContinueMapper;
import com.ruoyi.project.system.domain.HotelContinue;
import com.ruoyi.project.system.service.IHotelContinueService;

/**
 * 续住信息Service业务层处理
 *
 * @author ruoyi
 * @date 2020-10-21
 */
@Service
public class HotelContinueServiceImpl implements IHotelContinueService
{
    @Autowired
    private HotelContinueMapper hotelContinueMapper;

    /**
     * 查询续住信息
     *
     * @param continueId 续住信息ID
     * @return 续住信息
     */
    @Override
    public HotelContinue selectHotelContinueById(String continueId)
    {
        return hotelContinueMapper.selectHotelContinueById(continueId);
    }

    /**
     * 查询续住信息列表
     *
     * @param hotelContinue 续住信息
     * @return 续住信息
     */
    @Override
    public List<HotelContinue> selectHotelContinueList(HotelContinue hotelContinue)
    {
        return hotelContinueMapper.selectHotelContinueList(hotelContinue);
    }

    /**
     * 新增续住信息
     *
     * @param hotelContinue 续住信息
     * @return 结果
     */
    @Override
    public int insertHotelContinue(HotelContinue hotelContinue)
    {
        return hotelContinueMapper.insertHotelContinue(hotelContinue);
    }

    /**
     * 修改续住信息
     *
     * @param hotelContinue 续住信息
     * @return 结果
     */
    @Override
    public int updateHotelContinue(HotelContinue hotelContinue)
    {
        return hotelContinueMapper.updateHotelContinue(hotelContinue);
    }

    /**
     * 批量删除续住信息
     *
     * @param continueIds 需要删除的续住信息ID
     * @return 结果
     */
    @Override
    public int deleteHotelContinueByIds(String[] continueIds)
    {
        return hotelContinueMapper.deleteHotelContinueByIds(continueIds);
    }

    /**
     * 删除续住信息信息
     *
     * @param continueId 续住信息ID
     * @return 结果
     */
    @Override
    public int deleteHotelContinueById(String continueId)
    {
        return hotelContinueMapper.deleteHotelContinueById(continueId);
    }
}