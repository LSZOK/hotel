package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.DishesTypeMapper;
import com.ruoyi.project.system.domain.DishesType;
import com.ruoyi.project.system.service.IDishesTypeService;

/**
 * 菜品类型Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
@Service
public class DishesTypeServiceImpl implements IDishesTypeService 
{
    @Autowired
    private DishesTypeMapper dishesTypeMapper;

    /**
     * 查询菜品类型
     * 
     * @param id 菜品类型ID
     * @return 菜品类型
     */
    @Override
    public DishesType selectDishesTypeById(Long id)
    {
        return dishesTypeMapper.selectDishesTypeById(id);
    }

    /**
     * 查询菜品类型列表
     * 
     * @param dishesType 菜品类型
     * @return 菜品类型
     */
    @Override
    public List<DishesType> selectDishesTypeList(DishesType dishesType)
    {
        return dishesTypeMapper.selectDishesTypeList(dishesType);
    }

    /**
     * 新增菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    @Override
    public int insertDishesType(DishesType dishesType)
    {
        return dishesTypeMapper.insertDishesType(dishesType);
    }

    /**
     * 修改菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    @Override
    public int updateDishesType(DishesType dishesType)
    {
        return dishesTypeMapper.updateDishesType(dishesType);
    }

    /**
     * 批量删除菜品类型
     * 
     * @param ids 需要删除的菜品类型ID
     * @return 结果
     */
    @Override
    public int deleteDishesTypeByIds(Long[] ids)
    {
        return dishesTypeMapper.deleteDishesTypeByIds(ids);
    }

    /**
     * 删除菜品类型信息
     * 
     * @param id 菜品类型ID
     * @return 结果
     */
    @Override
    public int deleteDishesTypeById(Long id)
    {
        return dishesTypeMapper.deleteDishesTypeById(id);
    }
}
