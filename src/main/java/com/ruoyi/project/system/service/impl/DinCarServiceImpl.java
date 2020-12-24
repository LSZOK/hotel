package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DinCarMapper;
import com.ruoyi.project.system.domain.DinCar;
import com.ruoyi.project.system.service.IDinCarService;

/**
 * 订餐车Service业务层处理
 * 
 * @author lusezhu
 * @date 2020-10-22
 */
@Service
public class DinCarServiceImpl implements IDinCarService 
{
    @Autowired
    private DinCarMapper dinCarMapper;

    /**
     * 查询订餐车
     * 
     * @param carId 订餐车ID
     * @return 订餐车
     */
    @Override
    public DinCar selectDinCarById(String carId)
    {
        return dinCarMapper.selectDinCarById(carId);
    }

    /**
     * 查询订餐车列表
     * 
     * @param dinCar 订餐车
     * @return 订餐车
     */
    @Override
    public List<DinCar> selectDinCarList(DinCar dinCar)
    {
        return dinCarMapper.selectDinCarList(dinCar);
    }

    /**
     * 新增订餐车
     * 
     * @param dinCar 订餐车
     * @return 结果
     */
    @Override
    public int insertDinCar(DinCar dinCar)
    {
        return dinCarMapper.insertDinCar(dinCar);
    }

    /**
     * 修改订餐车
     * 
     * @param dinCar 订餐车
     * @return 结果
     */
    @Override
    public int updateDinCar(DinCar dinCar)
    {
        return dinCarMapper.updateDinCar(dinCar);
    }

    /**
     * 批量删除订餐车
     * 
     * @param carIds 需要删除的订餐车ID
     * @return 结果
     */
    @Override
    public int deleteDinCarByIds(String[] carIds)
    {
        return dinCarMapper.deleteDinCarByIds(carIds);
    }

    /**
     * 删除订餐车信息
     * 
     * @param carId 订餐车ID
     * @return 结果
     */
    @Override
    public int deleteDinCarById(String carId)
    {
        return dinCarMapper.deleteDinCarById(carId);
    }
}
