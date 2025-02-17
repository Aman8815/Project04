package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JDBCDataSource;

public class UserModel {

	public int nextPk() throws SQLException, Exception {
		int pk = 1;
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = pk + rs.getInt(1);
		}
		return pk;
	}

	public void add(UserBean bean) throws SQLException, Exception {
		UserModel model = new UserModel();

		UserBean exist = model.findByLoginId(bean);
		if (exist != null) {
			System.err.println("LoginId Already exist");
		} else {

			Connection con = JDBCDataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setDate(6, new java.sql.Date(bean.getDob().getDate()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setString(9, bean.getGender());
			pstmt.setString(10, bean.getCreatedBy());
			pstmt.setString(11, bean.getModifiedBy());
			pstmt.setTimestamp(12, bean.getCreatedDatetime());
			pstmt.setTimestamp(13, bean.getModifiedDatetime());
			pstmt.executeUpdate();

			System.out.println("Data Insert Successfully");
		}
	}

	public void upadte(UserBean bean) throws SQLException, Exception {
		UserModel model = new UserModel();

		UserBean exist = model.findByLoginId(bean);
		if (exist != null ) {
			System.err.println("LoginId Already exist");
		} else {

			Connection con = JDBCDataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"update st_user set first_name = ?, last_name = ?, login = ?, password = ?, dob = ?, mobile_no = ?, role_id = ?, gender = ?, created_by = ?, modified_by = ?, created_datetime = ?, modified_datetime = ?  where id = ?");

			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(6, bean.getMobileNo());
			pstmt.setLong(7, bean.getRoleId());
			pstmt.setString(8, bean.getGender());
			pstmt.setString(9, bean.getCreatedBy());
			pstmt.setString(10, bean.getModifiedBy());
			pstmt.setTimestamp(11, bean.getCreatedDatetime());
			pstmt.setTimestamp(12, bean.getModifiedDatetime());
			pstmt.setLong(13, bean.getId());

			pstmt.executeUpdate();
			System.out.println("data successfully Update");

		}
	}

	public void delete(int id) throws SQLException, Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("Delete from st_user where id =?");
		pstmt.setInt(1, id);
		pstmt.executeUpdate();

		System.out.println("Delete data succesfully");

	}
	
	 public List list() throws SQLException, Exception {
		 return (search(null, 0, 0));
		  
	 }

	public List search(UserBean bean,int pageNo , int pageSize) throws SQLException, Exception {
		List list = new ArrayList();
		Connection con = JDBCDataSource.getConnection();
		StringBuffer stf = new StringBuffer("select * from st_user where 1 = 1 ");

		if (bean != null) {
			if (bean.getId() != null && bean.getId() > 0) {
				stf.append("and id = " + bean.getId());
			}
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				stf.append("and first_name like '" + bean.getFirstName() + "%'");
			}
		}

		if (bean != null) {
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				stf.append("and last_name like '" + bean.getLastName() + "%'");
			}
		}

		if (bean != null) {
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				stf.append("and login like '" + bean.getLogin() + "%'");
			}
		}
		if (bean != null) {
			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				stf.append("and password like '" + bean.getPassword() + "%'");
			}
		}

		if (bean != null) {
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				java.sql.Date d = new java.sql.Date(bean.getDob().getTime());
				stf.append("and dob like '" + d + "%'");
				System.out.println(stf.toString());
			}
		if(pageNo>0) {
			pageNo = (pageNo -1)* pageSize;
			stf.append("limit "+pageNo+","+pageSize);
		}
		}
		System.out.println(stf.toString());
		PreparedStatement pstmt = con.prepareStatement(stf.toString());
		ResultSet rs = pstmt.executeQuery();
		bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			list.add(bean);
		}
		return list;
	}

	public UserBean findByLoginId(UserBean bean) throws SQLException, Exception {
		Connection con = JDBCDataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from st_user where login = ?");
		pstmt.setString(1, bean.getLogin());
		ResultSet rs = pstmt.executeQuery();
		bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
		}

		return bean;
	}
	
	public  List findByPk(UserBean bean) throws SQLException, Exception {
	List list = new ArrayList();
	Connection con = JDBCDataSource.getConnection();
	PreparedStatement pstmt = con.prepareStatement("select * from st_user where id = ?");
	pstmt.setLong(1,bean.getId());
	ResultSet rs = pstmt.executeQuery();
	bean = null;
	while(rs.next()) {
		bean = new UserBean();
		bean.setId(rs.getLong(1));
		bean.setFirstName(rs.getString(2));
		bean.setLastName(rs.getString(3));
		list.add(bean);
	}
	return  list;
	}
	
	public UserBean authenticate(String loginId, String password) throws SQLException, Exception {
		UserBean bean = new UserBean();
		Connection con = JDBCDataSource.getConnection();

		PreparedStatement pstmt = con.prepareStatement("select * from st_user where login = ? and password = ?");
		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			System.out.println(bean.getFirstName());
		}

		return bean;

	}


}
