package com.rays.ctl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.patientBean;
import com.rays.model.patientModel;
import com.sun.mail.iap.Response;

@WebServlet("/AddPatientctl")
public class AddPatientctl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ids = req.getParameter("id");
       
         System.out.println(ids);
         if(ids!=null) {
        	  
        	   patientModel model = new patientModel();
        	   try {
        		   int id = Integer.parseInt(ids);
			 patientBean bean = model.findById(id);
			   
			 req.setAttribute("bean",bean);
			 RequestDispatcher rd = req.getRequestDispatcher("Addpatient.jsp");
				rd.forward(req, resp);	
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
        
            resp.sendRedirect("Addpatient.jsp");
         }
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		patientBean bean = new patientBean();
		patientModel model = new patientModel();
      
		bean.setName(req.getParameter("name").trim());
		bean.setMobile(req.getParameter("phone").trim());
		bean.setEmail(req.getParameter("email").trim());
		bean.setAddress(req.getParameter("address").trim());
		bean.setDisease(req.getParameter("disease").trim());
		bean.setGender(req.getParameter("gender").trim());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setDateOfVisit(new Timestamp(new Date().getTime()));
         bean.setTotal(Integer.parseInt(req.getParameter("Total"))); 
         bean.setDeposit(Integer.parseInt(req.getParameter("Deposit")));
         bean.setDescription(req.getParameter("Description").trim());
		String ids = req.getParameter("id");
		try {
			
	   if(ids==null) {
			model.add(bean);
			req.setAttribute("msg","Data insert succesfully");
			RequestDispatcher rd = req.getRequestDispatcher("Addpatient.jsp");
			rd.forward(req, resp);
			
	   }else {
		   bean.setId(Integer.parseInt(ids));
		   model.update(bean);
		   resp.sendRedirect("patiendListctl");
	 
	   }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
