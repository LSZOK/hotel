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
import com.ruoyi.project.system.domain.BaggageDeposit;
import com.ruoyi.project.system.service.IBaggageDepositService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 行李寄存Controller
 * 
 * @author lunsezhu
 * @date 2020-11-27
 */
@RestController
@RequestMapping("/system/baggageDeposit")
public class BaggageDepositController extends BaseController
{
    @Autowired
    private IBaggageDepositService baggageDepositService;

    /**
     * 查询行李寄存列表
     */
    @PreAuthorize("@ss.hasPermi('system:baggageDeposit:list')")
    @GetMapping("/list")
    public TableDataInfo list(BaggageDeposit baggageDeposit)
    {
        startPage();
        List<BaggageDeposit> list = baggageDepositService.selectBaggageDepositList(baggageDeposit);
        return getDataTable(list);
    }

    /**
     * 导出行李寄存列表
     */
    @PreAuthorize("@ss.hasPermi('system:baggageDeposit:export')")
    @Log(title = "行李寄存", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BaggageDeposit baggageDeposit)
    {
        List<BaggageDeposit> list = baggageDepositService.selectBaggageDepositList(baggageDeposit);
        ExcelUtil<BaggageDeposit> util = new ExcelUtil<BaggageDeposit>(BaggageDeposit.class);
        return util.exportExcel(list, "baggageDeposit");
    }

    /**
     * 获取行李寄存详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:baggageDeposit:query')")
    @GetMapping(value = "/{baggageId}")
    public AjaxResult getInfo(@PathVariable("baggageId") String baggageId)
    {
        return AjaxResult.success(baggageDepositService.selectBaggageDepositById(baggageId));
    }

    /**
     * 新增行李寄存
     */
    @PreAuthorize("@ss.hasPermi('system:baggageDeposit:add')")
    @Log(title = "行李寄存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BaggageDeposit baggageDeposit)
    {
        return toAjax(baggageDepositService.insertBaggageDeposit(baggageDeposit));
    }

    /**
     * 修改行李寄存
     */
    @PreAuthorize("@ss.hasPermi('system:baggageDeposit:edit')")
    @Log(title = "行李寄存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BaggageDeposit baggageDeposit)
    {
        return toAjax(baggageDepositService.updateBaggageDeposit(baggageDeposit));
    }

    /**
     * 删除行李寄存
     */
    @PreAuthorize("@ss.hasPermi('system:baggageDeposit:remove')")
    @Log(title = "行李寄存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{baggageIds}")
    public AjaxResult remove(@PathVariable String[] baggageIds)
    {
        return toAjax(baggageDepositService.deleteBaggageDepositByIds(baggageIds));
    }
}
