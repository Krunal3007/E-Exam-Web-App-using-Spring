<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Profile</title>
<jsp:include page="AllCss.jsp"></jsp:include>
</head>
<body>


















<div id="pcoded" class="pcoded iscollapsed">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">
			<jsp:include page="StudentHeader.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="StudentSideBar.jsp"></jsp:include>

					<div class="pcoded-content">

						<div class="page-header card">
							<div class="row align-items-end">
								<div class="col-lg-8">
									<div class="page-header-title">
										<i class="feather icon-inbox bg-c-blue"></i>
										<div class="d-inline">
											<h5>Profile</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="admindashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Profile</a></li>
											<li class="breadcrumb-item"><a href="#!">Student</a></li>
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
											<div class="col-sm-12">
												<div class="card">
													<div class="card-header ">
														
														<a href="editstudentprofile?userId=${user.userId }"><button class="btn btn-primary ">Edit</button></a>

													</div>
													<div class="card-block">
														<div class="dt-responsive table-responsive">
															<div id="order-table_wrapper"
																class="dataTables_wrapper dt-bootstrap4">
																<div class="row">
																	<div class="col-xs-12 col-sm-12">
																		<table id="listRoles" class="table table-striped">
																			
																				<tr role="row">
																					<th>User Id</th>
																					<td>${user.userId}</td>
																					</tr>
																					<tr role="row">
																					<th>First Name</th>
																					<td>${user.firstName }</td>
																					</tr>
																					<tr role="row">
																					<th>Email</th>
																					<td>${user.email }</td>
																					</tr>
																					<%-- <tr role="row">
																					<th>Password</th>
																					<td>${user.password }</td>
																					</tr> --%>
																					<tr role="row">
																					<th>Xender</th>
																					<td>${user.xender }</td>
																					</tr>
																					<tr role="row">
																					<th>Phone No</th>
																					<td>${user.phoneNo }</td>
																					</tr>
																					<tr role="row">
																					<th>Address</th>
																					<td>${user.address }</td>
																					</tr>
																					<tr role="row">
																					<th>City</th>
																					<td>${user.city }</td>
																					</tr>
																					<tr role="row">
																					<th>State</th>
																					<td>${user.state }</td>
																					</tr>
																					<tr role="row">
																					<th>Pincode</th>
																					<td>${user.pincode }</td>
																					</tr>
																					
																	

																		</table>
																	</div>
																</div>

															</div>
														</div>
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

		<!-- <script type="text/javascript">
			$(document).ready(function() {
				$('#listRoles').DataTable();
			});
		</script> -->

















</body>
</html>