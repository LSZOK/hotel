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
import com.ruoyi.project.system.domain.PickUpService;
import com.ruoyi.project.system.service.IPickUpServiceService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 接机服务Controller
 * 
 * @author lusenzhu
 * @date 2020-11-29
 */
@RestController
@RequestMapping("/system/pickUpService")
public class PickUpServiceController extends BaseController
{
    @Autowired
    private IPickUpServiceService pickUpServiceService;

    /**
     * 查询接机服务列表
     */
    @PreAuthorize("@ss.hasPermi('system:pickUpService:list')")
    @GetMapping("/list")
    public TableDataInfo list(PickUpService pickUpService)
    {
        startPage();
        List<PickUpService> list = pickUpServiceService.selectPickUpServiceList(pickUpService);
        return getDataTable(list);
    }

    /**
     * 导出接机服务列表
     */
    @PreAuthorize("@ss.hasPermi('system:pickUpService:export')")
    @Log(title = "接机服务", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PickUpService pickUpService)
    {
        List<PickUpService> list = pickUpServiceService.selectPickUpServiceList(pickUpService);
        ExcelUtil<PickUpService> util = new ExcelUtil<PickUpService>(PickUpService.class);
        return util.exportExcel(list, "pickUpService");
    }

    /**
     * 获取接机服务详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pickUpService:query')")
    @GetMapping(value = "/{pickUpId}")
    public AjaxResult getInfo(@PathVariable("pickUpId") String pickUpId)
    {
        return AjaxResult.success(pickUpServiceService.selectPickUpServiceById(pickUpId));
    }

    /**
     * 新增接机服务
     */
    @PreAuthorize("@ss.hasPermi('system:pickUpService:add')")
    @Log(title = "接机服务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PickUpService pickUpService)
    {
        return toAjax(pickUpServiceService.insertPickUpService(pickUpService));
    }

    /**
     * 修改接机服务
     */

    @Log(title = "接机服务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PickUpService pickUpService)
    {
        return toAjax(pickUpServiceService.updatePickUpService(pickUpService));
    }

    /**
     * 删除接机服务
     */
    @PreAuthorize("@ss.hasPermi('system:pickUpService:remove')")
    @Log(title = "接机服务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pickUpIds}")
    public AjaxResult remove(@PathVariable String[] pickUpIds)
    {
        return toAjax(pickUpServiceService.deletePickUpServiceByIds(pickUpIds));
    }
}
