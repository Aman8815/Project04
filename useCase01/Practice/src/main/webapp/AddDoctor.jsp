<%@page import="com.rays.Bean.doctorBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddDoctorFile</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<hr>
 <form action="AddDoctorctl" method = "post">
<table  width="50%" align="center" cellpadding=6px
		cellspacing=".2">
	<div align="center">	
	
	<% 
        doctorBean bean = (doctorBean)request.getAttribute("bean");
     
     if(bean== null){
     %>
	<h2 ><span style="color:red;">Doctor Data Entry Form</span></h2>
	
	<%  String msg = (String)request.getAttribute("msg");
	     if(msg!=null){
	   %><h2><span style="color:green;"><%= msg%></span></h2> <br><br>
	   
	   
	   <%}%>
	 Name: <input type="text" name="name" required ><br> <br>
		Email: <input type="email" name="email" required ><br>
		<br> Ph.Number: <input type="text" name="phone" required><br>
		<br> Specility: <input type="text" name="specility" required ><br>
		<br> Address: <input type="text" name="address" required ><br>
		<br> Gender: <input type = "text" name="gender" required><br>
		<br> WorkDay: <input type = "text" name = "workday" required><br>
		<br> <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;<input type = "reset" value="reset">
	<% }else{ %>
	    <h2>Update Doctor Data </h2>
	    <input type = "hidden" name = "id" value="<%=bean.getId()%>">
 Name: <input type="text" name="name" required  value = "<%=bean.getName()%>"><br> <br>
		Email: <input type="email" name="email" required value = "<%=bean.getEmail()%>" ><br>
		<br> Ph.Number: <input type="text" name="phone" required value = "<%=bean.getPhone()%>"><br>
		<br> Specility: <input type="text" name="specility" required value = "<%=bean.getSpecility()%>" ><br>
		<br> Address: <input type="text" name="address" required value = "<%=bean.getAddress()%>" ><br>
		<br> Gender: <input type = "text" name="gender" required  value = "<%=bean.getGender()%>"><br>
		<br> WorkDay: <input type = "text" name = "workday" required value = "<%=bean.getWorkday()%>" ><br>
		<br> <input type="submit" value="Submit">&nbsp;&nbsp;&nbsp;<input type = "reset" value="reset">
		<%} %>
		</div>
	</table>	
	</form>
</body>
</html>