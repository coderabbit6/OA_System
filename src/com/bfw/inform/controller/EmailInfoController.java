package com.bfw.inform.controller;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.inform.service.EmailInfoService;
import com.bfw.inform.service.TemplateInfoService;
import com.bfw.po.EmailInfo;
import com.bfw.po.StaffInfo;
import com.bfw.po.TemplateInfo;

@Controller
@RequestMapping("/email/")
public class EmailInfoController {

	@Resource(name = "emailInfoServiceImpl")
	private EmailInfoService emailInfoService;

	/**
	 * 短信邮件模板的业务逻辑层
	 */
	@Resource(name = "templateInfoServiceImpl")
	private TemplateInfoService templateInfoService;

	/**
	 * 查询邮件信息
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(EmailInfo info, Model model) {

		List<EmailInfo> list = emailInfoService.getEmailList(info);
		model.addAttribute("list", list);

		return "marketing/emailinfo/emailinfo_list";
	}

	/**
	 * 加载发送页面
	 * 
	 * @param messafeId
	 * @param model
	 * @return
	 */
	@RequestMapping("load.do")
	public String load(Integer messafeId, Model model) {
		TemplateInfo info = new TemplateInfo();
		info.setTemplateType("邮件");
		List<TemplateInfo> templist = templateInfoService
				.getTemplateInfoList(info);
		model.addAttribute("templist", templist);

		return "marketing/emailinfo/emailinfo_send";
	}

	/**
	 * 发送邮件
	 * 
	 * @return
	 */
	@RequestMapping("send.do")
	public String send(EmailInfo info, Model model, HttpServletRequest request) {

		try {
			if (info != null && info.getEmailAddr() != null) {

				
				HttpSession session = request.getSession();
				StaffInfo staff = (StaffInfo) session.getAttribute("staff");

				if (staff != null) {
					if (info != null) {
						info.setStaffId(staff.getStaffId());
						info.setEmailTime(new Date());
					}
				}
				// 发送人
				String sendMan = staff.getStaffName();
			
				// 主题
				String tiltle = info.getEmailTitle();

				String server163 = "smtp.163.com";

				Properties props = new Properties();
				// 指定SMTP服务器
				props.put("mail.smtp.host", server163);
				// 指定是否需要验证
				props.put("mail.smtp.anth", "true");

				Session mailSession = Session.getDefaultInstance(props);
				// 是否显示在控制台
				mailSession.setDebug(true);

				Message meassage = new MimeMessage(mailSession);
				//设置发送人
				meassage.setFrom(new InternetAddress("beifeng1002@163.com"));
				//设置收件人
				meassage.setRecipient(Message.RecipientType.TO, new InternetAddress(info.getEmailAddr()));
				//邮件主题
				meassage.setSubject(tiltle);
				//邮件内容
				meassage.setText(info.getEmailContent());
				meassage.saveChanges();
				
				//163邮箱账号密码
				String user = "beifeng1002";
				String password = "admin123456";
				
				Transport transport = mailSession.getTransport("smtp");
				transport.connect(server163, user, password);
				transport.sendMessage(meassage, meassage.getAllRecipients());
				transport.close();
				
				boolean mark = emailInfoService.addEmail(info);

				if(mark){
					model.addAttribute("info", "邮件发送成功!");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("info", "邮件发送失败!");
		}

		return list(info, model);
	}
	
	/**
	 * 根据编号查询信息
	 * @param messafeId
	 * @param model
	 * @return
	 */
	@RequestMapping("show.do")
	public String show(Integer emailId, Model model){
		
		EmailInfo  emailInfo =emailInfoService.getEmailInfo(emailId);
		model.addAttribute("emailInfo", emailInfo);
		
		
		return "marketing/emailinfo/emailinfo_show";
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer emailId, Model model){
		
		boolean mark = emailInfoService.deleteEmail(emailId);
		if(mark){
			model.addAttribute("info", "删除成功");
		}else{
			model.addAttribute("info", "删除失败");
		}
		
		
		return list(null,model);
	}

}
