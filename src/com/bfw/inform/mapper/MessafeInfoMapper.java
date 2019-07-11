package com.bfw.inform.mapper;

import java.util.List;

import com.bfw.po.MessafeInfo;

public interface MessafeInfoMapper {
    int deleteByPrimaryKey(Integer messafeId);

    int insert(MessafeInfo record);

    int insertSelective(MessafeInfo record);

    MessafeInfo selectByPrimaryKey(Integer messafeId);

    int updateByPrimaryKeySelective(MessafeInfo record);

    int updateByPrimaryKey(MessafeInfo record);
    
    /**
     * 查询短信信息
     * @param record
     * @return
     */
    public List<MessafeInfo> getMessafeInfoList(MessafeInfo record);
}