package com.bfw.OrganizationWork.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.OrganizationWork.service.SyllabusInfoService;
import com.bfw.po.StaffInfo;
import com.bfw.po.SyllabusInfo;
import com.bfw.system.service.StaffInfoService;

@Controller
@RequestMapping("/syllabusinfo/")
public class SyllabusInfoController {

	@Resource(name = "syllabusInfoServiceImpl")
	private SyllabusInfoService syllabusInfoService;

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	/**
	 * 根据条件查询日程信息（管理员）
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(SyllabusInfo info, Model model) {

		List<SyllabusInfo> list = syllabusInfoService.getList(info);
		model.addAttribute("list", list);
		return "OrganizationWork/syllabusinfo/syllabusinfo_list";
	}

	/**
	 * 根据条件查询日程信息（普通员工）
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list1.do")
	public String list1(SyllabusInfo info, Model model,HttpServletRequest request,HttpSession session ) {
		
		Integer id = (Integer) session.getAttribute("id");
		info.setIsUesd(Integer.toString(id));
		List<SyllabusInfo> list = syllabusInfoService.getList1(info);
		model.addAttribute("list", list);
		return "OrganizationWork/syllabusinfo/arrange_list";
	}
	
	
	
	/**
	 * 加载修改页面(管理员)
	 * 
	 * @param syllabusId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer syllabusId, Model model) {

		SyllabusInfo syllabus = syllabusInfoService.getSyllabusInfo(syllabusId);
		model.addAttribute("syllabus", syllabus);

		return "OrganizationWork/syllabusinfo/syllabusinfo_update";
	}

	/**
	 * 加载修改页面(普通员工)
	 * 
	 * @param syllabusId
	 * @param model
	 * @return
	 */
	@RequestMapping("load1.do")
	public String load1(Integer syllabusId, Model model) {

		SyllabusInfo syllabus = syllabusInfoService.getSyllabusInfo(syllabusId);
		model.addAttribute("syllabus", syllabus);

		return "OrganizationWork/syllabusinfo/look_arrange";
	}
	
	
	/**
	 * 添加日程表信息（管理员）
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(SyllabusInfo info, Model model,HttpServletRequest request,HttpSession session ) {

		if (info == null) {
			info = new SyllabusInfo();
		}
		

		Integer id = (Integer) session.getAttribute("id");
		StaffInfo staffInfo = staffInfoService.getStaffInfo(id);
		info.setIsUesd(Integer.toString(staffInfo.getStaffId()));

		boolean mark = syllabusInfoService.addSyllabus(info);
		if (mark) {
			model.addAttribute("info", "添加日程成功");
		} else {
			model.addAttribute("info", "添加日程失败");
		}

		return list(info, model);
	}

	
	/**
	 * 添加日程表信息（普通用户）
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add1.do")
	public String add1(SyllabusInfo info, Model model,HttpServletRequest request,HttpSession session ) {

		if (info == null) {
			info = new SyllabusInfo();
		}
		

		Integer id = (Integer) session.getAttribute("id");
		StaffInfo staffInfo = staffInfoService.getStaffInfo(id);
		
		info.setIsUesd(Integer.toString(staffInfo.getStaffId()));
		info.setSyllabusName(staffInfo.getStaffName());
		boolean mark = syllabusInfoService.addSyllabus(info);
		if (mark) {
			model.addAttribute("info", "添加日程成功");
		} else {
			model.addAttribute("info", "添加日程失败");
		}

		return list1(info, model,request,session);
	}
	

	/**
	 * 修改课程表信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(SyllabusInfo info, Model model) {
		boolean mark = syllabusInfoService.updateSyllabus(info);
		if (mark) {
			model.addAttribute("info", "修改日程成功");
		} else {
			model.addAttribute("info", "修改日程失败");
		}

		return list(info, model);
	}

	/**
	 * 删除课程表信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(SyllabusInfo info, Model model) {
		// 1为有效 0 为无效
		info.setIsUesd("0");
		boolean mark = syllabusInfoService.deleteSyllabus(info);
		if (mark) {
			model.addAttribute("info", "删除日程成功");
		} else {
			model.addAttribute("info", "删除日程失败");
		}

		return list(info, model);
	}
	/**
	 * 时间属性的编辑器
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
