package com.bfw.inform.service;

import java.util.List;

import com.bfw.po.informActive;



public interface informActiveService {

/*	*//**
	 * 查询公告信息
	 * @param info
	 * @return
	 *//*
	public MarketActive getinformList(Integer informId);
	*/
	/**
	 * 添加公告活动
	 * @param market
	 * @return
	 */
	public boolean addMarket(informActive market);
	
	/**
	 * 修改公告活动
	 * @param market
	 * @return
	 */
	public boolean updateMarket(informActive market);
	
	/**
	 * 删除公告活动
	 * @param market
	 * @return
	 */
	public boolean deleteMarket(Integer activeId);
	
	/**
	 * 根据条件查询公告活动信息
	 * @param market
	 * @return
	 */
	public List<informActive> getMarketActiveList(informActive market);
	
	/**
	 * 根据编号查询公告活动信息
	 * @param activeId
	 * @return
	 */
	public informActive getMarketActive(Integer activeId);
}
