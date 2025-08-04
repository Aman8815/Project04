<%@page import="com.rays.Bean.patientBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Patient Data Entry</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #dff6ff, #bde0fe);
        margin: 0;
        padding: 0;
    }

    .container {
        width: 50%;
        margin: auto;
        margin-top: 50px;
        background-color: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
    }

    h2 {
        color: #0f4d92;
        text-align: center;
    }

    label {
        display: block;
        margin: 15px 0 5px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="email"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #aaa;
        border-radius: 5px;
    }

    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px;
        margin: 20px 10px 0 0;
        border: none;
        border-radius: 5px;
        background-color: #0f6cbf;
        color: white;
        font-weight: bold;
        cursor: pointer;
    }

    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #0c548f;
    }

    .success {
        color: green;
        text-align: center;
    }
</style>
</head>
<body>

<%@ include file="Header.jsp" %>

<div class="container">

<%
    patientBean bean = (patientBean) request.getAttribute("bean");
    String msg = (String) request.getAttribute("msg");
%>

<h2>
    <%= (bean == null) ? "Patient Data Entry Form" : "Patient Data Update Form" %>
</h2>

<% if (msg != null) { %>
    <div class="success"><%= msg %></div>
<% } %>

<form action="AddPatientctl" method="post">
    <% if (bean != null) { %>
        <input type="hidden" name="id" value="<%= bean.getId() %>">
    <% } %>

    <label>Name:</label>
    <input type="text" name="name" required value="<%= (bean != null) ? bean.getName() : "" %>">

    <label>Email:</label>
    <input type="email" name="email" required value="<%= (bean != null) ? bean.getEmail() : "" %>">

    <label>Address:</label>
    <input type="text" name="address" required value="<%= (bean != null) ? bean.getAddress() : "" %>">

    <label>Phone Number:</label>
    <input type="text" name="phone" required value="<%= (bean != null) ? bean.getMobile() : "" %>">

    <label>Disease:</label>
    <input type="text" name="disease" required value="<%= (bean != null) ? bean.getDisease() : "" %>">

    <label>Gender:</label>
    <input type="text" name="gender" required value="<%= (bean != null) ? bean.getGender() : "" %>">
    
    <label>Total:</label>
    <input type="text" name="Total" required value="<%= (bean != null) ? bean.getTotal() : "" %>">
    
    <label>Deposit:</label>
    <input type="text" name="Deposit" required value="<%= (bean != null) ? bean.getDeposit() : "" %>">
    
    <label>Description:</label>
    <textarea type="text" name="Description" required value="<%= (bean != null) ? bean.getDescription() : "" %>"></textarea><br><br>

    <input type="submit" value="<%= (bean == null) ? "Submit" : "Save" %>">
    <input type="reset" value="Reset">
</form>

</div>
</body>
</html>