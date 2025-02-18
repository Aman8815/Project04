package in.co.rays.test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class testRole {
public static void main(String[] args) throws SQLException, Exception {
	//testAdd();
	 //testUpdate();
	//testDelete();
	testsearch();
}

private static void testsearch() throws SQLException, Exception {
	// TODO Auto-generated method stub
	RoleBean bean = new RoleBean();
	RoleModel model = new RoleModel();
	bean.setName("Admin");
	List list = model.search(bean,1,5);
	
	      Iterator it =  list.iterator();
	      while(it.hasNext()) {
	    	  bean = (RoleBean) it.next();
	    	 System.out.println(bean.getId()+" "+bean.getName());
	      }
}

private static void testDelete() throws SQLException, Exception {
	// TODO Auto-generated method stub
	RoleBean bean = new RoleBean();
	RoleModel model =  new RoleModel();
      model.delete(1);
}

private static void testUpdate() throws SQLException, Exception {
	// TODO Auto-generated method stub
RoleBean bean = new RoleBean();
	bean.setId(2L);
	bean.setName("student");
	bean.setDescription("Aman");
	bean.setCreatedBy("admin@gmail.com");
	bean.setModifiedBy("admin@gmail.com");
	//bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	RoleModel model = new RoleModel();
	model.update(bean);
}

private static void testAdd() throws SQLException, Exception {
	// TODO Auto-generated method stub
	RoleBean bean = new RoleBean();
	
	bean.setName("Admin");
	bean.setDescription("Admin");
	bean.setCreatedBy("admin@gmail.com");
	bean.setModifiedBy("admin@gmail.com");
	bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
	bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
	RoleModel model = new RoleModel();
	model.add(bean);
}
}
