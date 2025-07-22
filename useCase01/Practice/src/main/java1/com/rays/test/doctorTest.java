package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.Bean.doctorBean;
import com.rays.model.doctorModel;

public class doctorTest {
  public static void main(String[] args) throws Exception {
	//add();
	 // update();
	  //delete();
	// search();
}

private static void search() throws Exception {
	// TODO Auto-generated method stub
	 
	doctorBean bean = new doctorBean();
	doctorModel model = new doctorModel();
	
	  List list = model .search(bean);
	  
	  Iterator it = list.iterator();
	  
	  while(it.hasNext()) {
		  bean = (doctorBean) it.next();
		  System.out.println(bean.getName());
	  }
}

private static void delete() throws Exception {
	// TODO Auto-generated method stub
	doctorModel model = new doctorModel();
	
	 model.delete(1);
}

private static void update() throws Exception {
	// TODO Auto-generated method stub
	doctorBean bean = new doctorBean();
	doctorModel model = new doctorModel();
	  
	
	  bean.setId(1);
	  bean.setName("Aman");
	  bean.setEmail("amansingh@gmail.com");
	  bean.setPhone("6263642541");
	  bean.setSpecility("ortho");
	  bean.setAddress("sonkatch");
	  bean.setGender("male");   
	  bean.setWorkday("Friday");
	  
	  model.update(bean);
}

private static void add() throws Exception {
	// TODO Auto-generated method stub
	doctorBean bean = new doctorBean();
	doctorModel model = new doctorModel();
	
	  bean.setName("Aman");
	  bean.setEmail("amansingh@gmail.com");
	  bean.setPhone("6263642541");
	  bean.setSpecility("MBBS");
	  bean.setAddress("sonkatch");
	  bean.setGender("male");   
	  bean.setWorkday("Friday");
	  
	  model.add(bean);
}     
}
