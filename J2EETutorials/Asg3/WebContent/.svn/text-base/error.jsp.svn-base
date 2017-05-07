<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Error</title>
</head>
<body>
<h1>An internal error has occurred.</h1>
<p>Communicate the following information to your system
administrator:</p>
<c:if test="${!empty errorMessage}">
	<h3>${errorMessage}</h3>
</c:if>
<c:if test="${!empty warning}">
	<h3>${warning}</h3>
</c:if>
<h3>${pageContext.exception.message}</h3>
<pre>
  <c:forEach var="frame" items="${pageContext.exception.stackTrace}">${frame}
  </c:forEach>
</pre>
</body>
</html>
