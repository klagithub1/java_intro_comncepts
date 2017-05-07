<%@tag description="Navigation Wrapper Tag" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="page_title" required="true"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<html>
<head>
	<title>${page_title}</title>
	<base href="${fn:replace(req.requestURL, fn:substring(uri, 1, fn:length(uri)), req.contextPath)}" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
</head>
<body>
	<div class="top">
		<ul>
			<li>Welcome, ${user_first_name}</li>
			<li><a href="/logout">Log out</a></li>
		</ul>
	</div>
	<nav>
		<ul>
			<li><a href="/group/browse">Browse Groups</a></li>
			<li><a href="/group/create">Create Group</a></li>
			<li><a href="/group/manage">Manage Group</a></li>
			<li><a href="/group/invite">Invite Member</a></li>
			<li><a href="/invite">Browse Invites</a></li>
			<li><a href="/admin/user/create">Create User</a></li>
		</ul>
	</nav>
	<div class="content">
<jsp:doBody/>
	</div>
</body>
</html>