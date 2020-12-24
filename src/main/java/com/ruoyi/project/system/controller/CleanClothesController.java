package com.ruoyi.project.system.controller;

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
import com.ruoyi.project.system.domain.CleanClothes;
import com.ruoyi.project.system.service.ICleanClothesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 清洁衣物Controller
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/system/cleanClothes")
public class CleanClothesController extends BaseController
{
    @Autowired
    private ICleanClothesService cleanClothesService;

    /**
     * 查询清洁衣物列表
     */
    @PreAuthorize("@ss.hasPermi('system:cleanClothes:list')")
    @GetMapping("/list")
    public TableDataInfo list(CleanClothes cleanClothes)
    {
        startPage();
        List<CleanClothes> list = cleanClothesService.selectCleanClothesList(cleanClothes);
        return getDataTable(list);
    }

    /**
     * 导出清洁衣物列表
     */
    @PreAuthorize("@ss.hasPermi('system:cleanClothes:export')")
    @Log(title = "清洁衣物", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CleanClothes cleanClothes)
    {
        List<CleanClothes> list = cleanClothesService.selectCleanClothesList(cleanClothes);
        ExcelUtil<CleanClothes> util = new ExcelUtil<CleanClothes>(CleanClothes.class);
        return util.exportExcel(list, "cleanClothes");
    }

    /**
     * 获取清洁衣物详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cleanClothes:query')")
    @GetMapping(value = "/{cleanClothesId}")
    public AjaxResult getInfo(@PathVariable("cleanClothesId") String cleanClothesId)
    {
        return AjaxResult.success(cleanClothesService.selectCleanClothesById(cleanClothesId));
    }

    /**
     * 新增清洁衣物
     */
    @PreAuthorize("@ss.hasPermi('system:cleanClothes:add')")
    @Log(title = "清洁衣物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CleanClothes cleanClothes)
    {
        String date= DateUtils.dateTime();
        Random random=new Random();
        int i=random.nextInt(300);
        String cleanClothesId=date+i;
        cleanClothes.setCleanClothesId(cleanClothesId);
        cleanClothes.setStatus("0");
        return toAjax(cleanClothesService.insertCleanClothes(cleanClothes));
    }

    /**
     * 修改清洁衣物
     */
    @PreAuthorize("@ss.hasPermi('system:cleanClothes:edit')")
    @Log(title = "清洁衣物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CleanClothes cleanClothes)
    {
        return toAjax(cleanClothesService.updateCleanClothes(cleanClothes));
    }

    /**
     * 删除清洁衣物
     */
    @PreAuthorize("@ss.hasPermi('system:cleanClothes:remove')")
    @Log(title = "清洁衣物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cleanClothesIds}")
    public AjaxResult remove(@PathVariable String[] cleanClothesIds)
    {
        return toAjax(cleanClothesService.deleteCleanClothesByIds(cleanClothesIds));
    }
}
