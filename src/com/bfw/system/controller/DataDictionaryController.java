package com.bfw.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.DataDictionary;
import com.bfw.po.StaffInfo;
import com.bfw.system.service.DataDictionaryService;
import com.bfw.system.service.StaffInfoService;

 
@Controller
@RequestMapping("/datadictionary/")
public class DataDictionaryController {

	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;
	
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	/**
	 * 查询数据字典信息
	 * 
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(DataDictionary data, Model model, HttpServletRequest request) {

		// 查询
		List<DataDictionary> list = dataDictionaryService.getDataList(data);
		// 返回页面
		model.addAttribute("list", list);
		
		// 查询页面
		return "system/datadictionary/datadictionary_list";
	}

	@RequestMapping("list1.do")
	public String list1(DataDictionary data, Model model, HttpServletRequest request) {

		// 查询
		List<DataDictionary> list = dataDictionaryService.getDataList(data);
		
		// 获取Session
		HttpSession session = request.getSession();
		session.setAttribute("position", list);

		// 查询页面
		return "system/staffinfo/staffinfo_add";
	}
	
	
	/**
	 * 添加信息
	 * 
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(DataDictionary data, Model model, HttpServletRequest request) {

		boolean mark = dataDictionaryService.addData(data);
		if (mark) {
			model.addAttribute("info", "部门添加成功");
		} else {
			model.addAttribute("info", "部门添加失败");
		}

		return list(data, model,request);
	}

	/**
	 * 加载修改页面
	 * 
	 * @param dataId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer dataId, Model model) {

		DataDictionary data = dataDictionaryService.getDataDictionary(dataId);
		model.addAttribute("data", data);

		return "system/datadictionary/datadictionary_update";
	}

	/**
	 * 修改信息
	 * 
	 * @param data
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(DataDictionary data, Model model, HttpServletRequest request) {

		boolean mark = dataDictionaryService.updateData(data);
		if (mark) {
			model.addAttribute("info", "部门修改成功");
		} else {
			model.addAttribute("info", "部门修改失败");
		}

		return list(data, model,request);
	}

	@RequestMapping("delete.do")
	public String delete(Integer dataId, StaffInfo staff,Model model, HttpServletRequest request) {
		
		staff.setStaffState(Integer.toString(dataId));
		
		System.out.println(staff.getStaffState());
		
		List<StaffInfo> list = staffInfoService.getList(staff);
		
		System.out.println(list);
		if(list.size()!=0)
		{model.addAttribute("info", "该部门有员工存在，删除部门信息失败");}
		// 根据编号删除数据字典信息
		else{
			boolean mark = dataDictionaryService.deleteData(dataId);
	
			if(mark){
				model.addAttribute("info", "删除部门信息成功");
			}else{
				model.addAttribute("info", "删除部门信息失败");
			}
		}
		return list(null, model,request);
	}

}
