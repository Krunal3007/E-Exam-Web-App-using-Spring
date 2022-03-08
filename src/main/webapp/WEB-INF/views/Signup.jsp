<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">




<meta charset="utf-8">
	<meta name="author" content="Muhamad Nauval Azhar">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta name="description" content="This is a login page template based on Bootstrap 5">
	<title>SignUp</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

	<jsp:include page="AllCss.jsp"></jsp:include>
	







</head>
<body>
<!-- <h2>SignUp</h2>
<form action="signupsaveuser" method="post">
	First Name:<input type="text" name="signupFirstName"> <br><br>
	Email :<input type="email" name="signupEmail"> <br><br>
	Password :<input type="password" name="signupPassword"> <br><br>
	
	<input type="submit" value="Submit">

</form>

<a href="login">Login</a> -->










<section class="h-100 bg-info">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-5 col-xl-6 col-lg-6 col-md-8 col-sm-10" style="margin-top:60px;">
					<div class="text-center my-5">
						<h1 class="bg-white text-info card shadow-lg">E-Exam</h1>
					</div>
					<div class="card shadow-lg">
						<div class="card-body p-5">
							<h1 class="fs-4 card-title fw-bold mb-4 text-dark">Sign Up</h1>
							<form method="post" action="signupsaveuser" class="needs-validation"  autocomplete="on">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="name">First Name</label>
									<input id="name" type="text" class="form-control" name="signupFirstName" value="" required autofocus>
									<div class="invalid-feedback">
										Name is required	
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">Email</label>
									<input id="email" type="email" class="form-control" name="signupPassword" value="" required>
									<div class="invalid-feedback">
										Email is invalid
									</div>
								</div>

								<div class="mb-3">
									<label class="mb-2 text-muted" for="password">Password</label>
									<input id="password" type="password" class="form-control" name="password" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								<p class="form-text text-muted mb-3">
									By registering you agree with our terms and condition.
								</p>

								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-primary ms-auto">
										Register	
									</button>
								</div>
							</form>
						</div>
						<div class="card-footer py-3 border-0">
							<div class="text-center text-dark">
								Already have an account? <a href="login" class="text-primary">Login</a>
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