<%@page import="org.soenea.doitall.domain.model.person.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Browse People</title>
</head>
<body>
<h2>Browse People</h2>
<%
List<Person> people = (List<Person>)request.getAttribute("people");
for(Person person: people) {
%><a href="BuddyAge?command=org.soenea.doitall.application.command.ViewPerson&id=<%= person.getId() %>"><%= person.getName() %></a><br/>
<% } %>
</body>
</html>