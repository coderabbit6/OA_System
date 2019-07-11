package com.bfw.inform.service;

import java.util.List;

import com.bfw.po.MessafeInfo;


public interface MessafeInfoService {

	/**
	 * 查询短信信息
	 * @param info
	 * @return
	 */
	public List<MessafeInfo> getMessafeList(MessafeInfo info);
	
	/**
	 * 发送短信信息
	 * @param info
	 * @return
	 */
	public boolean addMesssafe(MessafeInfo info);
	
	/**
	 * 根据编号查询短信信息
	 * @param messafeId 短信编号
	 * @return
	 */
	public MessafeInfo getMessafeInfo(Integer messafeId);
	
	/**
	 * 根据编号删除信息
	 * @param messafeId 编号
	 * @return
	 */
	public boolean delete(Integer messafeId);
	
}
