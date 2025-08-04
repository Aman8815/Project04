package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rays.Bean.RoleBean;
import com.rays.Bean.doctorBean;
import com.rays.util.JDBCDataSource;

public class RoleModel {
	
	public RoleBean findById(int id) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "select * from role where id =" + id;
		System.out.println(q);
		PreparedStatement pstmt = con.prepareStatement(q);
		RoleBean bean = new RoleBean();
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
		}
		return bean;
	}

}
