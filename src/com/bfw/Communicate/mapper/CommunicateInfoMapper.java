package com.bfw.Communicate.mapper;

import java.util.List;

import com.bfw.po.CommunicateInfo;

public interface CommunicateInfoMapper {
    int deleteByPrimaryKey(Integer communicateId);

    int insert(CommunicateInfo record);

    int insertSelective(CommunicateInfo record);

    CommunicateInfo selectByPrimaryKey(Integer communicateId);

    int updateByPrimaryKeySelective(CommunicateInfo record);

    int updateByPrimaryKey(CommunicateInfo record);
    
    public List<CommunicateInfo> getCommunicateInfoList(Integer info);
    
    public List<CommunicateInfo> getCommunicateInfoList1(CommunicateInfo info);
}