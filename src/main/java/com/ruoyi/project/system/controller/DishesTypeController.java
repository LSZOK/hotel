package com.ruoyi.project.system.controller;

import java.util.List;

import com.ruoyi.project.system.domain.DishesType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.service.IDishesTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 菜品类型Controller
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
@RestController
@RequestMapping("/system/dishesType")
public class DishesTypeController extends BaseController
{
    @Autowired
    private IDishesTypeService dishesTypeService;

    /**
     * 查询菜品类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:dishesType:list')")
    @GetMapping("/list")
    public TableDataInfo list(DishesType dishesType)
    {
        startPage();
        List<DishesType> list = dishesTypeService.selectDishesTypeList(dishesType);
        return getDataTable(list);
    }

    /**
     * 导出菜品类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:dishesType:export')")
    @Log(title = "菜品类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DishesType dishesType)
    {
        List<DishesType> list = dishesTypeService.selectDishesTypeList(dishesType);
        ExcelUtil<DishesType> util = new ExcelUtil<DishesType>(DishesType.class);
        return util.exportExcel(list, "dishesType");
    }

    /**
     * 获取菜品类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:dishesType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dishesTypeService.selectDishesTypeById(id));
    }

    /**
     * 新增菜品类型
     */
    @PreAuthorize("@ss.hasPermi('system:dishesType:add')")
    @Log(title = "菜品类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DishesType dishesType)
    {
        return toAjax(dishesTypeService.insertDishesType(dishesType));
    }

    /**
     * 修改菜品类型
     */
    @PreAuthorize("@ss.hasPermi('system:dishesType:edit')")
    @Log(title = "菜品类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DishesType dishesType)
    {
        return toAjax(dishesTypeService.updateDishesType(dishesType));
    }

    /**
     * 删除菜品类型
     */
    @PreAuthorize("@ss.hasPermi('system:dishesType:remove')")
    @Log(title = "菜品类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dishesTypeService.deleteDishesTypeByIds(ids));
    }
}
