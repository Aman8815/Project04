package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.Bean.doctorBean;
import com.rays.Bean.patientBean;
import com.rays.util.JDBCDataSource;

public class doctorModel {

	public int nextPk() throws Exception {

		int pk = 0;
		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement("select max(id)from doctor");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public void add(doctorBean bean) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "insert into doctor values (?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(q);

		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getEmail());
		pstmt.setString(4, bean.getPhone());
		pstmt.setString(5, bean.getSpecility());
		pstmt.setString(6, bean.getAddress());
		pstmt.setString(7, bean.getGender());
		pstmt.setString(8, bean.getWorkday());
		int i = pstmt.executeUpdate();

		System.out.println("Data Inserted  Successfully !!!" + i);

	}

	public void update(doctorBean bean) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "update doctor set name = ? ,email = ? ,phone = ? ,specility = ?,address=?,gender=?,workday=? where id = ?";

		PreparedStatement pstmt = con.prepareStatement(q);

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getEmail());
		pstmt.setString(3, bean.getPhone());
		pstmt.setString(4, bean.getSpecility());
		pstmt.setString(5, bean.getAddress());
		pstmt.setString(6, bean.getGender());
		pstmt.setString(7, bean.getWorkday());
		pstmt.setInt(8, bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("Data Update Successfully !!!" + i);

	}

	public void delete(int id) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "delete from doctor where id = ?";

		PreparedStatement pstmt = con.prepareStatement(q);

		pstmt.setInt(1, id);
		pstmt.executeUpdate();

		System.out.println("Data delete successfully");
	}

	public List search(doctorBean bean) throws Exception {
		ArrayList list = new ArrayList();

		Connection con = JDBCDataSource.getConnection();
		String q = "select * from doctor ";

		PreparedStatement pstmt = con.prepareStatement(q);

		ResultSet rs = pstmt.executeQuery();
		bean = null;
		while (rs.next()) {
			bean = new doctorBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPhone(rs.getString(4));
			bean.setSpecility(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setWorkday(rs.getString(8));
			list.add(bean);
		}

		return list;
	}

	public doctorBean findById(int id) throws Exception {
		Connection con = JDBCDataSource.getConnection();
		String q = "select * from doctor where id =" + id;
		System.out.println(q);
		PreparedStatement pstmt = con.prepareStatement(q);
		doctorBean bean = new doctorBean();
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setEmail(rs.getString(3));
			bean.setPhone(rs.getString(4));
			bean.setSpecility(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setGender(rs.getString(7));
			bean.setWorkday(rs.getString(8));
		}
		return bean;
	}


}
