package com.bfw.OrganizationWork.service;

import java.util.List;

import com.bfw.po.SyllabusInfo;

 
public interface SyllabusInfoService {

	/**
	 * 添加课程表信息
	 * @param info 课程表
	 * @return
	 */
	public boolean addSyllabus(SyllabusInfo info);
	
	/**
	 * 修改课程表信息
	 * @param info 课程表
	 * @return
	 */
	public boolean updateSyllabus(SyllabusInfo info);
	
	
	/**
	 * 删除课程表信息
	 * @param info 课程表
	 * @return
	 */
	public boolean deleteSyllabus(SyllabusInfo info);
	
	
	/**
	 * 根据编号查询课程表信息
	 * @param syllabusId
	 * @return
	 */
	public SyllabusInfo getSyllabusInfo(Integer syllabusId);
	
	/**
	 * 根据条件查询课程表信息
	 * @param info
	 * @return
	 */
	public List<SyllabusInfo> getList(SyllabusInfo info);
	
	public List<SyllabusInfo> getList1(SyllabusInfo info);
	
}
