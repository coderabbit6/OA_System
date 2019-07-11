package com.bfw.system.controller;

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

import com.bfw.po.DataDictionary;
import com.bfw.po.StaffInfo;
import com.bfw.system.service.StaffInfoService;
import com.bfw.po.DataDictionary;
import com.bfw.system.dto.ReportInfo;
import com.bfw.system.service.DataDictionaryService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

 
@Controller
@RequestMapping("/system/")
public class StaffInfoController {

	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;

	
	@Resource(name = "dataDictionaryServiceImpl")
	private DataDictionaryService dataDictionaryService;
	
	/**
	 * 添加员工信息
	 * 
	 * @return
	 */
	@RequestMapping("add.do")
	public String addStaffInfo(StaffInfo staff, Model model, HttpServletRequest request,HttpSession session) {

		boolean mark = staffInfoService.addStaff(staff);
		if (mark) {

			model.addAttribute("info", "添加成功");
		} else {
			model.addAttribute("info", "添加失败");
		}

		return this.list(null, model, request, session);
	}

	@RequestMapping("list.do")
	public String list(StaffInfo staff, Model model, HttpServletRequest request,HttpSession session) {

		List<StaffInfo> list = staffInfoService.getList(staff);
		model.addAttribute("list", list);

		//获取报表信息
		ReportInfo reportInfo =	staffInfoService.getReportInfo();
		
		System.out.println(reportInfo.getSateList());
		session.setAttribute("reportInfo", reportInfo);
		
		return "system/staffinfo/staffinfo_list";
	}
	
	//显示其他人员信息清单
	@RequestMapping("list1.do")
	public String list1(StaffInfo staff, Model model) {

		List<StaffInfo> list = staffInfoService.getList(staff);
		model.addAttribute("list", list);

		return "private_mes/other_list";
	}
	

	/**
	 * 根据编号查询员工信息
	 * 
	 * @param staffId
	 *            员工编号
	 * @param model
	 * @return
	 */
	@RequestMapping("show.do")
	public String showStaffInfo(Integer staffId, Model model,DataDictionary data ) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		return "system/staffinfo/staffinfo_show";
	}
	//显示个人信息清单
	@RequestMapping("person.do")
	public String person(Model model ,HttpServletRequest request,HttpSession session) {
		
		Integer id = (Integer) session.getAttribute("id");
		StaffInfo staffInfo = staffInfoService.getStaffInfo(id);
		model.addAttribute("staffInfo", staffInfo);

		return "private_mes/person_list";
	}
	
	/**
	 * 根据编号查询员工信息
	 * 
	 * @param staffId
	 *            员工编号
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String loadUpdate(Integer staffId, Model model,DataDictionary data,HttpServletRequest request) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		// 查询
		List<DataDictionary> list = dataDictionaryService.getDataList(data);
		
		// 获取Session
		HttpSession session = request.getSession();
		session.setAttribute("position", list);
		
		return "system/staffinfo/staffinfo_update";
	}
	//进入用户个人信息更新界面
	@RequestMapping("load1.do")
	public String loadUpdate1(Integer staffId, Model model,DataDictionary data,HttpServletRequest request) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		// 查询
		List<DataDictionary> list = dataDictionaryService.getDataList(data);
		
		// 获取Session
		HttpSession session = request.getSession();
		session.setAttribute("position", list);
		
		return "private_mes/person_update";
	}
	//员工信息查看
	@RequestMapping("load2.do")
	public String other_mes(Integer staffId, Model model) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);

		return "private_mes/other_mes";
	}
	/**
	 * 修改员工信息
	 * 
	 * @return
	 */
	@RequestMapping("update.do")
	public String updateStaffInfo(StaffInfo staff, Model model, HttpServletRequest request,HttpSession session) {

		boolean mark = staffInfoService.updateStaff(staff);
		if (mark) {

			model.addAttribute("info", "修改成功");
		} else {
			model.addAttribute("info", "修改失败");
		}

		return this.list(null, model, request, session);
	}
	//提交更新
	@RequestMapping("update1.do")
	public String updateStaffInfo1(StaffInfo staff, Model model,HttpServletRequest request,HttpSession session) {

		boolean mark = staffInfoService.updateStaff(staff);
		if (mark) {

			model.addAttribute("info", "修改成功");
		} else {
			model.addAttribute("info", "修改失败");
		}

		return this.person(model, request, session);
	}
	
	/**
	 * 删除员工信息
	 * 
	 * @return
	 */
	@RequestMapping("delete.do")
	public String deleteStaffInfo(StaffInfo staff, Model model, HttpServletRequest request,HttpSession session) {
/*		//设置员工信息为 0无效  1普通员工  2 教师 
		staff.setStaffState("0");
		boolean mark = staffInfoService.updateStaff(staff);*/
		boolean mark = staffInfoService.deleteStaff(staff);
		if (mark) {

			model.addAttribute("info", "删除成功");
		} else {
			model.addAttribute("info", "删除失败");
		}

		return this.list(null, model, request, session);
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
