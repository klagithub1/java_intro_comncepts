<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_nav>
<jsp:attribute name="page_title">Create Group</jsp:attribute>
<jsp:body>
	<div class="form-wrapper" style="width: 300px">
		${msg_error}
		<form method="post">
			<dl>
				<dt>Name</dt>
				<dd><input type="text" name="name" /></dd>
				<dt>Description (Not used yet)</dt>
				<dd><textarea></textarea></dd>
			</dl>
			<button class="big orange">Create Group</button>
		</form>
	</div>
</jsp:body>
</t:wrapper_nav>