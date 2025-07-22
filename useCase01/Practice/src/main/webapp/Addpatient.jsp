<%@page import="com.rays.Bean.patientBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Patient Data Entry</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<hr>
<div align = "center">
<form action="AddPatientctl" method="post">
<% 
        patientBean bean = (patientBean)request.getAttribute("bean");
     
     if(bean==null){
     %>
	<h2 ><span style="color:red;">Patient Data Entry Form</span></h2>
	
	   <%  String msg = (String)request.getAttribute("msg");
	     if(msg!=null){
	   %><h2><span style="color:green;"><%= msg%></span></h2> <br><br>
	   
	   
	   <%} %>
	Name: <input type="text" name="name" required ><br> <br>
		Email: <input type="email" name="email" required ><br> <br>
		Address: <input type="text" name="address" required ><br>
		<br> Ph.Number: <input type="text" name="phone" required><br>
		<br> Disease: <input type="text" name="disease" required ><br>
		<br> Gender: <input type = "text" name="gender" required><br>
		<br> <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;<input type = "reset" value="reset">
		
	<%}else{ %>
	<h2>Patient Date Update</h2>
	 <input type = "hidden" name = "id" value="<%=bean.getId()%>">
	 	Name: <input type="text" name="name" required value = " <%=bean.getName() %>"><br> <br>
		Email: <input type="email" name="email" required value = " <%=bean.getEmail() %>"><br> <br>
		Address: <input type="text" name="address" required value = " <%=bean.getAddress() %>"><br>
		<br> PhNumber: <input type="text" name="phone" required value = " <%=bean.getMobile() %>"><br>
		<br> Disease: <input type="text" name="disease" required value = " <%=bean.getDisease() %>"><br>
		<br> Gender: <input type = "text" name="gender" required value = " <%=bean.getGender() %>"><br>
		<br> <input type="submit" value="save">&nbsp;&nbsp;&nbsp;<input type = "submit" value="Back">
	<%} %>


	</form>
	</div>
</body>
</html>
</form>
</div>
</body>
</html>