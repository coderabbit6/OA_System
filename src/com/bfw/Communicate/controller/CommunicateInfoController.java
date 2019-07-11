package com.bfw.Communicate.controller;

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

import com.bfw.po.CommunicateInfo;
import com.bfw.po.StaffInfo;
import com.bfw.Communicate.service.CommunicateInfoService;


@Controller
@RequestMapping("/communicateinfo/")
public class CommunicateInfoController {

	/**
	 * 
	 */
	@Resource(name="communicateInfoServiceImpl")
	private CommunicateInfoService communicateInfoService;
	
	
	/**
	 * 查询信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(CommunicateInfo info,Model model,HttpServletRequest request,HttpSession session){
		
		/*List<CommunicateInfo> list = communicateInfoService.getList(info);*/
		
		Integer id = (Integer) session.getAttribute("id");
		List<CommunicateInfo> list = communicateInfoService.getList(id);
		model.addAttribute("list", list);
		
		return "Communicate/communicateinfo/communicateinfo_list";
	}
	
	@RequestMapping("list1.do")
	public String list1(CommunicateInfo info,Model model,HttpServletRequest request,HttpSession session){
		
		Integer id = (Integer) session.getAttribute("id");
		info.setStaffId(id);
		List<CommunicateInfo> list = communicateInfoService.getList(info);
		model.addAttribute("list", list);
		
		return "Communicate/communicateinfo/communicateinfo_list";
	}
	

	/*
	 * 加载添加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String  loadadd(Model model){
		return "Communicate/communicateinfo/communicateinfo_add";
	}

	/*
	 * 加载修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String  loadupdate(Integer addressId,Model model){
		
		CommunicateInfo commum = communicateInfoService.getCommunicateInfo(addressId);
		model.addAttribute("commum", commum);
		
		return "Communicate/communicateinfo/communicateinfo_update";
	}

	
	@RequestMapping("add.do")
	public String add(CommunicateInfo info,Model model,HttpServletRequest request){
		
		HttpSession session = request.getSession();
	/*	StaffInfo staff = (StaffInfo) session.getAttribute("staff");*/
		Integer staffId = (Integer) session.getAttribute("id");

		info.setStaffId(staffId);
		
		boolean mark = communicateInfoService.add(info);
		if (mark) {
			model.addAttribute("info", "添加通讯录成功！");
		} else {
			model.addAttribute("info", "添加通讯录失败");
		}
		
		return list(info,model,request,session);
	}
	
	@RequestMapping("update.do")
	public String update(CommunicateInfo info,Model model,HttpServletRequest request){
		HttpSession session = request.getSession();
		/*StaffInfo staff = (StaffInfo) session.getAttribute("staff");*/
		Integer staffId = (Integer) session.getAttribute("id");
		if(info==null){
			info = new CommunicateInfo();
		}
		if(staffId!=null){
			info.setStaffId(staffId);
		}
		boolean mark = communicateInfoService.update(info);
		if (mark) {
			model.addAttribute("info", "修改通讯录成功！");
		} else {
			model.addAttribute("info", "修改通讯录失败");
		}
		
		return list(info,model,request,session);
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer addressId,Model model,HttpServletRequest request,HttpSession session){
		
		boolean mark = communicateInfoService.delete(addressId);
		if (mark) {
			model.addAttribute("info", "删除通讯录成功！");
		} else {
			model.addAttribute("info", "删除通讯录失败");
		}
		
		return list(null,model,request,session);
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
