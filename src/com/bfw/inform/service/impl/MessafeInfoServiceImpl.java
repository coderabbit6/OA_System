package com.bfw.inform.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.inform.mapper.MessafeInfoMapper;
import com.bfw.inform.service.MessafeInfoService;
import com.bfw.po.MessafeInfo;

/**
 * 短信管理的业务逻辑接口的实现类
 * @author 老牛
 * 2014年11月20日
 *
 */
@Service
public class MessafeInfoServiceImpl implements MessafeInfoService{

	@Resource(name="messafeInfoMapper")
	private MessafeInfoMapper messafeInfoMapper;
	
	@Override
	public List<MessafeInfo> getMessafeList(MessafeInfo info) {
		
		return messafeInfoMapper.getMessafeInfoList(info);
	}

	@Override
	public boolean addMesssafe(MessafeInfo info) {
		try {
			//调用短信接口
			//......	
			
			int count = messafeInfoMapper.insertSelective(info);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MessafeInfo getMessafeInfo(Integer messafeId) {
		// TODO Auto-generated method stub
		return messafeInfoMapper.selectByPrimaryKey(messafeId);
	}

	@Override
	public boolean delete(Integer messafeId) {
		try {

			int count = messafeInfoMapper.deleteByPrimaryKey(messafeId);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
