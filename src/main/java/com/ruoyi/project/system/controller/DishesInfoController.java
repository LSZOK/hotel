package com.ruoyi.project.system.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.domain.DishesInfo;
import com.ruoyi.project.system.domain.DishesType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.service.IDishesInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 菜品信息Controller
 * 
 * @author ruoyi
 * @date 2020-10-13
 */
@RestController
@RequestMapping("/system/dishesInfo")
public class DishesInfoController extends BaseController
{
    @Autowired
    private IDishesInfoService dishesInfoService;

    /*
     * 获取菜品类型
     * */
    @GetMapping("/getDishesType")
    public TableDataInfo getDishesType(){
        List<DishesType> list = dishesInfoService.selectDishesTypeList();
        return getDataTable(list);


    }



    /*
    * 获取菜品编号
    * */

    public String  getDishesId(){
         SimpleDateFormat df = new SimpleDateFormat("MMddHHmmss");
         String dateTime=df.format(new Date());
         Random random=new Random();
         String DishesId=dateTime+random.nextInt(100);

         return DishesId;
     }

    /**
     * 查询菜品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(DishesInfo dishesInfo)
    {
        startPage();
        List<DishesInfo> list = dishesInfoService.selectDishesInfoList(dishesInfo);
        return getDataTable(list);
    }

    /**
     * 导出菜品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "菜品信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DishesInfo dishesInfo)
    {
        List<DishesInfo> list = dishesInfoService.selectDishesInfoList(dishesInfo);
        ExcelUtil<DishesInfo> util = new ExcelUtil<DishesInfo>(DishesInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取菜品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dishesInfoService.selectDishesInfoById(id));
    }

    /**
     * 新增菜品信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "菜品信息", businessType = BusinessType.INSERT)
    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestParam("dishesName") String dishesName, @RequestParam("dishesType") Long dishesType, @RequestParam("picture") String picture, @RequestParam("price") Long price, @RequestParam("description") String description, @RequestParam("addTime") String addTime,MultipartFile file) throws IOException {
        System.out.println(dishesName);
        String pictureURL = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
        String dishesId=getDishesId();
        DishesInfo dishesInfo=new DishesInfo();
        dishesInfo.setDishesId(dishesId);
        dishesInfo.setDishesName(dishesName);
        dishesInfo.setDishesId(dishesId);
        dishesInfo.setDishesType(dishesType);
        dishesInfo.setPicture(pictureURL);
        dishesInfo.setPrice(price);
        dishesInfo.setAddTime(addTime);
        dishesInfo.setDescription(description);

        return toAjax(dishesInfoService.insertDishesInfo(dishesInfo));
    }

    /**
     * 修改菜品信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "菜品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestParam("id")long id,@RequestParam("dishesId") String dishesId,@RequestParam("dishesName") String dishesName,  @RequestParam("dishesType") Long dishesType, @RequestParam("picture") String picture, @RequestParam("price") Long price, @RequestParam("description") String description, @RequestParam("addTime") String addTime,MultipartFile file) throws IOException {
        DishesInfo dishesInfo=new DishesInfo();
      if(file!=null)
      {
          String pictureURL = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
          dishesInfo.setPicture(pictureURL);
      }
      else{
          dishesInfo.setPicture(picture);
      }

        dishesInfo.setId(id);
        dishesInfo.setDishesName(dishesName);
        dishesInfo.setDishesId(dishesId);
        dishesInfo.setDishesType(dishesType);

        dishesInfo.setPrice(price);
        dishesInfo.setAddTime(addTime);
        dishesInfo.setDescription(description);
        System.out.println(dishesInfo.toString());
        return toAjax(dishesInfoService.updateDishesInfo(dishesInfo));
    }

    /**
     * 删除菜品信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "菜品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dishesInfoService.deleteDishesInfoByIds(ids));
    }
}
