package com.ruoyi.project.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.domain.HotelOrder;
import com.ruoyi.project.system.service.IHotelOrderService;
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
import com.ruoyi.project.system.domain.HotelOut;
import com.ruoyi.project.system.service.IHotelOutService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 退房信息Controller
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/business/hotelOut")
public class HotelOutController extends BaseController
{
    @Autowired
    private IHotelOutService hotelOutService;

    @Autowired
    private IHotelOrderService hotelOrderService;

    /**
     * 查询退房信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:hotelOut:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelOut hotelOut)
    {
        startPage();
        List<HotelOut> list = hotelOutService.selectHotelOutList(hotelOut);
        return getDataTable(list);
    }

    /**
     * 导出退房信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:hotelOut:export')")
    @Log(title = "退房信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelOut hotelOut)
    {
        List<HotelOut> list = hotelOutService.selectHotelOutList(hotelOut);
        ExcelUtil<HotelOut> util = new ExcelUtil<HotelOut>(HotelOut.class);
        return util.exportExcel(list, "hotelOut");
    }

    /**
     * 获取退房信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:hotelOut:query')")
    @GetMapping(value = "/{outId}")
    public AjaxResult getInfo(@PathVariable("outId") String outId)
    {
        return AjaxResult.success(hotelOutService.selectHotelOutById(outId));
    }

    /**
     * 新增退房信息
     */
    @PreAuthorize("@ss.hasPermi('business:hotelOut:add')")
    @Log(title = "退房信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelOut hotelOut)
    {
        String date= DateUtils.dateTimeNow();
        Random random=new Random();
        int i=random.nextInt(450);
        String outId=i+date;
        hotelOut.setOutId(outId);

        HotelOrder hotelOrder=new HotelOrder();
        hotelOrder.setOrderId(hotelOut.getOrderId());
        hotelOrder.setStatus("3");
        hotelOrderService.updateHotelOrder(hotelOrder);
        return toAjax(hotelOutService.insertHotelOut(hotelOut));
    }

    /**
     * 修改退房信息
     */
    @PreAuthorize("@ss.hasPermi('business:hotelOut:edit')")
    @Log(title = "退房信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelOut hotelOut)
    {
        return toAjax(hotelOutService.updateHotelOut(hotelOut));
    }

    /**
     * 删除退房信息
     */
    @PreAuthorize("@ss.hasPermi('business:hotelOut:remove')")
    @Log(title = "退房信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{outIds}")
    public AjaxResult remove(@PathVariable String[] outIds)
    {
        return toAjax(hotelOutService.deleteHotelOutByIds(outIds));
    }
}
