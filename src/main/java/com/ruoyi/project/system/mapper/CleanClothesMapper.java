package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.CleanClothes;

/**
 * 清洁衣物Mapper接口
 * 
 * @author lusenzhu
 * @date 2020-10-22
 */
public interface CleanClothesMapper 
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
     * 删除清洁衣物
     * 
     * @param cleanClothesId 清洁衣物ID
     * @return 结果
     */
    public int deleteCleanClothesById(String cleanClothesId);

    /**
     * 批量删除清洁衣物
     * 
     * @param cleanClothesIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteCleanClothesByIds(String[] cleanClothesIds);
}
