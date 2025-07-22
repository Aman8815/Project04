package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.Bean.patientBean;
import com.rays.model.patientModel;

@WebServlet("/patiendListctl")
public class patiendListctl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		patientBean bean = new patientBean();
		patientModel model = new patientModel();
         
		String op = request.getParameter("specility");
		System.out.println(op);
		if(op==null) {
			 System.out.println("amAN");
			 try {
					List list = model.search(bean);
					request.setAttribute("list", list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			
			else {
				try {
					System.out.println("aBHI");
					List list = model.findByspecility(op);
					request.setAttribute("list",list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();}
			}
		RequestDispatcher rd = request.getRequestDispatcher("PtientListview.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String op = request.getParameter("operation");

	    if ("delete".equalsIgnoreCase(op)) {

	        String[] ids = request.getParameterValues("ids");

	        if (ids != null && ids.length > 0) {
	            for (String s : ids) {
	                int id = Integer.parseInt(s);
	                patientModel model = new patientModel();
	                try {
	                    model.delete(id);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    request.setAttribute("msg", "Error during delete: " + e.getMessage());
	                    request.getRequestDispatcher("PatientList.jsp").forward(request, response);
	                    return;
	                }
	            }

	            // 🟢 Record delete hone ke baad redirect ke saath msg bhejna hai
	            request.getSession().setAttribute("msg", "Data deleted successfully.");
	            response.sendRedirect("patiendListctl");

	        } else {
	            // 🟠 Agar koi record select nahi hua
	        	request.getSession().setAttribute("msg", " select at list one record .");
	            response.sendRedirect("patiendListctl");
	        }

	    } else if ("new".equalsIgnoreCase(op)) {
	        response.sendRedirect("Addpatient.jsp");
	    }
	    else if("Back".equalsIgnoreCase(op)) {
	    	response.sendRedirect("DoctorListCtl");
	    }
	}
}

