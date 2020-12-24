package com.ruoyi.project.system.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.RoomPictures;
import com.ruoyi.project.system.service.IRoomPicturesService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 房间图片Controller
 * 
 * @author lusenzhu
 * @date 2020-11-18
 */
@RestController
@RequestMapping("/system/pictures")
public class RoomPicturesController extends BaseController
{
    @Autowired
    private IRoomPicturesService roomPicturesService;

    /**
     * 查询房间图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:pictures:list')")
    @GetMapping("/list")
    public TableDataInfo list(RoomPictures roomPictures)
    {
        startPage();
        List<RoomPictures> list = roomPicturesService.selectRoomPicturesList(roomPictures);
        return getDataTable(list);
    }

    /**
     * 导出房间图片列表
     */
    @PreAuthorize("@ss.hasPermi('system:pictures:export')")
    @Log(title = "房间图片", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RoomPictures roomPictures)
    {
        List<RoomPictures> list = roomPicturesService.selectRoomPicturesList(roomPictures);
        ExcelUtil<RoomPictures> util = new ExcelUtil<RoomPictures>(RoomPictures.class);
        return util.exportExcel(list, "pictures");
    }

    /**
     * 获取房间图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:pictures:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(roomPicturesService.selectRoomPicturesById(id));
    }

    /**
     * 新增房间图片
     */
    @PreAuthorize("@ss.hasPermi('system:pictures:add')")
    @Log(title = "房间图片", businessType = BusinessType.INSERT)
    @PostMapping
    @ResponseBody
    public AjaxResult add(@RequestParam("file") MultipartFile file ,@RequestParam("roomTypeId") String roomTypeId) throws  IOException
    {
        RoomPictures roomPictures=new RoomPictures();





         String pictureURL = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);




        roomPictures.setPictures(pictureURL);
        roomPictures.setRoomTypeId(roomTypeId);
        return toAjax(roomPicturesService.insertRoomPictures(roomPictures));
    }

    /**
     * 修改房间图片
     */
    @PreAuthorize("@ss.hasPermi('system:pictures:edit')")
    @Log(title = "房间图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RoomPictures roomPictures)
    {
        return toAjax(roomPicturesService.updateRoomPictures(roomPictures));
    }

    /**
     * 删除房间图片
     */
    @PreAuthorize("@ss.hasPermi('system:pictures:remove')")
    @Log(title = "房间图片", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(roomPicturesService.deleteRoomPicturesByIds(ids));
    }
}
