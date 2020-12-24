package com.ruoyi.project.system.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.project.system.domain.RoomType;
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
import com.ruoyi.project.system.service.IRoomTypeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 房间类型Controller
 * 
 * @author lusenzhu
 * @date 2020-10-12
 */
@RestController
@RequestMapping("/system/roomtype")
public class RoomTypeController extends BaseController
{
    @Autowired
    private IRoomTypeService roomTypeService;

    /**
     * 查询房间类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:roomtype:list')")
    @GetMapping("/list")
    public TableDataInfo list(RoomType roomType) {
//
//      try {
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    //格式化规则
//          Date date = roomType.getAddtime();         //获得你要处理的时间 Date型
//          String strDate= sdf.format(date ); //格式化成yyyy-MM-dd格式的时间字符串
//          Date newDate =sdf.parse(strDate);
//          java.sql.Date resultDate = new java.sql.Date(newDate.getTime());
//      }catch (ParseException e) {
//          e.printStackTrace();
//      }
        System.out.println(roomType.getAddtime());
        startPage();
        List<RoomType> list = roomTypeService.selectRoomTypeList(roomType);
        return getDataTable(list);
    }

    /**
     * 导出房间类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:roomtype:export')")
    @Log(title = "房间类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RoomType roomType)
    {
        List<RoomType> list = roomTypeService.selectRoomTypeList(roomType);
        ExcelUtil<RoomType> util = new ExcelUtil<RoomType>(RoomType.class);
        return util.exportExcel(list, "roomtype");
    }

    /**
     * 获取房间类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomtype:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(roomTypeService.selectRoomTypeById(id));
    }

    /**
     * 新增房间类型
     */
    @PreAuthorize("@ss.hasPermi('system:roomtype:add')")
    @Log(title = "房间类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RoomType roomType)
    {
        return toAjax(roomTypeService.insertRoomType(roomType));
    }

    /**
     * 修改房间类型
     */
    @PreAuthorize("@ss.hasPermi('system:roomtype:edit')")
    @Log(title = "房间类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RoomType roomType)
    {
        return toAjax(roomTypeService.updateRoomType(roomType));
    }

    /**
     * 删除房间类型
     */
    @PreAuthorize("@ss.hasPermi('system:roomtype:remove')")
    @Log(title = "房间类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(roomTypeService.deleteRoomTypeByIds(ids));
    }
}
