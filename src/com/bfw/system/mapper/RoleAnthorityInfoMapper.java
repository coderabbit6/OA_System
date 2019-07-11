package com.bfw.system.mapper;

import java.util.List;

import com.bfw.po.RoleAnthorityInfo;

public interface RoleAnthorityInfoMapper {
    int deleteByPrimaryKey(Integer roleAnthorityId);

    int insert(RoleAnthorityInfo record);

    int insertSelective(RoleAnthorityInfo record);

    RoleAnthorityInfo selectByPrimaryKey(Integer roleAnthorityId);

    int updateByPrimaryKeySelective(RoleAnthorityInfo record);

    int updateByPrimaryKey(RoleAnthorityInfo record);
    
    /**
     * 根据权限编号删除角色权限信息
     * @param anthortyId
     * @return
     */
    int deleteByAnthortyId(Integer anthortyId);
    
    /**
     * 根据角色编号删除信息
     * @param roleId
     * @return
     */
    int deleteByRoleId(Integer roleId);
    
    /**
     * 查询所有角色权限信息
     * @return
     */
    public List<RoleAnthorityInfo> getRoleAnthorityInfoList(RoleAnthorityInfo record);
    
}