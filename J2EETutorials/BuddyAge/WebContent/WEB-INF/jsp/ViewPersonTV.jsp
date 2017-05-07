<%@page import="org.soenea.doitall.domain.model.person.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Person</title>
</head>
<body>
<h2>View Person</h2>
<%
Person person = (Person)request.getAttribute("person");
String warning = (String)request.getAttribute("warning");
%>
<% if(warning != null) { %><b>Warning: </b> <%=warning %><br/> <% } %>
<%= person.getName() %> is <%= person.getAge() %> years old.<br/>
<a href="BuddyAge?command=org.soenea.doitall.application.command.IncreaseAge&id=<%= person.getId() %>&version=<%= person.getVersion() %>">Make <%= person.getName() %> older!</a><br/><br/>

<a href="BuddyAge?command=org.soenea.doitall.application.command.BrowsePeople">Browse More People</a><br/>
</body>
</html>