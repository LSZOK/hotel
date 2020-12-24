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
import com.ruoyi.project.system.domain.HotelOrder;
import com.ruoyi.project.system.service.IHotelOrderService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 订单信息Controller
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
@RestController
@RequestMapping("/system/order")
public class HotelOrderController extends BaseController
{
    @Autowired
    private IHotelOrderService hotelOrderService;

    /**
     * 查询订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(HotelOrder hotelOrder)
    {
        startPage();
        List<HotelOrder> list = hotelOrderService.selectHotelOrderList(hotelOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "订单信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HotelOrder hotelOrder)
    {
        List<HotelOrder> list = hotelOrderService.selectHotelOrderList(hotelOrder);
        ExcelUtil<HotelOrder> util = new ExcelUtil<HotelOrder>(HotelOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取订单信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") String orderId)
    {
        return AjaxResult.success(hotelOrderService.selectHotelOrderById(orderId));
    }

    /**
     * 新增订单信息
     */
    @PreAuthorize("@ss.hasPermi('business:order:add')")
    @Log(title = "订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HotelOrder hotelOrder)
    {

        String date= DateUtils.dateTimeNow();
        Date addTime=DateUtils.getNowDate();
        Random random=new Random();
        int i=random.nextInt(200);
        String orderId=date+i;

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    //格式化规则
//        Date liveTime = hotelOrder.getLiveTime()    ;    //获得你要处理的时间 Date型
//        Date outTime=hotelOrder.getOutTime();
//        Date newAddTime=hotelOrder.getAddTime();
//
//        String strDate= sdf.format(liveTime ); //格式化成yyyy-MM-dd格式的时间字符串
//        String  strDate2=sdf.format(newAddTime );
//        String strDate3= sdf.format(outTime ); //格式化成yyyy-MM-dd格式的时间字符串
//        Date newDate = null;
//        Date newDate2=null;
//        Date newDate3=null;
//        try {
//            newDate = sdf.parse(strDate);
//            newDate2=sdf.parse(strDate2);
//            newDate3=sdf.parse(strDate3);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Date newLiveTime = new java.sql.Date(newDate.getTime());
//        java.sql.Date newOutTime = new java.sql.Date(newDate2.getTime());
//        java.sql.Date newATime = new java.sql.Date(newDate3.getTime());


        String roomCode=hotelOrder.getRoomNum()+date;
        hotelOrder.setOrderId(orderId);
        hotelOrder.setRoomCode(roomCode);

        AjaxResult ajaxResult=new AjaxResult(200,"操作成功");
        System.out.println(hotelOrder.toString());
        hotelOrderService.insertHotelOrder(hotelOrder);
        return   ajaxResult;

    }

    /**
     * 修改订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HotelOrder hotelOrder)
    {
       HotelOrder selectHotelOrder= hotelOrderService.selectHotelOrderById(hotelOrder.getOrderId());

        if(hotelOrder.getRoomCode()==null&&hotelOrder.getRoomNum()!=null){
            String date= DateUtils.dateTimeNow();
            String roomCode=hotelOrder.getRoomNum()+date;
            System.out.println("roomCOde:"+roomCode);
            hotelOrder.setRoomCode(roomCode);
        }
        return toAjax(hotelOrderService.updateHotelOrder(hotelOrder));
    }

    /**
     * 删除订单信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "订单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable String[] orderIds)
    {
        return toAjax(hotelOrderService.deleteHotelOrderByIds(orderIds));
    }
}
