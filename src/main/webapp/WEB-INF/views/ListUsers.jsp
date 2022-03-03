<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
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
											<h5>List Courses</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="index.html"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Bootstrap
													Table</a></li>
											<li class="breadcrumb-item"><a href="#!">Basic
													Initialization</a></li>
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
													<div class="card-header">
														
														<a href="newuser"><button class="btn btn-primary">Add User</button></a>

													</div>
													<div class="card-block">
														<div class="dt-responsive table-responsive">
															<div id="order-table_wrapper"
																class="dataTables_wrapper dt-bootstrap4">
																<div class="row">
																	<div class="col-xs-12 col-sm-12">
																		<table id="listRoles" class="table table-striped">
																			<thead>
																				<tr role="row">
																					<th>User Id</th>
<th>First Name</th>
<th>Email</th>
<th>Password</th>
<th>Xender</th>
<th>Phone No</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Pincode</th>
<th>RoleName</th>
<th>Action</th>
																				</tr>
																			</thead>
																			<tbody>


																			<c:forEach items="${users}" var="u">
 
 <tr>
 <td>${u.userId}</td>
 <td>${u.firstName }</td>
 <td>${u.email }</td>
 <td>${u.password }</td>
 <td>${u.xender }</td>
 <td>${u.phoneNo }</td>
 <td>${u.address }</td>
 <td>${u.city }</td>
 <td>${u.state }</td>
 <td>${u.pincode }</td>
 <td>${u.roleName }</td>
 <td><a href="deleteuser/${u.userId}">Delete</a> | 
 	<a href="edituser?userId=${u.userId }">Edit</a>
 </td>
 
 </tr>
 
 </c:forEach>



																			</tbody>

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

		<script type="text/javascript">
			$(document).ready(function() {
				$('#listRoles').DataTable();
			});
		</script>

















</body>
</html>