package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.PickUpService;

/**
 * 接机服务Mapper接口
 * 
 * @author lusenzhu
 * @date 2020-11-29
 */
public interface PickUpServiceMapper 
{
    /**
     * 查询接机服务
     * 
     * @param pickUpId 接机服务ID
     * @return 接机服务
     */
    public PickUpService selectPickUpServiceById(String pickUpId);

    /**
     * 查询接机服务列表
     * 
     * @param pickUpService 接机服务
     * @return 接机服务集合
     */
    public List<PickUpService> selectPickUpServiceList(PickUpService pickUpService);

    /**
     * 新增接机服务
     * 
     * @param pickUpService 接机服务
     * @return 结果
     */
    public int insertPickUpService(PickUpService pickUpService);

    /**
     * 修改接机服务
     * 
     * @param pickUpService 接机服务
     * @return 结果
     */
    public int updatePickUpService(PickUpService pickUpService);

    /**
     * 删除接机服务
     * 
     * @param pickUpId 接机服务ID
     * @return 结果
     */
    public int deletePickUpServiceById(String pickUpId);

    /**
     * 批量删除接机服务
     * 
     * @param pickUpIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePickUpServiceByIds(String[] pickUpIds);
}
