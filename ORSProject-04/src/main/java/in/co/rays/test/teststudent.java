package in.co.rays.test;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import in.co.rays.bean.StudentBean;
import in.co.rays.model.StudentModel;

public class teststudent {
	public static void main(String[] args) throws Exception {
		//testAdd();
		testUpdate();
	}

	private static void testUpdate() throws SQLException, Exception {

		// TODO Auto-generated method stub
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setId(1L);
		bean.setFirstName("Aman");
		bean.setLastName("Singh");
		bean.setDob(new Date());
		System.out.println(bean.getDob());
		bean.setGender("male");
		bean.setMobileNo("6263642541");
		bean.setEmail("Amansingh@gmail.com");
		bean.setCollegeId(2L);	
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.update(bean);
	}

	private static void testAdd() throws Exception {
		// TODO Auto-generated method stub
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setFirstName("Aman");
		bean.setLastName("Singh");
		bean.setDob(new Date());
		System.out.println(bean.getDob());
		bean.setGender("male");
		bean.setMobileNo("6263642541");
		bean.setEmail("Amansingh@gmail.com");
		bean.setCollegeId(3L);
		
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("student@gmail.com");
		bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
		model.add(bean);
		
	}

}
