<%@page import="com.rays.Bean.doctorBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<hr>
<form action="DoctorListCtl" method = "post">
	<table border="1" width="100%" align="center" cellpadding=6px
		cellspacing=".2">
	<div align="center">	
	<h2 style ="color:red">Doctor_List</h2>
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
			<th>Email</th>
			<th>mobile_number</th>
			<th>specility</th>
			<th>Address</th>
			<th>Gender</th>
			<th>WorkDay</th>
			<th>Edit</th>
			<th>SEE_Patient</th>
		</tr>
		
		 <%   
		 
		    List list =  (List) request.getAttribute("list"); 
		     
		   Iterator<doctorBean> it = list.iterator();
		   
		   while(it.hasNext()){
			   doctorBean bean = (doctorBean) it.next();
		    	
		 %>
		 
		 <tr style = "background-color:white">
		 <td><input type = "checkbox" class="checkbox" name="ids" value="<%=bean.getId() %>"></td>
   <td><%=bean.getId() %></td>
   <td><%=bean.getName() %></td>
   <td><%=bean.getEmail() %></td>
   <td><%=bean.getPhone()%></td>
   <td><%=bean.getSpecility() %></td>
   <td><%=bean.getAddress() %></td>
   <td><%=bean.getGender() %></td>
   <td><%=bean.getWorkday() %></td>
  <td><a href="AddDoctorctl?id=<%=bean.getId()%>">Edit</a></td>
  <td><a href="patiendListctl?specility=<%=bean.getSpecility()%>">See</a></td>
		<%} %> 
		 
		
		</table>
	<table width="100%">
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="delete"></td>
				
					<td><input type="submit" name="operation"
						value="new"></td>

				</tr>
			</table>		
		
		</form>
</body>
</html>