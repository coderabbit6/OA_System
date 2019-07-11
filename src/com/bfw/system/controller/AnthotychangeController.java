package com.bfw.system.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.AnthortyInfo;
import com.bfw.po.RoleAnthorityInfo;
import com.bfw.po.RoleInfo;
import com.bfw.system.dto.AnthortyDTO;
import com.bfw.system.service.AnthortyService;
import com.bfw.system.service.AnthotychangeService;
import com.bfw.system.service.RoleInfoService;

 
@Controller
@RequestMapping("/anthotychange/")
public class AnthotychangeController {

	/**
	 * 角色管理的业务逻辑层
	 */
	@Resource(name = "roleInfoServiceImpl")
	private RoleInfoService roleInfoService;

	/**
	 * 权限基本信息的业务逻辑层
	 */
	@Resource(name = "anthortyServiceImpl")
	private AnthortyService anthortyService;
	
	
	/**
	 * 角色权限信息的业务逻辑层
	 */
	@Resource(name = "anthotychangeServiceImpl")
	private AnthotychangeService anthotychangeService;

	/**
	 * 查询角色信息
	 * 
	 * @param roleinfo
	 *            查询条件
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(RoleInfo roleinfo, Model model) {

		List<RoleInfo> list = roleInfoService.getRoleList(roleinfo);
		model.addAttribute("list", list);

		return "system/anthotychange/anthorty_changelist";
	}

	@RequestMapping("load.do")
	public String load(Integer roleId, Model model) {
		// 角色
		RoleInfo roleinfo = roleInfoService.getRoleInfo(roleId);
		model.addAttribute("roleinfo", roleinfo);
		RoleAnthorityInfo rai = new RoleAnthorityInfo();
		rai.setRoleId(roleId);
		
		List<RoleAnthorityInfo> railist = anthotychangeService.getRoleAnthorityList(rai);

		// 权限（菜单）
		List<AnthortyInfo> list = anthortyService.getList();

		List<AnthortyDTO> dtolist = new ArrayList<AnthortyDTO>();

		for (AnthortyInfo anth : list) {

			if (anth!=null &&anth.getAnthortyPid() == 1) {
				AnthortyDTO dto = new AnthortyDTO();
				
				if(railist!=null && railist.size()>0){
					for(RoleAnthorityInfo rainfo:railist){
						if(rainfo.getAnthortyId() == anth.getAnthortyId()){
							anth.setChecked(true);
						}
					}
				}
				
				// 一级菜单
				dto.setAnth(anth);
				
				
				
				// 子菜单
				List<AnthortyInfo> sublist = new ArrayList<AnthortyInfo>();
				getAnthorty(railist,sublist, list, anth.getAnthortyId());

				dto.setList(sublist);
				System.out.println(sublist.size());

				dtolist.add(dto);
			}

		}

		model.addAttribute("dtolist", dtolist);

		return "system/anthotychange/anthorty_change";
	}

	public void getAnthorty(List<RoleAnthorityInfo> railist,List<AnthortyInfo> sublist,
			List<AnthortyInfo> list, Integer anthortyId) {

		if (list != null && list.size() > 0) {
			for (AnthortyInfo anth : list) {
				if (anth!=null && anth.getAnthortyPid()!=null && anth.getAnthortyPid().equals(anthortyId)) {
					if(railist!=null && railist.size()>0){
						for(RoleAnthorityInfo rainfo:railist){
							if(rainfo.getAnthortyId() == anth.getAnthortyId()){
								anth.setChecked(true);
							}
						}
					}
					sublist.add(anth);
					getAnthorty(railist,sublist, list, anth.getAnthortyId());
				}
			}
		}

	}
	
	/**
	 * 添加权限信息
	 * @param roleId 角色编号
	 * @param anthortyId 权限编号
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(Integer roleId,Integer[] anthortyId,Model model){
		System.out.println("角色编号："+roleId);
		System.out.println("权限编号："+anthortyId);
		
		boolean mark = false;
		
		if(anthortyId!=null && anthortyId.length>0){
			
			try {
				anthotychangeService.add(roleId, anthortyId);
				mark = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if (mark) {

			model.addAttribute("info", "权限变更成功");
		} else {
			model.addAttribute("info", "权限变更失败");
		}
		
		
		
		return list(null,model);
	}
}
