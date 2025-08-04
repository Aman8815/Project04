package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.doctorBean;
import com.rays.model.doctorModel;
@WebServlet("/AddDoctorctl")
public class AddDoctorctl extends HttpServlet{
   
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
		 doctorModel model = new doctorModel();
		   doctorBean bean = new doctorBean();
		  String id = request.getParameter("id");
		  
		   if(id!=null) {
			   int ids = Integer.parseInt(id);
			   
			     try {
					bean = model.findById(ids);
					request.setAttribute("bean",bean);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   RequestDispatcher rd = request.getRequestDispatcher("AddDoctor.jsp");
			rd.forward(request, response);
		   
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		doctorBean bean = new doctorBean();
		doctorModel model = new doctorModel();
		 
		 bean.setName(request.getParameter("name").trim());
		 bean.setEmail(request.getParameter("email").trim());
		 bean.setPhone(request.getParameter("phone").trim());
		 bean.setSpecility(request.getParameter("specility").trim());
		 bean.setAddress(request.getParameter("address").trim());
		 bean.setGender(request.getParameter("gender").trim());
		 bean.setWorkday(request.getParameter("workday").trim());
		 String ids = request.getParameter("id");
		 if(ids==null) {
		  try {
			model.add(bean);
			
			request.setAttribute("msg","Data inseart successfully ");
			RequestDispatcher rd = request.getRequestDispatcher("AddDoctor.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }else {
			 bean.setId(Integer.parseInt(ids));
			   try {
				model.update(bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   request.getSession().setAttribute("msg","Data Update successfully ");
				response.sendRedirect("DoctorListCtl");
		 }
		
	}
}
