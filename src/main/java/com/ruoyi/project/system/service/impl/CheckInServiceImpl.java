package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.CheckInMapper;
import com.ruoyi.project.system.domain.CheckIn;
import com.ruoyi.project.system.service.ICheckInService;

/**
 * 登记入住Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
@Service
public class CheckInServiceImpl implements ICheckInService 
{
    @Autowired
    private CheckInMapper checkInMapper;

    /**
     * 查询登记入住
     * 
     * @param id 登记入住ID
     * @return 登记入住
     */
    @Override
    public CheckIn selectCheckInById(Long id)
    {
        return checkInMapper.selectCheckInById(id);
    }

    /**
     * 查询登记入住列表
     * 
     * @param checkIn 登记入住
     * @return 登记入住
     */
    @Override
    public List<CheckIn> selectCheckInList(CheckIn checkIn)
    {
        return checkInMapper.selectCheckInList(checkIn);
    }

    /**
     * 新增登记入住
     * 
     * @param checkIn 登记入住
     * @return 结果
     */
    @Override
    public int insertCheckIn(CheckIn checkIn)
    {
        return checkInMapper.insertCheckIn(checkIn);
    }

    /**
     * 修改登记入住
     * 
     * @param checkIn 登记入住
     * @return 结果
     */
    @Override
    public int updateCheckIn(CheckIn checkIn)
    {
        return checkInMapper.updateCheckIn(checkIn);
    }

    /**
     * 批量删除登记入住
     * 
     * @param ids 需要删除的登记入住ID
     * @return 结果
     */
    @Override
    public int deleteCheckInByIds(Long[] ids)
    {
        return checkInMapper.deleteCheckInByIds(ids);
    }

    /**
     * 删除登记入住信息
     * 
     * @param id 登记入住ID
     * @return 结果
     */
    @Override
    public int deleteCheckInById(Long id)
    {
        return checkInMapper.deleteCheckInById(id);
    }
}
