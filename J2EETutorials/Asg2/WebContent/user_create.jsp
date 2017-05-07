<%@page contentType="text/html"	pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_nav>
<jsp:attribute name="page_title">Create Group</jsp:attribute>
<jsp:body>
	<div class="form-wrapper" style="width: 300px">
		${msg_error}
		<form method="post">
			<dl>
				<dt>Username</dt>
				<dd><input type="text" name="username" value="${username}" /></dd>
				<dt>Password</dt>
				<dd><input type="password" name="password" /></dd>
				<dt>First Name</dt>
				<dd><input type="text" name="first_name" value="${first_name}" /></dd>
				<dt>Last Name</dt>
				<dd><input type="text" name="last_name" value="${last_name}" /></dd>
				<dt>Admin <input type="checkbox" name="admin"></dt>
			</dl>
			<input type="submit" class="big orange" value ="Create User">
		</form>
	</div>
</jsp:body>
</t:wrapper_nav>