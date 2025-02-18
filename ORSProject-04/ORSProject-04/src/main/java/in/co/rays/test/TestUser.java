package in.co.rays.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.RoleModel;
import in.co.rays.model.UserModel;

public class TestUser {
	public static void main(String[] args) throws SQLException, Exception {
		TestAdd();
		// TestUpdate();
		// TestDelete();
		//TestSearch();
		//TestSearch();
		//testSearchById();
		//testLoginId();
		//testlist();

	}

	private static void testlist() throws SQLException, Exception {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		List list = model.list();
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId() + " " + bean.getFirstName() + " " + bean.getLastName());
		}
	}

	private static void testLoginId() throws SQLException, Exception {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		 bean = model.authenticate("Amansingh@gamil.com", "1234");
		 
		 if(bean != null) {
			 System.out.println("Login successfully");
		 }
		 else{
			System.out.println("Invalid loginId aND password"); 
		 }
	}

	private static void testSearchById() throws SQLException, Exception {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		bean.setId(2L);
		List list = model.findByPk(bean);
		
		Iterator it =  list.iterator();
		while(it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId()+" "+bean.getFirstName()+" "+bean.getLastName());
		}
	}

	private static void TestSearch() throws SQLException, Exception {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean.setFirstName("Aman");
		List list = model.search(bean,1,1);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId() + " " + bean.getFirstName() + " " + bean.getLastName());
		}
	}

	private static void TestDelete() throws SQLException, Exception {
		// TODO Auto-generated method stub
		UserModel model = new UserModel();
		model.delete(1);
	}

	private static void TestUpdate() throws Exception {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(1L);
		bean.setFirstName("Deepak");
		bean.setLastName("Singh");
		bean.setLogin("Amansingh@gamil.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("2022-02-02"));
		bean.setMobileNo("97520858548");
		bean.setRoleId(3L);
		bean.setGender("male");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.upadte(bean);
	}

	private static void TestAdd() throws SQLException, Exception {
		// TODO Auto-generated method stub
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		bean.setFirstName("Aman");
		bean.setLastName("Singh");
		bean.setLogin("Abhijeet@gamil.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("2022-02-02"));
		bean.setMobileNo("9998890811");
		bean.setRoleId(2L);
		bean.setGender("male");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
	}

}
