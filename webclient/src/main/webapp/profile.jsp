<%@ page session="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="assets.jsp"%>
<title>Profile -</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<% if(login == null){ %>
	<h2>Welcome</h2>
	<%}else{%>
	<h2>
		Welcome
		<%= login %></h2>
	<%}%>
</body>
</html>