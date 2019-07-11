package com.bfw.inform.mapper;

import java.util.List;

import com.bfw.po.TemplateInfo;

public interface TemplateInfoMapper {
    int deleteByPrimaryKey(Integer templateId);

    int insert(TemplateInfo record);

    int insertSelective(TemplateInfo record);

    TemplateInfo selectByPrimaryKey(Integer templateId);

    int updateByPrimaryKeySelective(TemplateInfo record);

    int updateByPrimaryKey(TemplateInfo record);
    
    /**
     * 根据条件查询模板相关信息
     * @param record
     * @return
     */
    public List<TemplateInfo> getTemplateList(TemplateInfo record);
}