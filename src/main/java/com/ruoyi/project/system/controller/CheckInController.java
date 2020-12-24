package com.ruoyi.project.system.controller;

import java.util.List;
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
import com.ruoyi.project.system.domain.CheckIn;
import com.ruoyi.project.system.service.ICheckInService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 登记入住Controller
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
@RestController
@RequestMapping("/business/checkIn")
public class CheckInController extends BaseController
{
    @Autowired
    private ICheckInService checkInService;

    /**
     * 查询登记入住列表
     */
    @PreAuthorize("@ss.hasPermi('business:checkIn:list')")
    @GetMapping("/list")
    public TableDataInfo list(CheckIn checkIn)
    {
        startPage();
        List<CheckIn> list = checkInService.selectCheckInList(checkIn);
        return getDataTable(list);
    }

    /**
     * 导出登记入住列表
     */
    @PreAuthorize("@ss.hasPermi('business:checkIn:export')")
    @Log(title = "登记入住", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CheckIn checkIn)
    {
        List<CheckIn> list = checkInService.selectCheckInList(checkIn);
        ExcelUtil<CheckIn> util = new ExcelUtil<CheckIn>(CheckIn.class);
        return util.exportExcel(list, "checkIn");
    }

    /**
     * 获取登记入住详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:checkIn:query')")
    @GetMapping(value = "/{clientId}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(checkInService.selectCheckInById(id));
    }

    /**
     * 新增登记入住
     */
    //@PreAuthorize("@ss.hasPermi('business:checkIn:add')")
    @Log(title = "登记入住", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CheckIn checkIn)
    {
        return toAjax(checkInService.insertCheckIn(checkIn));
    }

    /**
     * 修改登记入住
     */
    @PreAuthorize("@ss.hasPermi('business:checkIn:edit')")
    @Log(title = "登记入住", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CheckIn checkIn)
    {
        return toAjax(checkInService.updateCheckIn(checkIn));
    }

    /**
     * 删除登记入住
     */
    @PreAuthorize("@ss.hasPermi('business:checkIn:remove')")
    @Log(title = "登记入住", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(checkInService.deleteCheckInByIds(ids));
    }
}
