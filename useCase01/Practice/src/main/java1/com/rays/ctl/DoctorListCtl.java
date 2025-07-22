package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.doctorBean;
import com.rays.model.doctorModel;
import com.rays.model.patientModel;

@WebServlet("/DoctorListCtl")
public class DoctorListCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doctorBean bean = new doctorBean();
		doctorModel model = new doctorModel();
		patientModel pmodel = new patientModel();
		String op = request.getParameter("specility");
		
		
		 try {
			List list = model.search(bean);
			request.setAttribute("list",list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		 
		 RequestDispatcher rd = request.getRequestDispatcher("DoctorListView.jsp");
			rd.forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op = request.getParameter("operation");
		
	    if ("delete".equalsIgnoreCase(op)) {

	        String[] ids = request.getParameterValues("ids");

	        if (ids != null && ids.length > 0) {
	            for (String s : ids) {
	                int id = Integer.parseInt(s);
	                doctorModel model = new doctorModel();
	                try {
	                    model.delete(id);
	                } catch (Exception e) {
	                    e.printStackTrace();
	     
	                  return;
	                }
	            }

	            // 🟢 Record delete hone ke baad redirect ke saath msg bhejna hai
	            request.getSession().setAttribute("msg", "Data deleted successfully.");
	            response.sendRedirect("DoctorListCtl");

	        } else {
	            // 🟠 Agar koi record select nahi hua
	        	request.getSession().setAttribute("msg", " select at list one record .");
	            response.sendRedirect("DoctorListCtl");
	        }

	    } else if ("new".equalsIgnoreCase(op)) {
	        response.sendRedirect("AddDoctor.jsp");
	    }
	}

}
