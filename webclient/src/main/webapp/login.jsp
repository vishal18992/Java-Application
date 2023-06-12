<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="assets.jsp"%>
<title>Login</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row justify-content-center login"
			style="padding-top: 200px;">
			<div class="col-md-6 col-lg-5">
				<form action="<%request.getContextPath();%> /login" method="post">
					<div class="mb-3">
						<label for="username" class="form-label">Email address</label> <input
							type="email" class="form-control" id="username"
							aria-describedby="usernameHelp" name="username" />
					</div>
					<div class="mb-3" style="margin-bottom: 10px;">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" />
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
					<div class="mt-2">
						<%boolean loginFalg = (boolean) request.getAttribute("login-error");%>
						<%
						if (loginFalg) {
						%>
						<div class="alert alert-danger" role="alert">
							<%="" + request.getAttribute("error-message")%>
						</div>
						<%
						}
						%>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>