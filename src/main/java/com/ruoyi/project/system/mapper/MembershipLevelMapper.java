package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.MembershipLevel;

/**
 * 会员等级Mapper接口
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
public interface MembershipLevelMapper 
{
    /**
     * 查询会员等级
     * 
     * @param id 会员等级ID
     * @return 会员等级
     */
    public MembershipLevel selectMembershipLevelById(Long id);

    /**
     * 查询会员等级列表
     * 
     * @param membershipLevel 会员等级
     * @return 会员等级集合
     */
    public List<MembershipLevel> selectMembershipLevelList(MembershipLevel membershipLevel);

    /**
     * 新增会员等级
     * 
     * @param membershipLevel 会员等级
     * @return 结果
     */
    public int insertMembershipLevel(MembershipLevel membershipLevel);

    /**
     * 修改会员等级
     * 
     * @param membershipLevel 会员等级
     * @return 结果
     */
    public int updateMembershipLevel(MembershipLevel membershipLevel);

    /**
     * 删除会员等级
     * 
     * @param id 会员等级ID
     * @return 结果
     */
    public int deleteMembershipLevelById(Long id);

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMembershipLevelByIds(Long[] ids);
}
