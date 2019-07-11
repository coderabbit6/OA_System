package com.bfw.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bfw.po.StaffInfo;

 
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// 获取HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// 获取session
		HttpSession session = req.getSession();
		// 获取当前登录用户信息
		StaffInfo staff = (StaffInfo) session.getAttribute("staff");

		// 获取请求URL信息
		String url = req.getRequestURI();
		System.out.println(url);
		if (url.contains("studentphone/login.do")) {
			// 转发到下一个过滤器或Servlet（表示正常运行）
			chain.doFilter(request, response);
		} else  if (url.contains("/login.do")) {
			// 转发到下一个过滤器或Servlet（表示正常运行）
			chain.doFilter(request, response);
		}
		if (url.contains("/login_phone.jsp")) {
			// 转发到下一个过滤器或Servlet（表示正常运行）
			chain.doFilter(request, response);
		} else if (url.contains("/resources/")) {
			// 转发到下一个过滤器或Servlet（表示正常运行）
			chain.doFilter(request, response);
		} else if (staff != null) {
			// 转发到下一个过滤器或Servlet（表示正常运行）
			chain.doFilter(request, response);
		} else {
			if (url.contains("/studentphone/")) {
				// 转发页面
				req.getRequestDispatcher("/view/login_phone.jsp").forward(req,
						response);
			} else {
				if (!url.contains("/studentphone/")) {
					// 转发页面
					req.getRequestDispatcher("/view/login.jsp").forward(req,
							response);
				}
			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
