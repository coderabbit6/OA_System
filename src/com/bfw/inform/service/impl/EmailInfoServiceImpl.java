package com.bfw.inform.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.inform.mapper.EmailInfoMapper;
import com.bfw.inform.service.EmailInfoService;
import com.bfw.po.EmailInfo;

@Service
public class EmailInfoServiceImpl implements EmailInfoService{

	/**
	 * 
	 */
	@Resource(name="emailInfoMapper")
	private EmailInfoMapper emailInfoMapper;
	
	@Override
	public boolean addEmail(EmailInfo info) {
		
		try {
			int count =emailInfoMapper.insertSelective(info);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteEmail(Integer emailId) {
		try {
			int count =emailInfoMapper.deleteByPrimaryKey(emailId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public EmailInfo getEmailInfo(Integer emailId) {
		// TODO Auto-generated method stub
		return emailInfoMapper.selectByPrimaryKey(emailId);
	}

	@Override
	public List<EmailInfo> getEmailList(EmailInfo info) {
		if(info!=null&& info.getEmailTitle()!=null){
			
			info.setEmailTitle("%"+info.getEmailTitle()+"%");
		}
		
		// TODO Auto-generated method stub
		return emailInfoMapper.getEmailList(info);
	}

}
