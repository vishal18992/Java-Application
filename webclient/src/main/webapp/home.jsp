<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="assets.jsp"%>
<title>Home</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container-fulid">
		<div class="row">
			<div class="alert alert-info" role="alert">
				<div class="col-md-12">
					<div class="login-status">
						<%
						if (login != null) {
						%>
						<strong>Welcome - <%=login%></strong>
						<%} else {%>
						<strong>Welcome Home</strong>
						<%}%>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>