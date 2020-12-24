package com.ruoyi.project.system.service;

import java.util.List;
import com.ruoyi.project.system.domain.CleanClothes;

/**
 * 清洁衣物Service接口
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
public interface ICleanClothesService 
{
    /**
     * 查询清洁衣物
     * 
     * @param cleanClothesId 清洁衣物ID
     * @return 清洁衣物
     */
    public CleanClothes selectCleanClothesById(String cleanClothesId);

    /**
     * 查询清洁衣物列表
     * 
     * @param cleanClothes 清洁衣物
     * @return 清洁衣物集合
     */
    public List<CleanClothes> selectCleanClothesList(CleanClothes cleanClothes);

    /**
     * 新增清洁衣物
     * 
     * @param cleanClothes 清洁衣物
     * @return 结果
     */
    public int insertCleanClothes(CleanClothes cleanClothes);

    /**
     * 修改清洁衣物
     * 
     * @param cleanClothes 清洁衣物
     * @return 结果
     */
    public int updateCleanClothes(CleanClothes cleanClothes);

    /**
     * 批量删除清洁衣物
     * 
     * @param cleanClothesIds 需要删除的清洁衣物ID
     * @return 结果
     */
    public int deleteCleanClothesByIds(String[] cleanClothesIds);

    /**
     * 删除清洁衣物信息
     * 
     * @param cleanClothesId 清洁衣物ID
     * @return 结果
     */
    public int deleteCleanClothesById(String cleanClothesId);
}
