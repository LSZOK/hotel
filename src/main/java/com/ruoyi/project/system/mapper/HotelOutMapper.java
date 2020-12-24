package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.HotelOut;

/**
 * 退房信息Mapper接口
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
public interface HotelOutMapper 
{
    /**
     * 查询退房信息
     * 
     * @param outId 退房信息ID
     * @return 退房信息
     */
    public HotelOut selectHotelOutById(String outId);

    /**
     * 查询退房信息列表
     * 
     * @param hotelOut 退房信息
     * @return 退房信息集合
     */
    public List<HotelOut> selectHotelOutList(HotelOut hotelOut);

    /**
     * 新增退房信息
     * 
     * @param hotelOut 退房信息
     * @return 结果
     */
    public int insertHotelOut(HotelOut hotelOut);

    /**
     * 修改退房信息
     * 
     * @param hotelOut 退房信息
     * @return 结果
     */
    public int updateHotelOut(HotelOut hotelOut);

    /**
     * 删除退房信息
     * 
     * @param outId 退房信息ID
     * @return 结果
     */
    public int deleteHotelOutById(String outId);

    /**
     * 批量删除退房信息
     * 
     * @param outIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotelOutByIds(String[] outIds);
}
