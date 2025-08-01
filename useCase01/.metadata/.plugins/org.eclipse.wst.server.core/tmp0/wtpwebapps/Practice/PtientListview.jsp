<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.rays.Bean.patientBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient_list_view</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<hr>
<form action="patiendListctl" method = "post">
	<table border="1" width="100%" align="center" cellpadding=6px
		cellspacing=".2">
	<div align="center">	
	<h2 style ="color:red">Patient_List</h2>
	<%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
%>
    <h2 style="color: green;" ><%= msg %></h2>
<%
        session.removeAttribute("msg"); // ek baar show karne ke baad hata do
    }
%>
</div>
<tr style = "background-color:yellow">
             <th>select</th>
			<th>Id</th>
			<th>Name</th>
			<th>mobile_number</th>
			<th>Email</th>
			<th>disease</th>
			<th>Address</th>
			<th>Gender</th>
			<th>Edit</th>
		</tr>
		
		 <%   
		 
		    List list =  (List) request.getAttribute("list"); 
		     
		   Iterator<patientBean> it = list.iterator();
		   
		   while(it.hasNext()){
		    	patientBean bean = (patientBean) it.next();
		    	
		 %>
		 
		 <tr style = "background-color:white">
		 <td><input type = "checkbox" class="checkbox" name="ids" value="<%=bean.getId() %>"></td>
   <td><%=bean.getId() %></td>
   <td><%=bean.getName() %></td>
   <td><%=bean.getMobile()%></td>
   <td><%=bean.getEmail() %></td>
   <td><%=bean.getDisease() %></td>
   <td><%=bean.getAddress() %></td>
   <td><%=bean.getGender() %></td>
  <td><a href="AddPatientctl?id=<%=bean.getId()%>">Edit</a></td>
		<%} %> 
		 
		
		</table>
	<table width="100%">
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="delete"></td>
				
					<td><input type="submit" name="operation"
						value="new"></td>
                     <td><input type = "submit" name="operation" value="Back"></td>
				</tr>
			</table>		
		
		</form>
	
</body>
</html>