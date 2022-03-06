<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Exams</title>
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
											<h5>List Exams</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="admindashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Exams</a></li>
											<li class="breadcrumb-item"><a href="#!">List</a></li>
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
														
														<a href="newexam"><button class="btn btn-primary">Add Exam</button></a>	

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
																					
<th>Exam Id</th>
<th>Course Name</th>
<th>Duration</th>
<th>Instructions</th>


<th>Exams</th>
<th>Action</th>

<th>Information</th>
																				</tr>
																			</thead>
																			<tbody>


<c:forEach items="${exams }" var="e">
<tr>

<td>${e.examId }</td>
<td><a>${e.courseName }</a></td>
<td>${e.duration }</td>
<td>${e.instructions }</td>


<td><a href="showexamquestions?courseId=${e.courseId }"><button class="btn btn-primary btn-sm">Exam Questions</button></a></td>
<td><a href="deleteexam/${e.examId }"><button class="btn btn-primary btn-sm">Delete</button></a> 
	<a href="editexam?examId=${e.examId }"><button class="btn btn-primary btn-sm">Edit</button></a> 
	
	
</td>

<td><a href="showallexamquestions?courseId=${e.courseId}"><button class="btn btn-primary btn-sm">All Questions</button></a>  
	Total Questions : <button class="btn btn-primary btn-sm">${e.noOfQuestion }</button> 
	Total Marks : <button class="btn btn-primary btn-sm">${e.totalMarks }</button>
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











