package com.bfw.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.RoleInfo;
import com.bfw.po.StaffInfo;
import com.bfw.system.service.RoleInfoService;
import com.bfw.system.service.StaffInfoService;

 
@Controller
@RequestMapping("/roleinfo/")
public class RoleInfoController {

	@Resource(name="roleInfoServiceImpl")
	private RoleInfoService roleInfoService;
	
	@Resource(name = "staffInfoServiceImpl")
	private StaffInfoService staffInfoService;
	
	@RequestMapping("staffinforolelist.do")
	public String staffInfoRoleList(StaffInfo staff, Model model) {

		List<StaffInfo> list = staffInfoService.getStaffList(staff);
		model.addAttribute("list", list);

		return "system/roleinfo/staffinfo_role_list";
	}
	
	/**
	 * 根据编号查询员工信息
	 * 
	 * @param staffId
	 *            员工编号
	 * @param model
	 * @return
	 */
	@RequestMapping("laodchange.do")
	public String loadStaffInfo(Integer staffId, Model model) {

		StaffInfo staffInfo = staffInfoService.getStaffInfo(staffId);
		model.addAttribute("staffInfo", staffInfo);
		
		List<RoleInfo> list = roleInfoService.getRoleList(null);
		model.addAttribute("list", list);

		return "system/roleinfo/roleinfo_change";
	}
	
	/**
	 * 角色变更
	 * 
	 * @return
	 */
	@RequestMapping("changeRole.do")
	public String updateStaffInfo(StaffInfo staff, Model model) {

		boolean mark = staffInfoService.updateStaff(staff);
		if (mark) {

			model.addAttribute("info", "变更成功成功");
		} else {
			model.addAttribute("info", "变更失败失败");
		}

		return this.staffInfoRoleList(null, model);
	}
	
	/**
	 * 查询角色信息
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(RoleInfo roleinfo,Model model){
		
		List<RoleInfo> list = roleInfoService.getRoleList(roleinfo);
		model.addAttribute("list", list);
		
		return "system/roleinfo/roleinfo_list";
	}
	
	/**
	 * 添加角色信息
	 * @param roleinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(RoleInfo roleinfo,Model model){
		
		Boolean mark = roleInfoService.addRole(roleinfo);
		
		if(mark){
			model.addAttribute("info", "添加成功");
		}else{
			model.addAttribute("info", "添加失败");
		}
		
		
		return this.list(null, model);
	}
	
	@RequestMapping("load.do")
	public String load(Integer roleId,Model model){
		
		RoleInfo roleinfo = roleInfoService.getRoleInfo(roleId);
		model.addAttribute("roleinfo", roleinfo);
		
		return "system/roleinfo/roleinfo_update";
	}
	
	/**
	 * 添加角色信息
	 * @param roleinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(RoleInfo roleinfo,Model model){
		
		Boolean mark = roleInfoService.updateRole(roleinfo);
		
		if(mark){
			model.addAttribute("info", "修改成功");
		}else{
			model.addAttribute("info", "修改失败");
		}
		
		return this.list(null, model);
	}
	
	/**
	 * 添加角色信息
	 * @param roleinfo
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(RoleInfo roleinfo,Model model){
		roleinfo.setRoleState("0");
		Boolean mark = roleInfoService.updateRole(roleinfo);
		
		if(mark){
			model.addAttribute("info", "删除成功");
		}else{
			model.addAttribute("info", "删除失败");
		}
		
		return this.list(null, model);
	}
}
