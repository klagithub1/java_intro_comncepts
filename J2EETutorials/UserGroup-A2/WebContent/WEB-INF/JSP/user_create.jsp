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
			<li><a href="invite_browse.jsp">Browse Invites</a></li>
			<li class="active"><a href="user_create.jsp">Create User</a></li>
		</ul>
	</nav>
	<div class="content">
		<div class="form-wrapper" style="width: 300px">
			<form method="post">
				<dl>
					<dt>Username</dt>
					<dd><input type="text" name="name" /></dd>
					<dt>Password</dt>
					<dd><input type="password" name="name" /></dd>
				</dl>
				<button class="big orange" onclick="submit()">Create User</button>
			</form>
		</div>
	</div>
</body>
</html>