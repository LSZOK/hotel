package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.ClientMapper;
import com.ruoyi.project.system.domain.Client;
import com.ruoyi.project.system.service.IClientService;

/**
 * 客户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-21
 */
@Service
public class ClientServiceImpl implements IClientService 
{
    @Autowired
    private ClientMapper clientMapper;

    /**
     * 查询客户信息
     * 
     * @param clientId 客户信息ID
     * @return 客户信息
     */
    @Override
    public Client selectClientById(String clientId)
    {
        return clientMapper.selectClientById(clientId);
    }

    /**
     * 查询客户信息列表
     * 
     * @param client 客户信息
     * @return 客户信息
     */
    @Override
    public List<Client> selectClientList(Client client)
    {
        return clientMapper.selectClientList(client);
    }

    /**
     * 新增客户信息
     * 
     * @param client 客户信息
     * @return 结果
     */
    @Override
    public int insertClient(Client client)
    {
        return clientMapper.insertClient(client);
    }

    /**
     * 修改客户信息
     * 
     * @param client 客户信息
     * @return 结果
     */
    @Override
    public int updateClient(Client client)
    {
        return clientMapper.updateClient(client);
    }

    /**
     * 批量删除客户信息
     * 
     * @param clientIds 需要删除的客户信息ID
     * @return 结果
     */
    @Override
    public int deleteClientByIds(String[] clientIds)
    {
        return clientMapper.deleteClientByIds(clientIds);
    }

    /**
     * 删除客户信息信息
     * 
     * @param clientId 客户信息ID
     * @return 结果
     */
    @Override
    public int deleteClientById(String clientId)
    {
        return clientMapper.deleteClientById(clientId);
    }
}
