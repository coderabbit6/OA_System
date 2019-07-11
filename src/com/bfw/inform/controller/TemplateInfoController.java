package com.bfw.inform.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.inform.service.TemplateInfoService;
import com.bfw.po.TemplateInfo;


@Controller
@RequestMapping("/template/")
public class TemplateInfoController {

	@Resource(name="templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;
	
	/**
	 * 查询信息
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(TemplateInfo info,Model model){
		
		List<TemplateInfo> list = templateInfoService.getTemplateInfoList(info);
		model.addAttribute("list", list);
		
		return "marketing/template/template_list";
	}
	
	@RequestMapping("add.do")
	public String add(TemplateInfo info,Model model){
		
		boolean mark = templateInfoService.addTemplate(info);
		if(mark){
			model.addAttribute("info", "添加模板成功");
		}else{
			model.addAttribute("info", "添加模板失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 加载修改页面
	 * @param templateId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer templateId,Model model){
		
		TemplateInfo templateInfo = templateInfoService.getTemplate(templateId);
		
		model.addAttribute("templateInfo", templateInfo);
		
		return "marketing/template/template_update";
	}
	
	@RequestMapping("update.do")
	public String update(TemplateInfo info,Model model){
		
		boolean mark = templateInfoService.updateTemplate(info);
		if(mark){
			model.addAttribute("info", "修改模板成功");
		}else{
			model.addAttribute("info", "修改模板失败");
		}
		
		return list(info,model);
	}
	
	/**
	 * 删除模板信息
	 * @param templateId
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer templateId,Model model){
		//根据编号删除模板信息
		boolean mark = templateInfoService.deleteTemplate(templateId);
		
		if(mark){
			model.addAttribute("info", "删除模板成功");
		}else{
			model.addAttribute("info", "删除模板失败");
		}
		
		return list(null,model);
	}
	
}
