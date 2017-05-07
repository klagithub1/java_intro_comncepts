<html>
<head>
	<title>Browse Groups</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>  
</head>
<body>
	<div class="top">
		<ul>
			<li>Welcome, ${name}</li>
			<li><a href="logout.jsp">Log out</a></li>
		</ul>
	</div>
	<nav>
		<ul>
			<li><a href="group_browse.jsp">Browse Groups</a></li>
			<li><a href="group_create.jsp">Create Group</a></li>
			<li><a href="group_manage.jsp">Manage Group</a></li>
			<li><a href="group_invite.jsp">Invite Member</a></li>
			<li class="active"><a href="invite_browse.jsp">Browse Invites</a></li>
			<li><a href="user_create.jsp">Create User</a></li>
		</ul>
	</nav>
	<div class="content">
		<div class="form-wrapper">
			<dl>
				<dt>From: ${group_name}<dt>
				<dt>Message</dt>
				<dd>${message}</dd>
			</dl>
			<form method="post">
				<input type="hidden" name="accept" value="1">
				<button onclick="submit()">Accept</button>
			</form>
			<form method="post">
				<input type="hidden" name="accept" value="0">
				<button onclick="submit()">Decline</button>
			</form>
		</div>
	</div>
</body>
</html>