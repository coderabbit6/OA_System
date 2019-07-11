package com.bfw.system.service;

import java.util.List;

import com.bfw.po.AnthortyInfo;
import com.bfw.po.RoleInfo;

 
public interface RoleInfoService {

	/**
	 * 添加角色信息
	 * @param role 角色信息
	 * @return
	 */
	public boolean addRole(RoleInfo role);
	
	/**
	 * 修改角色信息
	 * @param role 角色信息
	 * @return
	 */
	public boolean updateRole(RoleInfo role);
	
	/**
	 * 根据条件查询角色信息
	 * @param role
	 * @return
	 */
	public List<RoleInfo> getRoleList(RoleInfo role);
	
	/**
	 * 根据编号查询角色信息
	 * @param roleId 角色编号
	 * @return
	 */
	public RoleInfo getRoleInfo(Integer roleId);

	

}
