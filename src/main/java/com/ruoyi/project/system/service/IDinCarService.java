package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.DinCar;

/**
 * 订餐车Service接口
 * 
 * @author lusezhu
 * @date 2020-10-22
 */
public interface IDinCarService 
{
    /**
     * 查询订餐车
     * 
     * @param carId 订餐车ID
     * @return 订餐车
     */
    public DinCar selectDinCarById(String carId);

    /**
     * 查询订餐车列表
     * 
     * @param dinCar 订餐车
     * @return 订餐车集合
     */
    public List<DinCar> selectDinCarList(DinCar dinCar);

    /**
     * 新增订餐车
     * 
     * @param dinCar 订餐车
     * @return 结果
     */
    public int insertDinCar(DinCar dinCar);

    /**
     * 修改订餐车
     * 
     * @param dinCar 订餐车
     * @return 结果
     */
    public int updateDinCar(DinCar dinCar);

    /**
     * 批量删除订餐车
     * 
     * @param carIds 需要删除的订餐车ID
     * @return 结果
     */
    public int deleteDinCarByIds(String[] carIds);

    /**
     * 删除订餐车信息
     * 
     * @param carId 订餐车ID
     * @return 结果
     */
    public int deleteDinCarById(String carId);
}
