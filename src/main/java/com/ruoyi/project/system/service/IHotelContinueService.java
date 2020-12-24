package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.HotelContinue;

/**
 * 续住信息Service接口
 *
 * @author ruoyi
 * @date 2020-10-21
 */
public interface IHotelContinueService
{
    /**
     * 查询续住信息
     *
     * @param continueId 续住信息ID
     * @return 续住信息
     */
    public HotelContinue selectHotelContinueById(String continueId);

    /**
     * 查询续住信息列表
     *
     * @param hotelContinue 续住信息
     * @return 续住信息集合
     */
    public List<HotelContinue> selectHotelContinueList(HotelContinue hotelContinue);

    /**
     * 新增续住信息
     *
     * @param hotelContinue 续住信息
     * @return 结果
     */
    public int insertHotelContinue(HotelContinue hotelContinue);

    /**
     * 修改续住信息
     *
     * @param hotelContinue 续住信息
     * @return 结果
     */
    public int updateHotelContinue(HotelContinue hotelContinue);

    /**
     * 批量删除续住信息
     *
     * @param continueIds 需要删除的续住信息ID
     * @return 结果
     */
    public int deleteHotelContinueByIds(String[] continueIds);

    /**
     * 删除续住信息信息
     *
     * @param continueId 续住信息ID
     * @return 结果
     */
    public int deleteHotelContinueById(String continueId);
}