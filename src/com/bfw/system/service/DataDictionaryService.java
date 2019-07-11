package com.bfw.system.service;

import java.util.List;

import com.bfw.po.DataDictionary;

 
public interface DataDictionaryService {

	/**
	 * 根据条件查询部门信息
	 * @param data 查询条件
	 * @return
	 */
	public List<DataDictionary> getDataList(DataDictionary data);
	
	/**
	 * 添加部门信息
	 * @param data
	 * @return
	 */
	public boolean addData(DataDictionary data);
	
	/**
	 * 根据编号查询部门信息
	 * @param dataId 编号
	 * @return
	 */
	public DataDictionary getDataDictionary(Integer dataId);
	
	/**
	 * 修改部门信息
	 * @param data
	 * @return
	 */
	public boolean updateData(DataDictionary data);
	
	/**
	 * 根据编号删除部门信息
	 * @param dataId
	 * @return
	 */
	public boolean deleteData(Integer dataId);
}
