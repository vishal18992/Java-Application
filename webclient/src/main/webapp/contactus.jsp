<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="assets.jsp"%>
<title>ContactUs</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- Wrapper container -->
	<main>
		<div class="container py-4">

			<div class="row">
				<div class="col-md5">
					<h1>Contact us</h1>
				</div>
			</div>
			<!-- Bootstrap 5 starter form -->
			<form id="contactForm"
				action="<% request.getContextPath(); %> /contactus" method="post">

				<!-- Name input -->
				<div class="mb-3">
					<label class="form-label" for="name">Name</label> <input
						class="form-control" id="name" name="name" type="text"
						placeholder="Name" />
				</div>

				<!-- Email address input -->
				<div class="mb-3">
					<label class="form-label" for="emailAddress">Email Address</label>
					<input class="form-control" id="emailAddress" type="email"
						name="email" placeholder="Email Address" />
				</div>

				<!-- Message input -->
				<div class="mb-3">
					<label class="form-label" for="message">Message</label>
					<textarea class="form-control" id="message" type="text"
						placeholder="Message" style="height: 10rem;" name="description"></textarea>
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