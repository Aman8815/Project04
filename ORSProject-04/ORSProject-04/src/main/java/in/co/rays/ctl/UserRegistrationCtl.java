package in.co.rays.ctl;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "UserRegistrationCtl", urlPatterns = "/UserRegistrationCtl")
public class UserRegistrationCtl extends BaseCtl {

	public static final String OP_SIGN_UP = "Sign Up";
	public static final String OP_RESET = "Reset";
	
	@Override
	protected boolean validate(HttpServletRequest request) {
	boolean valid = true;
	
	if(DataValidator.isNull(request.getParameter("firstName"))) {
		request.setAttribute("firstName","firstName is requred");
		valid = false;
	}
	if(DataValidator.isNull(request.getParameter("lastName"))) {
		request.setAttribute("lastName","lastName is requred");
		valid = false;
	}
	
	
	
	if(DataValidator.isPassword(request.getParameter("password")) || DataValidator.isPasswordLength(request.getParameter("password")) || DataValidator.isNull(request.getParameter("password"))) {
		request.setAttribute("password","password is required");
		valid = false;
	}
	if(DataValidator.isPassword(request.getParameter("confirmPassword")) || DataValidator.isPasswordLength(request.getParameter("confirmPassword")) || DataValidator.isNull(request.getParameter("confirmPassword"))) {
		request.setAttribute("confirmPassword","confirmPassword is required");
		valid = false;
	}
	if(DataValidator.isNull(request.getParameter("lastName"))) {
		request.setAttribute("lastName","lastName is required");
		valid = false;
	}
	if(DataValidator.isNull(request.getParameter("lastName"))) {
		request.setAttribute("lastName","lastName is required");
		valid = false;
	}
	if(DataValidator.isNull(request.getParameter("lastName"))) {
		request.setAttribute("lastName","lastName is required");
		valid = false;
	}
	
	
	
	return valid;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setLogin(DataUtility.getString(request.getParameter("login")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		System.out.println("dob === " + request.getParameter("dob"));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		System.out.println("dob from bean === " + bean.getDob());
		bean.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		bean.setRoleId((long) RoleBean.STUDENT);
		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = DataUtility.getString(request.getParameter("operation"));
		UserModel model = new UserModel();

		if (OP_SIGN_UP.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);
			try {
				model.registerUser(bean);
				ServletUtility.setBean(bean, request);
				ServletUtility.setSuccessMessage("User Register Successfull", request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				e.getStackTrace();
			} catch (DuplicateRecordException e) {
				ServletUtility.setErrorMessage(e.getMessage(), request);
				ServletUtility.forward(getView(), request, response);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.USER_REGISTRATION_CTL, request, response);
		}

	}

	@Override
	protected String getView() {
		return ORSView.USER_REGISTRATION_VIEW;
	}

}
