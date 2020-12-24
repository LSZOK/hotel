package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.BaggageDeposit;

/**
 * 行李寄存Mapper接口
 * 
 * @author lunsezhu
 * @date 2020-11-27
 */
public interface BaggageDepositMapper 
{
    /**
     * 查询行李寄存
     * 
     * @param baggageId 行李寄存ID
     * @return 行李寄存
     */
    public BaggageDeposit selectBaggageDepositById(String baggageId);

    /**
     * 查询行李寄存列表
     * 
     * @param baggageDeposit 行李寄存
     * @return 行李寄存集合
     */
    public List<BaggageDeposit> selectBaggageDepositList(BaggageDeposit baggageDeposit);

    /**
     * 新增行李寄存
     * 
     * @param baggageDeposit 行李寄存
     * @return 结果
     */
    public int insertBaggageDeposit(BaggageDeposit baggageDeposit);

    /**
     * 修改行李寄存
     * 
     * @param baggageDeposit 行李寄存
     * @return 结果
     */
    public int updateBaggageDeposit(BaggageDeposit baggageDeposit);

    /**
     * 删除行李寄存
     * 
     * @param baggageId 行李寄存ID
     * @return 结果
     */
    public int deleteBaggageDepositById(String baggageId);

    /**
     * 批量删除行李寄存
     * 
     * @param baggageIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteBaggageDepositByIds(String[] baggageIds);
}
