
package com.rays.test;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.Bean.patientBean;
import com.rays.model.patientModel;

public class Patienttest {
	public static void main(String[] args) throws Exception {
		//add();
		//update();
		//delete();
	 // search();
		//findbuid();
		findbyspecility();
	}

	private static void findbyspecility() throws Exception {
		// TODO Auto-generated method stub
		 patientModel model = new patientModel();
		 String op = "CANCER";
		List list =   model.findByspecility(op);
		
		 Iterator it = list.iterator();
		 while(it.hasNext()) {
			 patientBean bean = (patientBean) it.next();
			 System.out.println(bean.getDisease());
		 }
	}

	private static void findbuid() throws Exception {
		// TODO Auto-generated method stub
		patientModel model = new patientModel();
	 patientBean bean = (patientBean)	model.findById(1);
	 
	  System.out.println(bean.getId());
		
	}

	private static void search() throws Exception {
		// TODO Auto-generated method stub
		 
		patientBean bean = new patientBean();
		patientModel model = new patientModel();
		
		  List list = model.search(bean);
		  
		  Iterator it = list.iterator();
		  
		  while(it.hasNext()) {
			  bean = (patientBean)it.next();
			  System.out.println(bean.getDisease());
		  }
		
	}

	private static void delete() throws Exception {
		// TODO Auto-generated method stub
		 patientModel model = new patientModel();
		  
		 model.delete(4);
		 
	}

	private static void update() throws Exception {
		
		patientBean bean = new patientBean();
		patientModel model = new patientModel();
		bean.setId(1);
		bean.setName("Aman");
		bean.setDateOfVisit(new Timestamp(new Date().getTime()));
		bean.setMobile("6263642541");
		bean.setDisease("normal");
		
		patientBean mbean = model.findbymobile(bean);
		
		if(mbean == null || mbean.getId()==bean.getId()) {
			model.update(bean);
		}
		else {
			System.out.println("Mobile number is all ready exist");
		}
		
		
		
	}

	private static void add() throws Exception {
		
		patientBean bean = new patientBean();
		patientModel model = new patientModel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setName("Rajveer");
		bean.setDateOfVisit(new Timestamp(new Date().getTime()));
		bean.setMobile("9399127884");
		bean.setDisease(" Head pain");
		bean.setEmail("Amansingh@gmail.com");
		bean.setAddress("indore");
		
		patientBean mbean = model.findbymobile(bean);
		
		if(mbean == null) {
			model.add(bean);
		}
		else {
			System.out.println("Mobile number is all ready exist");
		}
		
	}
	

}
