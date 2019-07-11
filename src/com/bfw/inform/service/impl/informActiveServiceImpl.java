package com.bfw.inform.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.inform.mapper.informActiveMapper;
import com.bfw.inform.service.informActiveService;
import com.bfw.po.informActive;


@Service
public class informActiveServiceImpl implements informActiveService{

	/**
	 * 
	 */
	@Resource(name="informActiveMapper")
	private informActiveMapper informActiveMapper;
	
/*	@Override
	public MarketActive getinformList(Integer informId){
		
		return marketActiveMapper.selectByPrimaryKey(informId);
		
	}
*/
	
	@Override
	public boolean addMarket(informActive market) {
		
		try {
			
			int count = informActiveMapper.insertSelective(market);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateMarket(informActive market) {
		
		try {
			
			int count = informActiveMapper.updateByPrimaryKeySelective(market);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean deleteMarket(Integer activeId) {
		
		try {
			
			int count = informActiveMapper.deleteByPrimaryKey(activeId);
			if(count>0){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<informActive> getMarketActiveList(informActive market) {
		
		if(market!=null&&market.getActiveName()!=null&&!"".equals(market.getActiveName())){
			market.setActiveName("%"+market.getActiveName()+"%");
		}
		
		return informActiveMapper.getMarketList(market);
	}

	@Override
	public informActive getMarketActive(Integer activeId) {
		// TODO Auto-generated method stub
		return informActiveMapper.selectByPrimaryKey(activeId);
	}

}
