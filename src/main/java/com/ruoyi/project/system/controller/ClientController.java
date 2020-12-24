package com.ruoyi.project.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.domain.Client;
import com.ruoyi.project.system.service.IClientService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 客户信息Controller
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
@RestController
@RequestMapping("/system/client")
public class ClientController extends BaseController
{
    @Autowired
    private IClientService clientService;

    /**
     * 查询客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:client:list')")
    @GetMapping("/list")
    public TableDataInfo list(Client client)
    {
        startPage();
        List<Client> list = clientService.selectClientList(client);
        return getDataTable(list);
    }

    /**
     * 导出客户信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:client:export')")
    @Log(title = "客户信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Client client)
    {
        List<Client> list = clientService.selectClientList(client);
        ExcelUtil<Client> util = new ExcelUtil<Client>(Client.class);
        return util.exportExcel(list, "client");
    }

    /**
     * 获取客户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:client:query')")
    @GetMapping(value = "/{clientId}")
    public AjaxResult getInfo(@PathVariable("clientId") String clientId)
    {
        return AjaxResult.success(clientService.selectClientById(clientId));
    }
    /**
     * 新增客户信息
     */

    @PreAuthorize("@ss.hasPermi('system:client:add')")
    @Log(title = "客户信息", businessType = BusinessType.INSERT)
    @PostMapping

    public AjaxResult add(@RequestParam("clientName") String clientName, @RequestParam("sex") String sex, @RequestParam("phone") String phone, Long menberLevel, @RequestParam("totalCost") Long totalCost, @RequestParam("idCard") String idCard)
    {
        String date= DateUtils.dateTimeNow();
        Date addTime=DateUtils.getNowDate();
        Random random=new Random();
        int i=random.nextInt(100);
        String clientId=date+i;

        AjaxResult ajax = AjaxResult.success();
        ajax.put("clientId",clientId);
        ajax.put("addTime",addTime);
        Client client=new Client();
        client.setClientId(clientId);
        client.setClientName(clientName);
        client.setSex(sex);
        client.setPhone(phone);
        client.setIdCard(idCard);
        client.setAddTime(addTime);
        client.setTotalCost(totalCost);
        client.setMenberLevel(menberLevel);
        clientService.insertClient(client);
        return  ajax;
    }
    /**
     * 修改客户信息
     */
    @PreAuthorize("@ss.hasPermi('system:client:edit')")
    @Log(title = "客户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Client client)
    {
        return toAjax(clientService.updateClient(client));
    }

    /**
     * 删除客户信息
     */
    @PreAuthorize("@ss.hasPermi('system:client:remove')")
    @Log(title = "客户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{clientIds}")
    public AjaxResult remove(@PathVariable String[] clientIds)
    {
        return toAjax(clientService.deleteClientByIds(clientIds));
    }
}
