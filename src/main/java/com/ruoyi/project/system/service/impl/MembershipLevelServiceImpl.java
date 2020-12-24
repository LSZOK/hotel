package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.MembershipLevelMapper;
import com.ruoyi.project.system.domain.MembershipLevel;
import com.ruoyi.project.system.service.IMembershipLevelService;

/**
 * 会员等级Service业务层处理
 * 
 * @author lusenzhu
 * @date 2020-10-15
 */
@Service
public class MembershipLevelServiceImpl implements IMembershipLevelService 
{
    @Autowired
    private MembershipLevelMapper membershipLevelMapper;

    /**
     * 查询会员等级
     * 
     * @param id 会员等级ID
     * @return 会员等级
     */
    @Override
    public MembershipLevel selectMembershipLevelById(Long id)
    {
        return membershipLevelMapper.selectMembershipLevelById(id);
    }

    /**
     * 查询会员等级列表
     * 
     * @param membershipLevel 会员等级
     * @return 会员等级
     */
    @Override
    public List<MembershipLevel> selectMembershipLevelList(MembershipLevel membershipLevel)
    {
        return membershipLevelMapper.selectMembershipLevelList(membershipLevel);
    }

    /**
     * 新增会员等级
     * 
     * @param membershipLevel 会员等级
     * @return 结果
     */
    @Override
    public int insertMembershipLevel(MembershipLevel membershipLevel)
    {
        return membershipLevelMapper.insertMembershipLevel(membershipLevel);
    }

    /**
     * 修改会员等级
     * 
     * @param membershipLevel 会员等级
     * @return 结果
     */
    @Override
    public int updateMembershipLevel(MembershipLevel membershipLevel)
    {
        return membershipLevelMapper.updateMembershipLevel(membershipLevel);
    }

    /**
     * 批量删除会员等级
     * 
     * @param ids 需要删除的会员等级ID
     * @return 结果
     */
    @Override
    public int deleteMembershipLevelByIds(Long[] ids)
    {
        return membershipLevelMapper.deleteMembershipLevelByIds(ids);
    }

    /**
     * 删除会员等级信息
     * 
     * @param id 会员等级ID
     * @return 结果
     */
    @Override
    public int deleteMembershipLevelById(Long id)
    {
        return membershipLevelMapper.deleteMembershipLevelById(id);
    }
}
