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
	<title>Login</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<jsp:include page="AllCss.jsp"></jsp:include>



</head>
<body>








<section class="h-100 " style="background-color: rgb(8, 82, 82)">
		<div class="container h-100 ">
			<div class="row justify-content-sm-center h-100 ">
			
				<div class="col-xxl-5 col-xl-6 col-lg-6 col-md-8 col-sm10 " style="margin-top:67px">    <!-- 67 -->
				
					<div class="text-center my-5 ">
						<h1 class="bg-white text-info card shadow-lg">E-Exam</h1>
					</div>
					<div class="card shadow-lg" style="background-color: #CCE5FF">
						<div class="card-body p-5" >
							<h1 class="fs-4 card-title fw-bold mb-4 text-dark">Sign In</h1>
							
							<form method="post" action="login" class="needs-validation"  autocomplete="on">
								<div class="mb-3">
									<label class="mb-2 text-muted" for="email">Email</label>
									<input id="email" type="email" class="form-control" name="loginEmail" value="" required autofocus>
									<div class="invalid-feedback">
										 Email is invalid 
									</div>
								</div>

								<div class="mb-3">
									<div class="mb-2 w-100">
										<label class="text-muted" for="password">Password</label>
										<a href="forgetpassword" class="float-end text-primary">
											Forgot Password?
										</a>
									</div>
									<input id="password" type="password" class="form-control" name="loginPassword" required>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>
								&nbsp;&nbsp;
								<div class="d-flex align-items-center">
									<div class="form-check">
										<input type="checkbox" name="remember" id="remember" class="form-check-input">
										<label for="remember" class="form-check-label text-dark">Remember Me</label>
									</div>
									<button type="submit" class="btn btn-primary ms-auto">
										Login
									</button>
								</div>
							</form>
						</div>
						<h5 class="text-danger text-center">${error} ${msg}</h5>
						<div class="card-footer py-3 border-0 ">
							<div class="text-center text-dark">
								Don't have an account? <a href="signup" class="text-primary">Create One</a>
								
							</div>
							&nbsp;&nbsp;
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<!-- <div class="bg-primary">
		.
		</div> -->
	</section>

	<script src="js/login.js"></script>



<jsp:include page="AllJs.jsp"></jsp:include>
















</body>
</html>