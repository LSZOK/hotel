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
import com.ruoyi.project.system.domain.MembershipLevel;
import com.ruoyi.project.system.service.IMembershipLevelService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 会员等级Controller
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
@RestController
@RequestMapping("/system/level")
public class MembershipLevelController extends BaseController
{
    @Autowired
    private IMembershipLevelService membershipLevelService;

    /**
     * 查询会员等级列表
     */
    @PreAuthorize("@ss.hasPermi('system:level:list')")
    @GetMapping("/list")
    public TableDataInfo list(MembershipLevel membershipLevel)
    {
        System.out.println(membershipLevel.toString());
        startPage();
        List<MembershipLevel> list = membershipLevelService.selectMembershipLevelList(membershipLevel);
        System.out.println(list);
        return getDataTable(list);
    }

    /**
     * 导出会员等级列表
     */
    @PreAuthorize("@ss.hasPermi('system:level:export')")
    @Log(title = "会员等级", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MembershipLevel membershipLevel)
    {
        List<MembershipLevel> list = membershipLevelService.selectMembershipLevelList(membershipLevel);
        ExcelUtil<MembershipLevel> util = new ExcelUtil<MembershipLevel>(MembershipLevel.class);
        return util.exportExcel(list, "level");
    }

    /**
     * 获取会员等级详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {

        return AjaxResult.success(membershipLevelService.selectMembershipLevelById(id));
    }

    /**
     * 新增会员等级
     */
    @PreAuthorize("@ss.hasPermi('system:level:add')")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MembershipLevel membershipLevel)

    {
        System.out.println(membershipLevel.toString());
        return toAjax(membershipLevelService.insertMembershipLevel(membershipLevel));
    }

    /**
     * 修改会员等级
     */
    @PreAuthorize("@ss.hasPermi('system:level:edit')")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MembershipLevel membershipLevel)
    {
        System.out.println(membershipLevel.toString());
        return toAjax(membershipLevelService.updateMembershipLevel(membershipLevel));
    }

    /**
     * 删除会员等级
     */
    @PreAuthorize("@ss.hasPermi('system:level:remove')")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(membershipLevelService.deleteMembershipLevelByIds(ids));
    }
}
