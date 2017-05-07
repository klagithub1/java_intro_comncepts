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
			<li class="active"><a href="group_manage.jsp">Manage Group</a></li>
			<li><a href="group_invite.jsp">Invite Member</a></li>
			<li><a href="invite_browse.jsp">Browse Invites</a></li>
			<li><a href="user_create.jsp">Create User</a></li>
		</ul>
	</nav>
	<div class="content">
		<h2>Description</h2>
		<textarea>${description}</textarea>
		<button onclick="submit">Submit changes</button>
		<h2>Members</h2>
		<table class="center">
			<thead>
				<tr><th>Name</th><th>Action</th></tr>
			</thead>
			<thead>
				<tr><td>Some Guy</td><td><button class="red">Kick</button></td></tr>
			</thead>
		</table>
		<h2>Other</h2>
		<button class="red">Disband Group</button>
	</div>
</body>
</html>