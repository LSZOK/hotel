package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.CheckIn;

/**
 * 登记入住Service接口
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
public interface ICheckInService 
{
    /**
     * 查询登记入住
     * 
     * @param id 登记入住ID
     * @return 登记入住
     */
    public CheckIn selectCheckInById(Long id);

    /**
     * 查询登记入住列表
     * 
     * @param checkIn 登记入住
     * @return 登记入住集合
     */
    public List<CheckIn> selectCheckInList(CheckIn checkIn);

    /**
     * 新增登记入住
     * 
     * @param checkIn 登记入住
     * @return 结果
     */
    public int insertCheckIn(CheckIn checkIn);

    /**
     * 修改登记入住
     * 
     * @param checkIn 登记入住
     * @return 结果
     */
    public int updateCheckIn(CheckIn checkIn);

    /**
     * 批量删除登记入住
     *
     * @param ids 需要删除的登记入住ID
     * @return 结果
     */
    public int deleteCheckInByIds(Long[] ids);

    /**
     * 删除登记入住信息
     *
     * @param id 登记入住ID
     * @return 结果
     */
    public int deleteCheckInById(Long id);
}
