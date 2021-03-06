<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result</title>
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
											<h4>Your Result</h4>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="studentdashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Result</a></li>
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
														
														<button  class="btn btn-primary" onclick="exportPdf()">Export</button>
														<td><a href="resultdetails?examId=${userExamAnswer.examId}&userId=${userExamAnswer.userId}"><button class="btn btn-primary float-right">Details</button></a></td>

													</div>
													<div class="card-block">
														<div class="dt-responsive table-responsive">
															<div id="order-table_wrapper"
																class="dataTables_wrapper dt-bootstrap4">
																<div class="row" id="listRoles">
																
																<div class="d-flex flex-column">
																<div class="h5 mt-1 ml-4"><span class="mr-5">Student Id</span> : <span class="ml-5">${userExamAnswer.userId}</span></div>
																<div class="h5 mt-1 ml-4"><span class="mr-2">Student Name</span> : <span class="ml-5">${userExamAnswer.firstName}</span></div>
																<div class="h5 mt-1 ml-4"><span class="mr-4">Exam Name</span>&nbsp; : <span class="ml-5">${userExamAnswer.examName}</span></div>
																<div class="h5 mt-1 ml-4"><span class="mr-4">Exam Type</span>&nbsp;&nbsp;&nbsp; : <span class="ml-5">${userExamAnswer.description}</span></div>
																<div class="h5 mb-5 mt-1 ml-4"><span class="mr-4">Exam Date</span>&nbsp;&nbsp;&nbsp; : <span class="ml-5">${userExamAnswer.examDate}</span></div>
																
																</div>
																	<div class="col-xs-12 col-sm-12">
																		<table  class="table table-striped table-sm">
																		
																		<thead>
																				<tr role="row">
																					<th>Total Marks</th>
																					<th>Obtain Marks</th>

																					<th>Percentage</th>
																					<th>Status</th>
																				</tr>
																			</thead>
																			
																			<tbody>
																			<tr>
																			<td>${userExamAnswer.totalMarks}</td>
																			<td>${userExamAnswer.obtainMarks}</td>
																			<td>${userExamAnswer.percentage}%</td>
																			<td>
																				<c:if test="${userExamAnswer.isPass == 1 }"><p class="text-success h5">Pass</p></c:if>
																				<c:if test="${userExamAnswer.isPass == 0}"><p class="text-danger h5">Fail</p></c:if>
																			</td>
																			</tr>
																			</tbody>
																		
																			<%-- <tr>
																			<th class="h6">Student Id</th>
																			<td class="h6">${userExamAnswer.userId}</td>
																			</tr>
																			<tr>
																			<th class="h6">First Name</th>
																			<td class="h6">${userExamAnswer.firstName}</td>																			
																			</tr>
																			<tr >
																			<th class="h6">Exam Name</th>
																			<td class="h6">${userExamAnswer.examName}</td>
																			</tr>
																			<tr >
																			<th class="h6">Type</th>
																			<td class="h6">${userExamAnswer.description}</td>
																			</tr>
																			<tr >
																			<th class="h6">Exam Date</th>
																			<td class="h6">${userExamAnswer.examDate}</td>
																			</tr>
																			<tr >
																			<th class="h6">Total Marks</th>
																			<td class="h6">${userExamAnswer.totalMarks}</td>
																			</tr>
																			<tr >
																			<th class="h6">Obtain Marks</th>
																			<td class="h6">${userExamAnswer.obtainMarks}</td>
																			</tr>
																			<tr >
																			<th class="h6">Percentage</th>
																			<td class="h6">${userExamAnswer.percentage}%</td>
																			</tr>
																			<tr >
																			<th class="h6">Status</th>
																			<td class="h6">
																				<c:if test="${userExamAnswer.isPass == 1 }"><p class="text-success h5">Pass</p></c:if>
																				<c:if test="${userExamAnswer.isPass == 0}"><p class="text-danger h5">Fail</p></c:if>
																			</td>
																			</tr>
																			 --%>
																			
													

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
			function exportPdf() {
				const element = document.getElementById('listRoles');
				var opt = {
					margin : 1,
					filename : 'Report.pdf',
					image : {
						type : 'jpeg',
						quality : 0.98
					},
					html2canvas : {
						scale : 2
					},
					jsPDF : {
						unit : 'in',
						format : 'letter',
						orientation : 'landscape'
					}
				};
				html2pdf().set(opt).from(element).save();
			}
		</script>
















</body>
</html>