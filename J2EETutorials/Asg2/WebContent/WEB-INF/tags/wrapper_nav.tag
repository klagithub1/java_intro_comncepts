<%@tag description="Navigation Wrapper Tag" pageEncoding="UTF-8"%>
<%@tag import="service.Constants" %>
<%@attribute name="page_title" required="true"%>
<html>
<head>
	<title>${page_title}</title>
	<link rel="stylesheet" href="<%=Constants.baseUrl%>/css/style.css" type="text/css" media="all"/>  
</head>
<body>
	<div class="top">
		<ul>
			<li>Welcome, ${user_first_name}</li>
			<li><a href="<%=Constants.baseUrl%>/logout">Log out</a></li>
		</ul>
	</div>
	<nav>
		<ul>
			<li><a href="<%=Constants.baseUrl%>/group/browse">Browse Groups</a></li>
			<li><a href="<%=Constants.baseUrl%>/group/create">Create Group</a></li>
			<li><a href="<%=Constants.baseUrl%>/group/manage">Manage Group</a></li>
			<li><a href="<%=Constants.baseUrl%>/group/invite">Invite Member</a></li>
			<li><a href="<%=Constants.baseUrl%>/invite">Browse Invites</a></li>
			<li><a href="<%=Constants.baseUrl%>/admin/user/create">Create User</a></li>
		</ul>
	</nav>
	<div class="content">
<jsp:doBody/>
	</div>
</body>
</html>