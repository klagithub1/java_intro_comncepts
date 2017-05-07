<%@page contentType="text/html"	pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_centered>
<div class="login">
	${msg_error}
	<form method="post">
		<dl>
			<dt>Username</dt>
			<dd><input type="text" name="username" value="${username}" /></dd>
			<dt>Password</dt>
			<dd><input type="password" name="password" /></dd>
		</dl>
		<input type="submit" class="big orange" value="Log In">
	</form>
</div>
</t:wrapper_centered>
