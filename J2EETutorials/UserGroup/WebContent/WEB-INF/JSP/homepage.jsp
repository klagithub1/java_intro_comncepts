<%@page import="com.domain.User"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" >
<title>User Home Page</title>
</head>

<body>
	<div id="headerBar">
		<p><a href="LogoutController">>X logout</a></p>
		<p>Hello, ${user.username}</p>
	</div>
	<hr />
	<div id ="mainBox">
		<div id="infoBox">
			<table>
				<tr><td>Name: </td><td>${user.firstName}</td></tr>
				<tr><td>Family Name: </td><td>${user.lastName}</td></tr>
				<tr><td>Administrative Privileges: </td><td>${user.admin}</td></tr>
			</table>
		</div>
		<div id="actionsBox">
			<p>${user.firstName}, here are the options you can try:</p>
			<table>
				<tr><td>${(user.admin)?"<a href='adduser.html'>":"<a href='#'>"} Add a new user (admin privileges required)</a></td></tr>
				<tr><td>${(user.admin)?"<a href='removeuser.html'>":"<a href='#'>"} Remove a user (admin privileges required)</a></td></tr>
				<tr><td><a href=""></a></td></tr>
				<tr><td><a href=""></a></td></tr>
				<tr><td><a href=""></a></td></tr>
				<tr><td><a href=""></a></td></tr>
				<tr><td><a href=""></a></td></tr>
			</table>
		</div>
		<div id="copyright">
			<copyright>(C) Klajdi Karanxha, Nicholas SoupHandavong, Kapies Vallipuram, Hussein Rida - SOEN387, Concordia University 2011</copyright>
		</div>
	</div>
</body>
</html>