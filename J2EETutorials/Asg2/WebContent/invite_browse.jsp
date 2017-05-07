<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper_nav>
<jsp:attribute name="page_title">Browse Groups</jsp:attribute>
<jsp:body>
	<table class="center">
		<thead>
			<tr><th>Sender</th><th>Message</th><th></th><th></th></tr>
		</thead>
		<thead>
			${table_rows}
		</thead>
	</table>
</jsp:body>
</t:wrapper_nav>