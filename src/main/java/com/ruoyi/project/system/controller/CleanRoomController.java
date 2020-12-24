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
import com.ruoyi.project.system.domain.CleanRoom;
import com.ruoyi.project.system.service.ICleanRoomService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 清洁房间信息Controller
 * 
 * @author ruoyi
 * @date 2020-10-22
 */
@RestController
@RequestMapping("/business/cleanRoom")
public class CleanRoomController extends BaseController
{
    @Autowired
    private ICleanRoomService cleanRoomService;

    /**
     * 查询清洁房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:cleanRoom:list')")
    @GetMapping("/list")
    public TableDataInfo list(CleanRoom cleanRoom)
    {
        startPage();
        List<CleanRoom> list = cleanRoomService.selectCleanRoomList(cleanRoom);
        return getDataTable(list);
    }

    /**
     * 导出清洁房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:cleanRoom:export')")
    @Log(title = "清洁房间信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CleanRoom cleanRoom)
    {
        List<CleanRoom> list = cleanRoomService.selectCleanRoomList(cleanRoom);
        ExcelUtil<CleanRoom> util = new ExcelUtil<CleanRoom>(CleanRoom.class);
        return util.exportExcel(list, "cleanRoom");
    }

    /**
     * 获取清洁房间信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:cleanRoom:query')")
    @GetMapping(value = "/{cleanRoomId}")
    public AjaxResult getInfo(@PathVariable("cleanRoomId") String cleanRoomId)
    {
        return AjaxResult.success(cleanRoomService.selectCleanRoomById(cleanRoomId));
    }

    /**
     * 新增清洁房间信息
     */
    @PreAuthorize("@ss.hasPermi('business:cleanRoom:add')")
    @Log(title = "清洁房间信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CleanRoom cleanRoom)
    {

        String date= DateUtils.dateTime();
        Random random=new Random();
        int i=random.nextInt(250);
        String cleanRoomId=date+i;
        cleanRoom.setCleanRoomId(cleanRoomId);
        cleanRoom.setStatus("0");
        return toAjax(cleanRoomService.insertCleanRoom(cleanRoom));
    }

    /**
     * 修改清洁房间信息
     */
    @PreAuthorize("@ss.hasPermi('business:cleanRoom:edit')")
    @Log(title = "清洁房间信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CleanRoom cleanRoom)
    {
        return toAjax(cleanRoomService.updateCleanRoom(cleanRoom));
    }

    /**
     * 删除清洁房间信息
     */
    @PreAuthorize("@ss.hasPermi('business:cleanRoom:remove')")
    @Log(title = "清洁房间信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cleanRoomIds}")
    public AjaxResult remove(@PathVariable String[] cleanRoomIds)
    {
        return toAjax(cleanRoomService.deleteCleanRoomByIds(cleanRoomIds));
    }
}
