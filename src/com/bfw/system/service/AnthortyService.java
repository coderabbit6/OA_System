package com.bfw.system.service;

import java.util.List;

import com.bfw.po.AnthortyInfo;

 
public interface AnthortyService {

	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public List<AnthortyInfo> getList();
	
	/**
	 * 根据编号查询权限信息
	 * @param anthortyId 权限编号
	 * @return
	 */
	public AnthortyInfo getAnthortyInfo(Integer anthortyId);
	
	/**
	 * 添加权限信息
	 * @param anth
	 * @return
	 */
	public boolean add(AnthortyInfo anth);
	
	/**
	 * 修改权限信息
	 * @param anth 权限信息
	 * @return
	 */
	public boolean update(AnthortyInfo anth);
	
	/**
	 * 根据编号删除权限信息
	 * @param anthortyId 权限编号
	 * @return
	 */
	public void delete(Integer anthortyId)throws Exception;
	
	/**
	 * 判断是否有下级节点
	 * @param anthortyId
	 * @return
	 */
	public boolean isDelete(Integer anthortyId);
	
	/**
	 * 根据角色编号查询权限信息
	 * @param roleId
	 * @return
	 */
	public List<AnthortyInfo> getAnthList(Integer roleId);
	
}
