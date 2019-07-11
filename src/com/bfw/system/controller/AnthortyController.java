package com.bfw.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.po.AnthortyInfo;
import com.bfw.system.service.AnthortyService;

 
@Controller
@RequestMapping("/anthorty/")
public class AnthortyController {

	@Resource(name = "anthortyServiceImpl")
	private AnthortyService anthortyService;

	/**
	 * 查询权限信息
	 * 
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(Model model, HttpServletRequest request) {

		List<AnthortyInfo> list = anthortyService.getList();
		model.addAttribute("list", list);

		if (list != null && list.size() > 0) {
			request.getSession().setAttribute("anth", list.get(0));
		}

		return "system/anthorty/anthorty_list";
	}

	@RequestMapping("show.do")
	public String show(Integer anthortyId, Model model) {

		AnthortyInfo anth = anthortyService.getAnthortyInfo(anthortyId);
		model.addAttribute("anth", anth);

		return "system/anthorty/anthorty_show";
	}

	@RequestMapping("loadAdd.do")
	public String loadAdd(Integer anthortyId,Model model) {
		List<AnthortyInfo> list = anthortyService.getList();
		model.addAttribute("list", list);
		
		model.addAttribute("anthortyId", anthortyId);

		return "system/anthorty/anthorty_add";
	}

	@RequestMapping("loadUpdate.do")
	public String loadUpdate(Integer anthortyId, Model model) {

		AnthortyInfo anth = anthortyService.getAnthortyInfo(anthortyId);
		model.addAttribute("anth", anth);

		List<AnthortyInfo> list = anthortyService.getList();
		model.addAttribute("list", list);

		return "system/anthorty/anthorty_update";
	}

	/**
	 * 添加权限信息
	 * 
	 * @param anthorty
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(AnthortyInfo anthorty, Model model,
			HttpServletRequest request) {
		boolean mark = anthortyService.add(anthorty);
		if (mark) {
			model.addAttribute("info", "权限信息添加成功");
		} else {
			model.addAttribute("info", "权限信息添加失败");
		}

		return "system/anthorty/anthorty_info";
	}

	/**
	 * 修改权限信息
	 * 
	 * @param anthorty
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(AnthortyInfo anthorty, Model model,
			HttpServletRequest request) {
		boolean mark = anthortyService.update(anthorty);
		if (mark) {
			model.addAttribute("info", "权限信息修改成功");
		} else {
			model.addAttribute("info", "权限信息修改失败");
		}

		return "system/anthorty/anthorty_info";
	}

	/**
	 * 根据编号删除权限信息
	 * 
	 * @param anthortyId
	 *            编号
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer anthortyId, Model model) {
		boolean mark = false;
	
		try {
			//先验证是否有下级菜单，如果没有才能删除
			if(anthortyService.isDelete(anthortyId)){
				anthortyService.delete(anthortyId);
				mark = true;
			}else{
				model.addAttribute("info1", "请先删除下级菜单，");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (mark) {
			model.addAttribute("info", "权限信息删除成功");
		} else {
			model.addAttribute("info", "权限信息删除失败");
		}

		return "system/anthorty/anthorty_info";
	}
}
