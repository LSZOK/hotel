package com.ruoyi.project.system.service.impl;

import java.util.List;

import com.ruoyi.project.system.domain.DishesType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DishesInfoMapper;
import com.ruoyi.project.system.domain.DishesInfo;
import com.ruoyi.project.system.service.IDishesInfoService;

/**
 * 菜品信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-13
 */
@Service
public class DishesInfoServiceImpl implements IDishesInfoService 
{
    @Autowired
    private DishesInfoMapper dishesInfoMapper;

    /**
     * 查询菜品信息
     * 
     * @param id 菜品信息ID
     * @return 菜品信息
     */
    @Override
    public DishesInfo selectDishesInfoById(Long id)
    {
        return dishesInfoMapper.selectDishesInfoById(id);
    }

    /**
     * 查询菜品信息列表
     * 
     * @param dishesInfo 菜品信息
     * @return 菜品信息
     */
    @Override
    public List<DishesInfo> selectDishesInfoList(DishesInfo dishesInfo)
    {
        return dishesInfoMapper.selectDishesInfoList(dishesInfo);
    }

    /**
     * 新增菜品信息
     * 
     * @param dishesInfo 菜品信息
     * @return 结果
     */
    @Override
    public int insertDishesInfo(DishesInfo dishesInfo)
    {
        return dishesInfoMapper.insertDishesInfo(dishesInfo);
    }

    /**
     * 修改菜品信息
     * 
     * @param dishesInfo 菜品信息
     * @return 结果
     */
    @Override
    public int updateDishesInfo(DishesInfo dishesInfo)
    {
        return dishesInfoMapper.updateDishesInfo(dishesInfo);
    }

    /**
     * 批量删除菜品信息
     * 
     * @param ids 需要删除的菜品信息ID
     * @return 结果
     */
    @Override
    public int deleteDishesInfoByIds(Long[] ids)
    {
        return dishesInfoMapper.deleteDishesInfoByIds(ids);
    }

    /**
     * 删除菜品信息信息
     * 
     * @param id 菜品信息ID
     * @return 结果
     */
    @Override
    public int deleteDishesInfoById(Long id)
    {
        return dishesInfoMapper.deleteDishesInfoById(id);
    }

    @Override
    public List<DishesType> selectDishesTypeList() {
        return dishesInfoMapper.selectDishesTypeList();
    }
}
