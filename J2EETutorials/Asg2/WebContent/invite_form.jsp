<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_nav>
<jsp:attribute name="page_title">Invite User</jsp:attribute>
<jsp:body>
	<div class="form-wrapper">
		${msg_error}
		<form method="post">
		<dl>
			<dt>Invitation To: ${recipient}</dt>
			<dt>Message</dt>
			<dd><textarea name="message">${message}</textarea></dd>
		</dl>
		<Input type="hidden" name="recipient_id" value="${recipient_id}">
		<Input type="submit" class="big orange" value="Send">
		</form>
	</div>
</jsp:body>
</t:wrapper_nav>