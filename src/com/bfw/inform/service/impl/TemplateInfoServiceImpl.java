package com.bfw.inform.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.inform.mapper.TemplateInfoMapper;
import com.bfw.inform.service.TemplateInfoService;
import com.bfw.po.TemplateInfo;

@Service
public class TemplateInfoServiceImpl implements TemplateInfoService {

	/**
	 * 模板信息的数据操作接口
	 */
	@Resource(name="templateInfoMapper")
	private TemplateInfoMapper templateInfoMapper;
	
	@Override
	public boolean addTemplate(TemplateInfo info) {
		
		try {
			
			int count = templateInfoMapper.insertSelective(info);
			
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateTemplate(TemplateInfo info) {
		try {
			
			int count = templateInfoMapper.updateByPrimaryKeySelective(info);
			
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTemplate(Integer templateId) {
		try {
			
			int count = templateInfoMapper.deleteByPrimaryKey(templateId);
			
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public TemplateInfo getTemplate(Integer templateId) {
		
		if(templateId!=null){
			return templateInfoMapper.selectByPrimaryKey(templateId);
		}
		
		return null;
	}

	@Override
	public List<TemplateInfo> getTemplateInfoList(TemplateInfo info) {
		
		if(info!=null && info.getTemplateTitle()!=null && !info.getTemplateTitle().equals("") ){
			info.setTemplateTitle("%"+info.getTemplateTitle()+"%");
		}
		
		
		return templateInfoMapper.getTemplateList(info);
	}

}
