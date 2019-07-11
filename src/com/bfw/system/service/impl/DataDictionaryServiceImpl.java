package com.bfw.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.DataDictionary;
import com.bfw.system.mapper.DataDictionaryMapper;
import com.bfw.system.service.DataDictionaryService;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService{


	@Resource(name="dataDictionaryMapper")
	private DataDictionaryMapper dataDictionaryMapper;
	
	@Override
	public List<DataDictionary> getDataList(DataDictionary data) {
		// TODO Auto-generated method stub
		return dataDictionaryMapper.getDataList(data);
	}

	@Override
	public boolean addData(DataDictionary data) {
		
		try {
			int count = dataDictionaryMapper.insertSelective(data);
			if(count>0){
				return true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public DataDictionary getDataDictionary(Integer dataId) {
		
		return dataDictionaryMapper.selectByPrimaryKey(dataId);
	}

	@Override
	public boolean updateData(DataDictionary data) {
		try {
			int count = dataDictionaryMapper.updateByPrimaryKeySelective(data);
			if(count>0){
				return true;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteData(Integer dataId) {
		try {
			
			int count = dataDictionaryMapper.deleteByPrimaryKey(dataId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
