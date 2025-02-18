package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class RoleModel {

	public Integer nextPk() throws SQLException, Exception {
		int pk = 1;
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select max(id) from st_role");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = pk + rs.getInt(1);
		}
		return pk;
	}

	public void add(RoleBean bean) throws SQLException, Exception {
		
		RoleBean exist = findByName(bean);
		if(bean != null) {
			System.out.println("Role is already Exiest");
		}
		else {

		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into st_role values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, nextPk());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getDescription());
		pstmt.setString(4, bean.getCreatedBy());
		pstmt.setString(5, bean.getModifiedBy());
		pstmt.setTimestamp(6, bean.getCreatedDatetime());
		pstmt.setTimestamp(7, bean.getModifiedDatetime());
		pstmt.executeUpdate();

		System.out.println("Data Insert Successfully");
	}
	}

	public void update(RoleBean bean) throws SQLException, Exception {
		
		 RoleBean existbean = findByName(bean);
		 System.out.println(existbean.getId());
		 System.out.println(bean.getId());
		 if(bean != null && bean.getId() != existbean.getId()) {
			 System.out.println("Role is Already exiest");
		 }
		 else {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(
				"update st_role set name = ?, description = ?, created_by = ? , modified_by = ?, modified_datetime = ? where id = ? ");
	     
		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getDescription());
		pstmt.setString(3, bean.getCreatedBy());
		pstmt.setString(4, bean.getModifiedBy());
		pstmt.setTimestamp(5, bean.getModifiedDatetime());
		pstmt.setLong(6,bean.getId());
		pstmt.executeUpdate();
		
		System.out.println("Update data successfully");
	
	}
	}
	
	public void delete(int id) throws SQLException, Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from st_role where id = ?");
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		
		System.out.println("Delete Date Successfully");
	}
	public List list() throws SQLException, Exception {
		return search(null,0,0);
	}
	
	
	public List search(RoleBean bean,int pageNo , int pageSize) throws SQLException, Exception {
		List list = new ArrayList();
		Connection con = JDBCDataSource.getConnection();
		
		 StringBuffer sql = new StringBuffer("select * from st_role where 1=1");

			if (bean != null) {
				if (bean.getName() != null && bean.getName().length() > 0) {
					sql.append(" and name like '" + bean.getName() + "%'");
				}
			}

			if (pageNo > 0) {
				pageNo = (pageNo - 1) * pageSize;
				sql.append(" limit " + pageNo + ", " + pageSize);
			}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		System.out.println(sql.toString());

		ResultSet rs = pstmt.executeQuery();
         bean = null;
		while (rs.next()) {
		bean = new RoleBean();
		bean.setId(rs.getLong(1));
		bean.setName(rs.getString(2));
		bean.setDescription(rs.getString(3));
		bean.setCreatedBy(rs.getString(4));
		bean.setModifiedBy(rs.getString(5));
		bean.setCreatedDatetime(rs.getTimestamp(6));
		bean.setModifiedDatetime(rs.getTimestamp(7));
		list.add(bean);
		}
		return list;
	}
	
	 public RoleBean findByName(RoleBean bean) throws SQLException, Exception {
		 Connection con = JDBCDataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from st_role where name = ?");
			pstmt.setString(1,bean.getName());
			
			ResultSet rs = pstmt.executeQuery();
			bean = null;
			while(rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getLong(1));
			}
		 return bean;
	 }
	 public RoleBean findByPk(long id) throws Exception {

			Connection conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from st_role where id = ?");

			pstmt.setLong(1, id);

			ResultSet rs = pstmt.executeQuery();

			RoleBean bean = null;

			while (rs.next()) {
				bean = new RoleBean();
				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setCreatedBy(rs.getString(4));
				bean.setModifiedBy(rs.getString(5));
				bean.setCreatedDatetime(rs.getTimestamp(6));
				bean.setModifiedDatetime(rs.getTimestamp(7));
			}
			
			return bean;
		}
	

	
}
