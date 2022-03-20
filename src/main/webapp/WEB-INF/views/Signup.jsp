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








<section class="h-100 " style="background-color: rgb(8, 82, 82)">
		<div class="container h-100">
			<div class="row justify-content-sm-center h-100">
				<div class="col-xxl-5 col-xl-8 col-lg-8 col-md-8 col-sm-10" style="margin-top:10px;">    <!-- 10 -->
					<div class="text-center my-1">
						<h2 class="bg-white text-info card shadow">E-Exam</h2>
					</div>
					<div class="card shadow-lg" style="background-color: #CCE5FF">
						<div class="card-body my-2">
							<h1 class="fs-4 card-title fw-bold mb-4 text-dark">Sign Up</h1>
							<form method="post" action="signupsaveuser" class="needs-validation"  autocomplete="on">
							<div class="row">
								<div class="col-md-6">
									<label class="text-muted " for="name">First Name</label>
									<input id="name" type="text" class="form-control form-control-sm" name="signupFirstName" value="" required autofocus>
									<div class="invalid-feedback">
										Name is required	
									</div>
								</div>

								<div class="col-md-6">
									<label class="text-muted" for="email">Email</label>
									<input id="email" type="email" class="form-control form-control-sm" name="signupEmail" value="" required>
									<div class="invalid-feedback">
										Email is invalid
									</div>
								</div>
								</div>
									
								<div class="row">
								<div class="col-md-6 mt-2">
									<label class="text-muted" for="password">Password</label>
									<input id="password" type="password" class="form-control form-control-sm" name="signupPassword" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>
								
								<div class="col-md-6 mt-2">
									<label class="text-muted" for="gender">Select Gender</label>
									<select id="gender" name="signupGender" class="form-control form-control-sm" required="required">
	
																		<option value="">Select</option>
																		<option value="Male">Male</option>
																		<option value="Female">Female</option>

																</select>
									
								    <div class="invalid-feedback">
								    	Gender is required
							    	</div>
								</div>
								</div>
								
								
								
								<div class="mt-2">
									<label class="text-muted" for="signupAddress">Address</label>
									<textarea id="signupAddress" name="signupAddress" rows="2" cols="2" class="form-control bg-white form-control-sm" placeholder="Write Here" required="required"></textarea>
								    <div class="invalid-feedback">
								    	Address is required
							    	</div>
								</div>
								
								<div class="row">
								<div class="col-md-6 mt-2">
									<label class="text-muted" for="signupPhoneNo">Phone No</label>
									<input id="signupPhoneNo" type="text" class="form-control form-control-sm" name="signupPhoneNo" required>
								    <div class="invalid-feedback">
								    	Phone No is required
							    	</div>
								</div>
								
								<div class="col-md-6 mt-2">
									<label class="text-muted" for="signupCity">City</label>
									<input id="signupCity" type="text" class="form-control form-control-sm" name="signupCity" required>
								    <div class="invalid-feedback">
								    	City is required
							    	</div>
								</div>
								</div>
								
								<div class="row">
								<div class="col-md-6 mt-2">
									<label class="text-muted" for="signupState">State</label>
									<input id="signupState" type="text" class="form-control form-control-sm" name="signupState" required>
								    <div class="invalid-feedback">
								    	State is required
							    	</div>
								</div>
								
								<div class="col-md-6 mt-2">
									<label class="text-muted" for="signupPincode">Pincode</label>
									<input id="signupPincode" type="text" class="form-control form-control-sm" name="signupPincode" required>
								    <div class="invalid-feedback">
								    	Pincode is required
							    	</div>
								</div>
								</div>

								<p class="form-text text-muted h6">
									By registering you agree with our terms and condition.
								</p>

								<div class="align-items-center d-flex">
									<button type="submit" class="btn btn-primary ms-auto" style="font-size: 14px">
										Register	
									</button>
								</div>
							</form>
						</div>
						<div class="card-footer  border-0">
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