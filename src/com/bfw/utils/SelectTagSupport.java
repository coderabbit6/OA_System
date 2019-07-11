package com.bfw.utils;

import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义标签库
 * <s:select type="active_state" id="" name="dataId"  selectedId="2"/>
 * type:数据类型
 * id：select元素id
 * name:select元素name
 * selectClass:select元素class
 * selectedId: 默认选项编号（selected）
 *
 *
 */
public class SelectTagSupport extends TagSupport {

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 下拉列表名称
	 */
	private String name;

	/**
	 * 下拉列表ID
	 */
	private String id;

	/**
	 * 下拉列表样式
	 */
	private String selectClass = "form-control  input-sm";

	/**
	 * 匹配默认选项
	 */
	private int selectedId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}

	public int getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int doEndTag() throws JspException {
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			String sql = " select * from data_dictionary where data_type=?";

			con = DBUtils.getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, type);
			res = pre.executeQuery();

			// 获取页面输出流
			Writer out = pageContext.getOut();
			StringBuilder select = new StringBuilder("<select ");
			if (name != null && !name.equals("")) {
				select.append("name='" + name + "'");
			}
			if (id != null && !id.equals("")) {
				select.append("id='" + id + "'");
			}
			if (selectClass != null && !selectClass.equals("")) {
				select.append("class='" + selectClass + "'");
			}
			select.append(">");

			select.append("<option value=''>请选择</option>");

			while (res.next()) {

				select.append("<option value='" + res.getInt("data_id") + "'");

				if (selectedId != 0 && selectedId == res.getInt("data_id")) {

					select.append("selected");
				}

				select.append(">" + res.getString("data_content") + "</option>");

			}
			select.append("</select>");
			out.write(select.toString());
			out.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, pre, res);
		}

		return EVAL_PAGE;
	}

}
