package com.bfw.system.service;

import java.util.List;

import com.bfw.po.RoleAnthorityInfo;

 
public interface AnthotychangeService {

	/**
	 * 添加角色权限信息
	 * @param roleId
	 * @param anthortyId
	 * @throws Exception
	 */
	public void add(Integer roleId,Integer[] anthortyId)throws Exception;
	
	/**
	 * 查询角色权限信息
	 * @param roleAnthorityInfo
	 * @return
	 */
	public List<RoleAnthorityInfo>  getRoleAnthorityList(RoleAnthorityInfo roleAnthorityInfo);
}
