package com.bfw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;

 
public class DBUtils {

	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConnection(){
		
		try {
			System.out.print("111111111111111111111111111111111111111111111111111111111");
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//定义URL
			String url = "jdbc:mysql://192.168.55.16/oa_system";
			
			//获取连接
			return  DriverManager.getConnection(url, "root", "123");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 关闭资源
	 * @param con
	 * @param pre
	 * @param res
	 */
	public static void close(Connection con,PreparedStatement pre,ResultSet res){
		try {
			con.close();
			pre.close();
			pre.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
