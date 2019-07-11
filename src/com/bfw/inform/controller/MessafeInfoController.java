package com.bfw.inform.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.inform.service.MessafeInfoService;
import com.bfw.inform.service.TemplateInfoService;
import com.bfw.po.MessafeInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.TemplateInfo;


@Controller
@RequestMapping("/messafeinfo/")
public class MessafeInfoController {

	/**
	 * 业务逻辑层
	 */
	@Resource(name = "messafeInfoServiceImpl")
	private MessafeInfoService messafeInfoService;

	/**
	 * 短信邮件模板的业务逻辑层
	 */
	@Resource(name = "templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;

	/**
	 * 查询信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(MessafeInfo info, Model model) {

		List<MessafeInfo> list = messafeInfoService.getMessafeList(info);
		model.addAttribute("list", list);

		return "marketing/messafeinfo/messafeinfo_list";
	}

	/**
	 * 根据编号查询短信信息
	 * 
	 * @param messafeId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer messafeId, Model model) {
		TemplateInfo info = new TemplateInfo();
		info.setTemplateType("短信");
		List<TemplateInfo> templist = templateInfoService
				.getTemplateInfoList(info);
		model.addAttribute("templist", templist);

		return "marketing/messafeinfo/messafeinfo_send";
	}
	
	/**
	 * 根据编号查询短信信息
	 * 
	 * @param messafeId
	 * @param model
	 * @return
	 */
	@RequestMapping("show.do")
	public String show(Integer messafeId, Model model) {
		MessafeInfo mess = messafeInfoService.getMessafeInfo(messafeId);
		model.addAttribute("mess", mess);

		return "marketing/messafeinfo/messafeinfo_show";
	}

	/**
	 * 发送短信信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("send.do")
	public String send(MessafeInfo info, Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo)session.getAttribute("staff");
		
		if(staff!=null){
			if(info!=null){
				info.setStaffId(staff.getStaffId());
				info.setMessafeTime(new Date());
			}
		}
		
	
		boolean mark = messafeInfoService.addMesssafe(info);

		if (mark) {
			model.addAttribute("info", "短信发送成功");
		} else {
			model.addAttribute("info", "短信发送失败");
		}

		return list(info, model);
	}

	/**
	 * 删除短信信息
	 * 
	 * @param messafeId
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer messafeId, Model model) {
		boolean mark = messafeInfoService.delete(messafeId);

		if (mark) {
			model.addAttribute("info", "删除短信成功");
		} else {
			model.addAttribute("info", "删除短信失败");
		}
		return list(null, model);
	}

}
