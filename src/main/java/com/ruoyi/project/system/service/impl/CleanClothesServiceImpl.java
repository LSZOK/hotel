package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.CleanClothesMapper;
import com.ruoyi.project.system.domain.CleanClothes;
import com.ruoyi.project.system.service.ICleanClothesService;

/**
 * 清洁衣物Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
@Service
public class CleanClothesServiceImpl implements ICleanClothesService 
{
    @Autowired
    private CleanClothesMapper cleanClothesMapper;

    /**
     * 查询清洁衣物
     * 
     * @param cleanClothesId 清洁衣物ID
     * @return 清洁衣物
     */
    @Override
    public CleanClothes selectCleanClothesById(String cleanClothesId)
    {
        return cleanClothesMapper.selectCleanClothesById(cleanClothesId);
    }

    /**
     * 查询清洁衣物列表
     * 
     * @param cleanClothes 清洁衣物
     * @return 清洁衣物
     */
    @Override
    public List<CleanClothes> selectCleanClothesList(CleanClothes cleanClothes)
    {
        return cleanClothesMapper.selectCleanClothesList(cleanClothes);
    }

    /**
     * 新增清洁衣物
     * 
     * @param cleanClothes 清洁衣物
     * @return 结果
     */
    @Override
    public int insertCleanClothes(CleanClothes cleanClothes)
    {
        return cleanClothesMapper.insertCleanClothes(cleanClothes);
    }

    /**
     * 修改清洁衣物
     * 
     * @param cleanClothes 清洁衣物
     * @return 结果
     */
    @Override
    public int updateCleanClothes(CleanClothes cleanClothes)
    {
        return cleanClothesMapper.updateCleanClothes(cleanClothes);
    }

    /**
     * 批量删除清洁衣物
     * 
     * @param cleanClothesIds 需要删除的清洁衣物ID
     * @return 结果
     */
    @Override
    public int deleteCleanClothesByIds(String[] cleanClothesIds)
    {
        return cleanClothesMapper.deleteCleanClothesByIds(cleanClothesIds);
    }

    /**
     * 删除清洁衣物信息
     * 
     * @param cleanClothesId 清洁衣物ID
     * @return 结果
     */
    @Override
    public int deleteCleanClothesById(String cleanClothesId)
    {
        return cleanClothesMapper.deleteCleanClothesById(cleanClothesId);
    }
}
