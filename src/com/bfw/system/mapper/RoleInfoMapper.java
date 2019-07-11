package com.bfw.system.mapper;

import java.util.List;

import com.bfw.po.RoleInfo;
import com.bfw.po.StaffInfo;

public interface RoleInfoMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
    
    public List<RoleInfo> getRoleInfoList(RoleInfo record);

   
}