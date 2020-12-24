package com.ruoyi.project.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.common.utils.DateUtils;
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
import com.ruoyi.project.system.domain.DinCar;
import com.ruoyi.project.system.service.IDinCarService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 订餐车Controller
 * 
 * @author lusezhu
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/system/car")
public class DinCarController extends BaseController
{
    @Autowired
    private IDinCarService dinCarService;


    /*获取餐车编号*/
    @PreAuthorize("@ss.hasPermi('system:car:list')")
    @GetMapping("/getCarId")
    public AjaxResult GetCarId(){
        AjaxResult ajaxResult=AjaxResult.success();
        String date= DateUtils.dateTimeNow();
        Date addTime=DateUtils.getNowDate();
        Random random=new Random();
        int i=random.nextInt(100)+150;
        String carId=i+date;
        ajaxResult.put("carId",carId);
        return  ajaxResult;
    }
    /**
     * 查询订餐车列表
     */
    @PreAuthorize("@ss.hasPermi('system:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(DinCar dinCar)
    {
        startPage();
        List<DinCar> list = dinCarService.selectDinCarList(dinCar);
        return getDataTable(list);
    }

    /**
     * 导出订餐车列表
     */
    @PreAuthorize("@ss.hasPermi('system:car:export')")
    @Log(title = "订餐车", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DinCar dinCar)
    {
        List<DinCar> list = dinCarService.selectDinCarList(dinCar);
        ExcelUtil<DinCar> util = new ExcelUtil<DinCar>(DinCar.class);
        return util.exportExcel(list, "car");
    }

    /**
     * 获取订餐车详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{carId}")
    public AjaxResult getInfo(@PathVariable("carId") String carId)
    {
        return AjaxResult.success(dinCarService.selectDinCarById(carId));
    }

    /**
     * 新增订餐车
     */
    @PreAuthorize("@ss.hasPermi('system:car:add')")
    @Log(title = "订餐车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DinCar dinCar)
    {
        return toAjax(dinCarService.insertDinCar(dinCar));
    }

    /**
     * 修改订餐车
     */
    @PreAuthorize("@ss.hasPermi('system:car:edit')")
    @Log(title = "订餐车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DinCar dinCar)
    {
        return toAjax(dinCarService.updateDinCar(dinCar));
    }

    /**
     * 删除订餐车
     */
    @PreAuthorize("@ss.hasPermi('system:car:remove')")
    @Log(title = "订餐车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carIds}")
    public AjaxResult remove(@PathVariable String[] carIds)
    {
        return toAjax(dinCarService.deleteDinCarByIds(carIds));
    }
}
