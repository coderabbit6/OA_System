package com.bfw.Communicate.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.bfw.Communicate.mapper.CommunicateInfoMapper;
import com.bfw.po.CommunicateInfo;
import com.bfw.Communicate.service.CommunicateInfoService;

@Service
public class CommunicateInfoServiceImpl implements CommunicateInfoService {
	
	@Resource(name="communicateInfoMapper")
	private CommunicateInfoMapper communicateInfoMapper;
	
	@Override
	public boolean add(CommunicateInfo info) {
		try {
			int i = communicateInfoMapper.insertSelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CommunicateInfo info) {
		try {
			int i = communicateInfoMapper.updateByPrimaryKeySelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Integer communicateId) {
		try {
			int i = communicateInfoMapper.deleteByPrimaryKey(communicateId);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CommunicateInfo getCommunicateInfo(Integer communicateId) {
		// TODO Auto-generated method stub
		return communicateInfoMapper.selectByPrimaryKey(communicateId);
	}

	@Override
	public List<CommunicateInfo> getList(Integer info) {
		// TODO Auto-generated method stub
		return communicateInfoMapper.getCommunicateInfoList(info);
	}

	@Override
	public List<CommunicateInfo> getList(CommunicateInfo info) {
		// TODO Auto-generated method stub
		
		
		return communicateInfoMapper.getCommunicateInfoList1(info);
	}

}
