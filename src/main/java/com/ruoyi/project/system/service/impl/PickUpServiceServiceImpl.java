package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.PickUpServiceMapper;
import com.ruoyi.project.system.domain.PickUpService;
import com.ruoyi.project.system.service.IPickUpServiceService;

/**
 * 接机服务Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-11-29
 */
@Service
public class PickUpServiceServiceImpl implements IPickUpServiceService 
{
    @Autowired
    private PickUpServiceMapper pickUpServiceMapper;

    /**
     * 查询接机服务
     * 
     * @param pickUpId 接机服务ID
     * @return 接机服务
     */
    @Override
    public PickUpService selectPickUpServiceById(String pickUpId)
    {
        return pickUpServiceMapper.selectPickUpServiceById(pickUpId);
    }

    /**
     * 查询接机服务列表
     * 
     * @param pickUpService 接机服务
     * @return 接机服务
     */
    @Override
    public List<PickUpService> selectPickUpServiceList(PickUpService pickUpService)
    {
        return pickUpServiceMapper.selectPickUpServiceList(pickUpService);
    }

    /**
     * 新增接机服务
     * 
     * @param pickUpService 接机服务
     * @return 结果
     */
    @Override
    public int insertPickUpService(PickUpService pickUpService)
    {
        return pickUpServiceMapper.insertPickUpService(pickUpService);
    }

    /**
     * 修改接机服务
     * 
     * @param pickUpService 接机服务
     * @return 结果
     */
    @Override
    public int updatePickUpService(PickUpService pickUpService)
    {
        return pickUpServiceMapper.updatePickUpService(pickUpService);
    }

    /**
     * 批量删除接机服务
     * 
     * @param pickUpIds 需要删除的接机服务ID
     * @return 结果
     */
    @Override
    public int deletePickUpServiceByIds(String[] pickUpIds)
    {
        return pickUpServiceMapper.deletePickUpServiceByIds(pickUpIds);
    }

    /**
     * 删除接机服务信息
     * 
     * @param pickUpId 接机服务ID
     * @return 结果
     */
    @Override
    public int deletePickUpServiceById(String pickUpId)
    {
        return pickUpServiceMapper.deletePickUpServiceById(pickUpId);
    }
}
