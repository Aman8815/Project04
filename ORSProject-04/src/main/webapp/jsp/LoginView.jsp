<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<%@ include file="Header.jsp"%>
		<div align="center">

			<h1 align="center" style="margin-bottom: -15; color: navy">Login</h1>

			<table>
				<tr>
					<th align="left">Login Id<span style="color: red">*</span></th>
					<td align="center"><input type="text" name="login"
						placeholder="Enter Email Id" value=""></td>
				</tr>
				<tr>
					<th align="left">Password<span style="color: red">*</span></th>
					<td align="center"><input type="password" name="password"
						placeholder="Enter Password" value="">
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="signIn"> &nbsp; <input type="submit"
						name="operation" value="signUp"> &nbsp;</td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td><a href="#"><b>Forget my password?</b></a>&nbsp;</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>