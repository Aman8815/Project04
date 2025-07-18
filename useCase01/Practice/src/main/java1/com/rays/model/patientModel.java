package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.Bean.patientBean;
import com.rays.util.JDBCDataSource;

public class patientModel {

	public patientBean findbymobile(patientBean bean) throws Exception {

		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con
				.prepareStatement("select * from patient where mobile = '" + bean.getMobile() + "%'");

		System.out.println();

		ResultSet rs = pstmt.executeQuery();
		bean = null;
		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDateOfVisit(rs.getDate(3));
			bean.setMobile(rs.getString(4));
			bean.setDisease(rs.getString(5));

		}

		return bean;
	}

	public int nextPk() throws Exception {

		int pk = 0;
		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement("select max(id)from patient");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public long add(patientBean bean) throws Exception {

		Connection con = JDBCDataSource.getConnection();
		String q = "insert into patient values (?,?,?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(q);

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getName());
		pstmt.setDate(3, new java.sql.Date(bean.getDateOfVisit().getTime()));
		pstmt.setString(4, bean.getMobile());
		pstmt.setString(5, bean.getDisease());
		pstmt.setString(6,bean.getEmail());
		pstmt.setString(7,bean.getAddress());

		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted  Successfully !!!" + i);
		return 1;

	}

	public void update(patientBean bean) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "update patient set name = ? ,dateOfVisit = ? ,mobile = ? ,disease = ? where id = ?";

		PreparedStatement pstmt = con.prepareStatement(q);

		pstmt.setString(1, bean.getName());
		pstmt.setDate(2, new java.sql.Date(bean.getDateOfVisit().getTime()));
		pstmt.setString(3, bean.getMobile());
		pstmt.setString(4, bean.getDisease());
		pstmt.setInt(5, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data Update Successfully !!!" + i);

	}

	public void delete(int id) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "delete from patient where id = ?";

		PreparedStatement pstmt = con.prepareStatement(q);
		
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		
		System.out.println("Data delete successfully");
	}
	
	public List search(patientBean bean) throws Exception {
		ArrayList list = new ArrayList();
		
		Connection con = JDBCDataSource.getConnection();
		String q = "select * from patient ";

		PreparedStatement pstmt = con.prepareStatement(q);
		 
		ResultSet rs = pstmt.executeQuery();
		bean = null;
		while(rs.next()) {
			bean = new patientBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setDateOfVisit(rs.getDate(3));
			bean.setMobile(rs.getString(4));
			bean.setDisease(rs.getString(5));
			list.add(bean);
		}
		
		
		return list;
	}

}