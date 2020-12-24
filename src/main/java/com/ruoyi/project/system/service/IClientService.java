package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.Client;

/**
 * 客户信息Service接口
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
public interface IClientService 
{
    /**
     * 查询客户信息
     * 
     * @param clientId 客户信息ID
     * @return 客户信息
     */
    public Client selectClientById(String clientId);

    /**
     * 查询客户信息列表
     * 
     * @param client 客户信息
     * @return 客户信息集合
     */
    public List<Client> selectClientList(Client client);

    /**
     * 新增客户信息
     * 
     * @param client 客户信息
     * @return 结果
     */
    public int insertClient(Client client);

    /**
     * 修改客户信息
     * 
     * @param client 客户信息
     * @return 结果
     */
    public int updateClient(Client client);

    /**
     * 批量删除客户信息
     * 
     * @param clientIds 需要删除的客户信息ID
     * @return 结果
     */
    public int deleteClientByIds(String[] clientIds);

    /**
     * 删除客户信息信息
     * 
     * @param clientId 客户信息ID
     * @return 结果
     */
    public int deleteClientById(String clientId);
}
