<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Users</title>
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
											<h5>Report Users</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="admindashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Report</a></li>
											<li class="breadcrumb-item"><a href="#!">User</a></li>
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
														<button type="button" class="btn btn-primary"
																data-toggle="modal" data-target="#exampleModal">
																Role</button>

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
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Gender</th>
<th>Phone No</th>
<th>Address</th>
<th>City</th>
<th>State</th>
<th>Pincode</th>
<th>Role</th>
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
 <td><a href="deleteuser/${u.userId}"><button class="btn btn-primary btn-sm">Delete</button></a> 
 	<a href="edituser?userId=${u.userId }"><button class="btn btn-primary btn-sm">Edit</button></a>
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


		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Report -
							User - Role</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="userreport" method="get">
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Select Role </label>
								<div class="col-sm-10">
									<select name="roleId" class="form-control">

										<c:forEach items="${roles}" var="r">
											<option value="${r.roleId}">${r.roleName}</option>
										</c:forEach>

									</select>
								</div>
							</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Generate</button>
					</div>
					</form>
				</div>
			</div>
		</div>














</body>
</html>