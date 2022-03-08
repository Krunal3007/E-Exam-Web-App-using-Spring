<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">




<meta charset="utf-8">
	<meta name="author" content="Muhamad Nauval Azhar">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta name="description" content="This is a login page template based on Bootstrap 5">
	<title>New Password</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

	<jsp:include page="AllCss.jsp"></jsp:include>



</head>
<body>

<%-- <form action="updatepassword" method="post">

Email : <input type="email" name="loginEmail">
Otp : <input type="text" name="otp">
Password : <input type="password" name="loginPassword">
Confirm Password : <input type="password" name="confirmPassword">

<input type="submit" value="Update Password">

</form>

${error} ${msg}


 --%>









<section class="h-100 bg-info">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-5 col-xl-6 col-lg-6 col-md-8 col-sm-10" style="margin-top:60px;">
					<div class="text-center my-5">
						<h1 class="bg-white text-info card shadow-lg">E-Exam</h1>
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4 text-dark">Change Password</h1>
							<form method="post" action="updatepassword" class="needs-validation"  autocomplete="on">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="name">Enter Email</label>
									<input id="name" type="email" class="form-control" name="loginEmail" value="" required autofocus>
									<div class="invalid-feedback">
										Name is required	
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">Enter Otp</label>
									<input id="email" type="number" class="form-control" name="otp" value="" required>
									<div class="invalid-feedback">
										Email is invalid
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="password">Enter Password</label>
									<input id="password" type="password" class="form-control" name="loginPassword" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>
								
								<div class="mb-3">
									<label class="mb-2 text-muted" for="password">Confirm Password</label>
									<input id="password" type="password" class="form-control" name="confirmPassword" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								

								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-primary ms-auto">
										Update	
									</button>
								</div>
							</form>
						</div>
						<h5 class="text-danger text-center">${error} ${msg}</h5>
						<div class="card-footer py-3 border-0">
							<div class="text-center text-dark">
								Back to <a href="login" class="text-primary">Login</a>&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;
								<a href="forgetpassword" class="text-primary">Resend Otp</a>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</section>

	<script src="js/login.js"></script>



	<jsp:include page="AllJs.jsp"></jsp:include>
















</body>
</html>