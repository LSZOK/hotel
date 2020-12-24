package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.DishesType;

/**
 * 菜品类型Mapper接口
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
public interface DishesTypeMapper 
{
    /**
     * 查询菜品类型
     * 
     * @param id 菜品类型ID
     * @return 菜品类型
     */
    public DishesType selectDishesTypeById(Long id);

    /**
     * 查询菜品类型列表
     * 
     * @param dishesType 菜品类型
     * @return 菜品类型集合
     */
    public List<DishesType> selectDishesTypeList(DishesType dishesType);

    /**
     * 新增菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    public int insertDishesType(DishesType dishesType);

    /**
     * 修改菜品类型
     * 
     * @param dishesType 菜品类型
     * @return 结果
     */
    public int updateDishesType(DishesType dishesType);

    /**
     * 删除菜品类型
     * 
     * @param id 菜品类型ID
     * @return 结果
     */
    public int deleteDishesTypeById(Long id);

    /**
     * 批量删除菜品类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDishesTypeByIds(Long[] ids);
}
