package com.bfw.inform.controller;

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

import com.bfw.inform.service.informActiveService;
import com.bfw.po.informActive;

import com.bfw.po.StaffInfo;


@Controller
@RequestMapping("/informActive/")
public class informActiveController {

	@Resource(name = "informActiveServiceImpl")
	private informActiveService informActiveService;

	/**
	 * 添加公告活动
	 * 
	 * @param market
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(informActive market, Model model,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		if (staff != null) {
			if (market != null) {
				market.setStaffId(staff.getStaffId());
			}
		}

		boolean mark = informActiveService.addMarket(market);
		if (mark) {
			model.addAttribute("info", "添加公告成功");
		} else {
			model.addAttribute("info", "添加公告失败");
		}

		return list(market, model);
	}

	@RequestMapping("list.do")
	public String list(informActive market, Model model) {

		List<informActive> list = informActiveService
				.getMarketActiveList(market);
		
		model.addAttribute("list", list);

		return "inform/inform/inform_main_list";
	}
	
	@RequestMapping("list1.do")
	public String list1(informActive market, Model model) {

		List<informActive> list = informActiveService
				.getMarketActiveList(market);
		
		model.addAttribute("list", list);

		return "inform/inform/inform_list";
	}

/*	@RequestMapping("show.do")
	public String show(Integer activeId, Model model) {
		MarketActive mess =  marketActiveService.getinformList(activeId);
		model.addAttribute("mess", mess);

		return "marketing/marketactive/marketactive_show";
	}
*/

	
	/**
	 * 加载修改页面信息
	 * @param activeId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String  load(Integer activeId, Model model){
		
		informActive market = informActiveService.getMarketActive(activeId);
		model.addAttribute("market", market);
		
		return "inform/inform/inform_update";
	}
	
	
	@RequestMapping("load1.do")
	public String  load1(Integer activeId, Model model){
		
		informActive market = informActiveService.getMarketActive(activeId);
		model.addAttribute("market", market);
		
		return "inform/inform/inform_mes";
	}
	
	/**
	 * 修改活动信息
	 * @param market
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(informActive market, Model model){
		boolean mark = informActiveService.updateMarket(market);
		if (mark) {
			model.addAttribute("info", "修改公告成功");
		} else {
			model.addAttribute("info", "修改公告失败");
		}

		return list(market, model);
	}	
	
	/**
	 * 根据编号删除信息
	 * @param activeId
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer activeId, Model model){
		boolean mark = informActiveService.deleteMarket(activeId);
		if (mark) {
			model.addAttribute("info", "删除公告成功");
		} else {
			model.addAttribute("info", "删除公告失败");
		}

		return list(null, model);
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
