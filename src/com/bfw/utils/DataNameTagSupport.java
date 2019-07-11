package com.bfw.utils;

import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
 
public class DataNameTagSupport extends TagSupport {

	/**
	 * 类型
	 */
	private String dataId;

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	@Override
	public int doEndTag() throws JspException {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			String sql = " select * from data_dictionary where data_id=?";

			con = DBUtils.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, dataId);
			res = pre.executeQuery();

			// 获取页面输出流
			Writer out = pageContext.getOut();
	
			if (res.next()) {
				out.write(res.getString("data_content"));
			}
		
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pre, res);
		}

		return EVAL_PAGE;
	}

}
