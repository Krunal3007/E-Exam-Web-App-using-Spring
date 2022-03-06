<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<jsp:include page="AllCss.jsp"></jsp:include>
</head>
<body>
















<div id="pcoded" class="pcoded iscollapsed">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">
			<jsp:include page="AdminHeader.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="AdminSideBar.jsp"></jsp:include>

					<div class="pcoded-content">

						<div class="page-header card">
							<div class="row align-items-end">
								<div class="col-lg-8">
									<div class="page-header-title">
										<i class="feather icon-inbox bg-c-blue"></i>
										<div class="d-inline">
											<h5>Update User</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="admindashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Users</a></li>
											<li class="breadcrumb-item"><a href="#!">Edit User</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>

						<div class="pcoded-inner-content">

							<div class="main-body">
								<div class="page-wrapper">

									<div class="page-body">
										<div class="row">
											<div class="col-sm-8">
												<div class="card">
													<div class="card-header">
														<h5>Update User</h5>
													</div>
													<div class="card-block">
														
																				
														
						
														<form action="updateuser" method="post">


															<div class="form-group row">
																<label class="col-sm-2 col-form-label">User Id</label>
																<div class="col-sm-10">
																	<input type="number" name="userId" class="form-control" value="${user.userId}" readonly>
																</div>
															</div>
															
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">User Name</label>
																<div class="col-sm-10">
																	<input type="text" name="firstName" class="form-control" value="${user.firstName}" >
																</div>
															</div>
															

															 <div class="form-group row">
																<label class="col-sm-2 col-form-label">Email</label>
																<div class="col-sm-10">
																	<input type="email" name="email" class="form-control" value="${user.email}" >
																</div>
															</div>
															
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Password</label>
																<div class="col-sm-10">
																	<input type="password" name="password" class="form-control" value="${user.password}" readonly>
																</div>
															</div>
															
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Phone No</label>
																<div class="col-sm-10">
																	<input type="number" name="phoneNo" class="form-control" value="${user.phoneNo}" >
																</div>
															</div>
															
														
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Address</label>
																<div class="col-sm-10">
																	<textarea name="address" rows="5" cols="5"
																		class="form-control" placeholder="Write Here">${user.address}</textarea>
																</div>
															</div>
															
															
															
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">City</label>
																<div class="col-sm-10">
																	<input type="text" name="city" class="form-control" value="${user.city}" >
																</div>
															</div>
															
															
															
															

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">State</label>
																<div class="col-sm-10">
																	<input type="text" name="state" class="form-control" value="${user.state}" >
																</div>
															</div>
															
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Pincode</label>
																<div class="col-sm-10">
																	<input type="number" name="pincode" class="form-control" value="${user.pincode}" >
																</div>
															</div>
															
															

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Is Active</label>
																<div class="col-sm-10">
																	<input type="number" name="isActive" class="form-control" value="${user.isActive}" >
																</div>
															</div>
															
															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Role</label>
																<div class="col-sm-10">
																	<input type="text" name="roleName" class="form-control" value="${user.roleName}" readonly>
																</div>
															</div>
												

																			
														<input type="submit" class="btn btn-primary" value="Update User"/>
														<input type="reset" class="btn btn-danger" value="Clear"/>


														</form>


													</div>
												</div>
											</div>
										</div>

									</div>
								</div>

								<div id="styleSelector"></div>
							</div>
						</div>


					</div>
					<!-- pcoded wrapper -->
				</div>
				<!-- pcoded main container -->
			</div>
			<!-- pcoded-navwrap -->
		</div>
		<!--  pcoded -->



		<jsp:include page="AllJs.jsp"></jsp:include>

		<script type="text/javascript">
			$(document).ready(function() {
				$('#listRoles').DataTable();
			});
		</script>


















</body>
</html>