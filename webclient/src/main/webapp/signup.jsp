<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="assets.jsp"%>
<title>SignUp</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<main>

		<div class="container py-4">
		
			<!-- Bootstrap 5 starter form -->
			<form id="contactForm"
				action="<% request.getContextPath(); %> /signup" method="post">
				
				
				<!-- Email address input -->
                <div class="mb-3">
                    <label class="form-label" for="emailAddress">Your Email</label>
                    <input class="form-control" id="emailAddress" type="email"
                        name="email" placeholder="Email Address" />
                </div>

				<!-- Name input -->
				<div class="mb-3">
					<label class="form-label" for="name">Your Name</label> <input
						class="form-control" id="name" name="name" type="text"
						placeholder="Name" />
				</div>

				

				<!-- Message input -->
				<div class="mb-3">
					<label class="form-label" for="password">Password</label>
					<input class="form-control" id="password" type="password"
						placeholder="Password" style="height: 10rem;" name="password"></input>
				</div>
				
				
				<div class="mb-3">
                    <label class="form-label" for="confirm_password">Confirm Password</label>
                    <input class="form-control" id="confirm_password" type="password"
                        placeholder="Password" style="height: 10rem;"></input>
                </div>

				<!-- Form submit button -->
				<div class="d-grid">
					<button class="btn btn-primary btn-lg" type="submit">Submit</button>
				</div>

			</form>
		</div>
	</main>
</body>
</html>