<%@page contentType="text/html"	pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_nav>
<jsp:attribute name="page_title">Create Group</jsp:attribute>
<jsp:body>
	<h2>Name</h2>
	<form method="post" action="./rename">
		<input type="text" name="name" value="${group_name}">
		<input type="submit" value="Change Name" />
	</form>
	
	<h2>Members</h2>
	<form method="post" action="./kick">
	<table class="center">
		<thead>
			<tr><th>Username</th><th>Name</th><th>Action</th></tr>
		</thead>
		<tbody>${table_rows_members}</tbody>
	</table>
	<input type="hidden" name="user_id" id="kick_id">
	</form>
	
	<h2>Other</h2>
	<form method="post" action="./disband">
		<input type="submit" value="Disband Group">
	</form>
</jsp:body>
</t:wrapper_nav>