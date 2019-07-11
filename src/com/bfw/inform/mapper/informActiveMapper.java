package com.bfw.inform.mapper;

import java.util.List;

import com.bfw.po.informActive;


public interface informActiveMapper {
    int deleteByPrimaryKey(Integer activeId);

    int insert(informActive record);

    int insertSelective(informActive record);

    informActive selectByPrimaryKey(Integer activeId);

    int updateByPrimaryKeySelective(informActive record);

    int updateByPrimaryKey(informActive record);
    
    public List<informActive> getMarketList(informActive record); 
}