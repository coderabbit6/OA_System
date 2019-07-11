package com.bfw.OrganizationWork.mapper;

import java.util.List;

import com.bfw.po.SyllabusInfo;

public interface SyllabusInfoMapper {
    int deleteByPrimaryKey(Integer syllabusId);

    int insert(SyllabusInfo record);

    int insertSelective(SyllabusInfo record);

    SyllabusInfo selectByPrimaryKey(Integer syllabusId);

    int updateByPrimaryKeySelective(SyllabusInfo record);

    int updateByPrimaryKey(SyllabusInfo record);
    
    public List<SyllabusInfo> getSyllabusList(SyllabusInfo record);
    
    public List<SyllabusInfo> getSyllabusList1(SyllabusInfo record);
}