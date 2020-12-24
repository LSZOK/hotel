package com.ruoyi.project.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.ruoyi.project.system.domain.HotelContinue;
import com.ruoyi.project.system.service.IHotelContinueService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 续住信息Controller
 *
 * @author ruoyi
 * @date 2020-10-21
 */
@RestController
@RequestMapping("/system/continue")
public class HotelContinueController extends BaseController
{
    @Autowired
    private IHotelContinueService hotelContinueService;

    /**
     * 查询续住信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:continue:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelContinue hotelContinue)
    {
        startPage();
        List<HotelContinue> list = hotelContinueService.selectHotelContinueList(hotelContinue);
        return getDataTable(list);
    }

    /**
     * 导出续住信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:continue:export')")
    @Log(title = "续住信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelContinue hotelContinue)
    {
        List<HotelContinue> list = hotelContinueService.selectHotelContinueList(hotelContinue);
        ExcelUtil<HotelContinue> util = new ExcelUtil<HotelContinue>(HotelContinue.class);
        return util.exportExcel(list, "continue");
    }

    /**
     * 获取续住信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:continue:query')")
    @GetMapping(value = "/{continueId}")
    public AjaxResult getInfo(@PathVariable("continueId") String continueId)
    {
        return AjaxResult.success(hotelContinueService.selectHotelContinueById(continueId));
    }

    /**
     * 新增续住信息
     */
    @PreAuthorize("@ss.hasPermi('system:continue:add')")
    @Log(title = "续住信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelContinue hotelContinue)
    {
        String date= DateUtils.dateTimeNow();
        Date addTime=DateUtils.getNowDate();
        Random random=new Random();
        int i=random.nextInt(100)+100;
        String continueId=i+date;
        hotelContinue.setContinueId(continueId);

        Date dateTime1 = DateUtils.parseDate(hotelContinue.getContinueTime());
        Date dateTime2=DateUtils.parseDate(hotelContinue.getOutTime());

        System.out.println(dateTime1);
        System.out.println(dateTime2);

        Long total=hotelContinue.getPrice()* DateUtils.getDay(dateTime2,dateTime1);
        hotelContinue.setTotal(total);
        hotelContinueService.insertHotelContinue(hotelContinue);
        AjaxResult ajaxResult=AjaxResult.success();
        ajaxResult.put("total",total);
        return ajaxResult;
    }

    /**
     * 修改续住信息
     */
    @PreAuthorize("@ss.hasPermi('system:continue:edit')")
    @Log(title = "续住信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelContinue hotelContinue)
    {
        return toAjax(hotelContinueService.updateHotelContinue(hotelContinue));
    }

    /**
     * 删除续住信息
     */
    @PreAuthorize("@ss.hasPermi('system:continue:remove')")
    @Log(title = "续住信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{continueIds}")
    public AjaxResult remove(@PathVariable String[] continueIds)
    {
        return toAjax(hotelContinueService.deleteHotelContinueByIds(continueIds));
    }
}