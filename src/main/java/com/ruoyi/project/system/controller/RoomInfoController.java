package com.ruoyi.project.system.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.system.domain.RoomInfo;
import com.ruoyi.project.system.domain.RoomType;
import com.ruoyi.project.system.service.IRoomInfoService;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 客房信息Controller
 * 
 * @author lusenzhu
 * @date 2020-10-13
 */
@RestController
@RequestMapping("/system/roomInfo")
public class RoomInfoController extends BaseController
{
    @Autowired
    private IRoomInfoService roomInfoService;

    /*
    * 更新房间状态
    * */
    @PostMapping("/updateStatus")
    public AjaxResult updateStatus(Long roomId, Integer status){

        System.out.println(roomId);
        System.out.println(status);
        RoomInfo roomInfo=new RoomInfo();
       roomInfo.setRoomId(roomId);
        roomInfo.setStatus(status);
       roomInfoService.updateRoomInfo(roomInfo);
        return  AjaxResult.success(200);
    }



    /*
    * 获取楼层房号最大值
    * */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:list')")
    @GetMapping("/MaxRoomNum")
    @ResponseBody
    public AjaxResult list(HttpServletRequest request)
    {
        String floor=request.getParameter("0");
        System.out.println(floor);
        List MaxRoomNum=roomInfoService.selectMaxRoomNum(floor);
        System.out.println(MaxRoomNum);


//        MaxRoomNum+=1;
        return AjaxResult.success(MaxRoomNum);
    }


    /**
     * 查询客房信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:list')")
    @GetMapping("/list")
    public AjaxResult list(RoomInfo roomInfo)
    {
        List<RoomInfo> list = roomInfoService.selectRoomInfoList(roomInfo);
        return AjaxResult.success(list);
    }
     /*
     * 查询客房类型信息列表
     * */

    @PreAuthorize("@ss.hasPermi('system:room:list')")
    @GetMapping("/roomTypeList")
    public AjaxResult list()
    {

        List<RoomType> list = roomInfoService.selectRoomType();
        return AjaxResult.success(list);
    }

    /**
     * 导出客房信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:export')")
    @Log(title = "客房信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(RoomInfo roomInfo)
    {
        List<RoomInfo> list = roomInfoService.selectRoomInfoList(roomInfo);
        ExcelUtil<RoomInfo> util = new ExcelUtil<RoomInfo>(RoomInfo.class);
        return util.exportExcel(list, "roomInfo");
    }

    /**
     * 获取客房信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:query')")
    @GetMapping(value = "/{roomId}")
    public AjaxResult getInfo(@PathVariable("roomId") Long roomId)
    {
        return AjaxResult.success(roomInfoService.selectRoomInfoById(roomId));
    }

    /**
     * 新增客房信息管理
     */
    @CrossOrigin
    @PreAuthorize("@ss.hasPermi('system:room:add')")
    @Log(title = "客房信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    @ResponseBody
    public AjaxResult add( @RequestParam("roomNum") Long roomNum, @RequestParam("parentId")  Long parentId,@RequestParam("floor") String floor, @RequestParam("price") Long price, @RequestParam("roomType") Long roomType, @RequestParam("bedType") String bedType, @RequestParam("havewindow") Integer havewindow, @RequestParam("roomArea") String roomArea, @RequestParam("roomPicture") String roomPicture, @RequestParam("status") Integer status, @RequestParam("roomIntroduce") String roomIntroduce, @RequestParam("addtime") Date addtime, @RequestParam("file") MultipartFile file  ) throws IOException
    {

        AjaxResult ajax = AjaxResult.success();

        RoomInfo roomInfo=new RoomInfo();
        roomInfo.setParentId(parentId);
        roomInfo.setRoomNum(roomNum);
        roomInfo.setFloor(floor);
        roomInfo.setPrice(price);
        roomInfo.setRoomType(roomType);
        roomInfo.setBedType(bedType);
        roomInfo.setHavewindow(havewindow);
        roomInfo.setRoomArea(roomArea);
        roomInfo.setStatus(status);
        roomInfo.setRoomIntroduce(roomIntroduce);
        roomInfo.setAddtime(addtime);
        System.out.println(roomInfo.toString());
            String pictureURL = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
            roomInfo.setRoomPicture(pictureURL);
            ajax.put("imgUrl", pictureURL);







        roomInfoService.insertRoomInfo(roomInfo);

        return ajax;
        //return toAjax(roomInfoService.insertRoomInfo(roomInfo));
    }

    /**
     * 修改客房信息管理
     */
    @CrossOrigin
    @PreAuthorize("@ss.hasPermi('system:room:edit')")
    @Log(title = "客房信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    @ResponseBody
    public AjaxResult edit(@RequestParam("roomId") Long roomId, @RequestParam("parentId") Long parentId, @RequestParam("roomNum") Long roomNum, @RequestParam("floor") String floor, @RequestParam("price") Long price, @RequestParam("roomType") Long roomType, @RequestParam("bedType") String bedType, @RequestParam("havewindow") Integer havewindow, @RequestParam("roomArea") String roomArea, @RequestParam("roomPicture") String roomPicture, @RequestParam("status") Integer status, @RequestParam("roomIntroduce") String roomIntroduce, @RequestParam("addtime") Date addtime,  MultipartFile file  ) throws IOException {
        RoomInfo roomInfo=new RoomInfo();
        AjaxResult ajax = AjaxResult.success();
        if(file!=null)
        {
            String pictureURL = FileUploadUtils.upload(RuoYiConfig.getAvatarPath(), file);
            roomInfo.setRoomPicture(pictureURL);
            ajax.put("imgUrl", pictureURL);
        }
        else{
            roomInfo.setRoomPicture(roomPicture);
        }
        roomInfo.setRoomId(roomId);
        roomInfo.setRoomNum(roomNum);
        roomInfo.setFloor(floor);
        roomInfo.setPrice(price);
        roomInfo.setRoomType(roomType);
        roomInfo.setBedType(bedType);
        roomInfo.setHavewindow(havewindow);
        roomInfo.setRoomArea(roomArea);
        roomInfo.setStatus(status);
        roomInfo.setRoomIntroduce(roomIntroduce);
        roomInfo.setAddtime(addtime);
        System.out.println(roomInfo.toString());
        roomInfoService.updateRoomInfo(roomInfo);

        return ajax;
    }

    /**
     * 删除客房信息
     */
    @PreAuthorize("@ss.hasPermi('system:roomInfo:remove')")
    @Log(title = "客房信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomIds}")
    public AjaxResult remove(@PathVariable Long[] roomIds)
    {
        return toAjax(roomInfoService.deleteRoomInfoByIds(roomIds));
    }
}
