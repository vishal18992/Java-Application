<%@ page session="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header>
    <%
    String login = null;
    if(request.getSession().getAttribute("current-user") == null){
    	response.sendRedirect(request.getContextPath() + "/login");
    }else{
    	login = request.getSession().getAttribute("current-user").toString();
    }
    %>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="nav-header" style="margin-left: 15px;">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="/home">
					    Home
					</a>
				</li>
				<li class="nav-item">
				    <a class="nav-link" href="/contactus">Contact Us</a>
				</li>
			</ul>
			<div class="collapse navbar-collapse justify-content-end" style="margin-right: 15px;">
			
				<ul class="navbar-nav navbar-nav-right">
				<% if(login!=null){%>
					<li class="nav-item">
	                    <a class="nav-link" href="/profile">
	                        <span class="glyphicon glyphicon-log-in"></span> Profile
	                    </a>
	                 </li>
	                 <li class="nav-item">
                        <a class="nav-link" href="/logout">
                            <span class="glyphicon glyphicon-log-in"></span> Logout
                        </a>
                     </li>
				
				<%}else{%>
				    <li class="nav-item">
                        <a class="nav-link" href="/signup">
                            <span class="glyphicon glyphicon-user fontawesome-lock"></span>
                            Sign Up
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">
                            <span class="glyphicon glyphicon-log-in"></span> Login
                        </a>
                    </li>
				<%}%>
	            </ul>
	       </div>
		</div>
	</nav>
</header>