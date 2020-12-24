package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.BaggageDepositMapper;
import com.ruoyi.project.system.domain.BaggageDeposit;
import com.ruoyi.project.system.service.IBaggageDepositService;

/**
 * 行李寄存Service业务层处理
 * 
 * @author lunsezhu
 * @date 2020-11-27
 */
@Service
public class BaggageDepositServiceImpl implements IBaggageDepositService 
{
    @Autowired
    private BaggageDepositMapper baggageDepositMapper;

    /**
     * 查询行李寄存
     * 
     * @param baggageId 行李寄存ID
     * @return 行李寄存
     */
    @Override
    public BaggageDeposit selectBaggageDepositById(String baggageId)
    {
        return baggageDepositMapper.selectBaggageDepositById(baggageId);
    }

    /**
     * 查询行李寄存列表
     * 
     * @param baggageDeposit 行李寄存
     * @return 行李寄存
     */
    @Override
    public List<BaggageDeposit> selectBaggageDepositList(BaggageDeposit baggageDeposit)
    {
        return baggageDepositMapper.selectBaggageDepositList(baggageDeposit);
    }

    /**
     * 新增行李寄存
     * 
     * @param baggageDeposit 行李寄存
     * @return 结果
     */
    @Override
    public int insertBaggageDeposit(BaggageDeposit baggageDeposit)
    {
        return baggageDepositMapper.insertBaggageDeposit(baggageDeposit);
    }

    /**
     * 修改行李寄存
     * 
     * @param baggageDeposit 行李寄存
     * @return 结果
     */
    @Override
    public int updateBaggageDeposit(BaggageDeposit baggageDeposit)
    {
        return baggageDepositMapper.updateBaggageDeposit(baggageDeposit);
    }

    /**
     * 批量删除行李寄存
     * 
     * @param baggageIds 需要删除的行李寄存ID
     * @return 结果
     */
    @Override
    public int deleteBaggageDepositByIds(String[] baggageIds)
    {
        return baggageDepositMapper.deleteBaggageDepositByIds(baggageIds);
    }

    /**
     * 删除行李寄存信息
     * 
     * @param baggageId 行李寄存ID
     * @return 结果
     */
    @Override
    public int deleteBaggageDepositById(String baggageId)
    {
        return baggageDepositMapper.deleteBaggageDepositById(baggageId);
    }
}
