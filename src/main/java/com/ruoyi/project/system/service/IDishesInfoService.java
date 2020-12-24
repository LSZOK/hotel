package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.DishesInfo;
import com.ruoyi.project.system.domain.DishesType;

/**
 * 菜品信息Service接口
 * 
 * @author ruoyi
 * @date 2020-10-13
 */
public interface IDishesInfoService 
{
    /**
     * 查询菜品信息
     * 
     * @param id 菜品信息ID
     * @return 菜品信息
     */
    public DishesInfo selectDishesInfoById(Long id);

    /**
     * 查询菜品信息列表
     * 
     * @param dishesInfo 菜品信息
     * @return 菜品信息集合
     */
    public List<DishesInfo> selectDishesInfoList(DishesInfo dishesInfo);

    /**
     * 新增菜品信息
     * 
     * @param dishesInfo 菜品信息
     * @return 结果
     */
    public int insertDishesInfo(DishesInfo dishesInfo);

    /**
     * 修改菜品信息
     * 
     * @param dishesInfo 菜品信息
     * @return 结果
     */
    public int updateDishesInfo(DishesInfo dishesInfo);

    /**
     * 批量删除菜品信息
     * 
     * @param ids 需要删除的菜品信息ID
     * @return 结果
     */
    public int deleteDishesInfoByIds(Long[] ids);

    /**
     * 删除菜品信息信息
     * 
     * @param id 菜品信息ID
     * @return 结果
     */
    public int deleteDishesInfoById(Long id);

    List<DishesType> selectDishesTypeList();
}
