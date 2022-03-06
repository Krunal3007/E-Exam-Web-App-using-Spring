<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Exam Questions</title>
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
											<h5>New Exam Question</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="admindashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Exams</a></li>
											<li class="breadcrumb-item"><a href="#!">New Exam Question</a></li>
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
														<h5>Add New Question</h5>
													</div>
													<div class="card-block">
														
						
														
														
														
														
														<form action="saveexamquestion" method="post">

															<div class="form-group row">
																<label class="col-sm-2 col-form-label">Question Name</label>
																<div class="col-sm-10">
																	<textarea name="questionName" rows="5" cols="5"
																		class="form-control" placeholder="Write Here"></textarea>
																</div>
															</div>


															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Question Marks</label>
																<div class="col-sm-10">
																	<input type="text" name="questionMarks" class="form-control">
																</div>
															</div>
															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Question Answer</label>
																<div class="col-sm-10">
																	<input type="text" name="questionAnswer" class="form-control">
																</div>
															</div>







														<div class="form-group row">
																<label class="col-sm-2 col-form-label">Select Course</label>
																<div class="col-sm-10">
																	<select name="courseId" class="form-control">
	
																	<c:forEach items="${courses }" var="c">
																		<option value="${c.courseId }">${c.courseName }</option>
																	</c:forEach>

																</select>
																</div>
															</div>


															
															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Option 1</label>
																<div class="col-sm-10">
																	<input type="text" name="option1" class="form-control">
																</div>
															</div>
															
															
															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Option 2</label>
																<div class="col-sm-10">
																	<input type="text" name="option2" class="form-control">
																</div>
															</div>
															
														
															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Option 3</label>
																<div class="col-sm-10">
																	<input type="text" name="option3" class="form-control">
																</div>
															</div>
															
														
															
																<div class="form-group row">
																<label class="col-sm-2 col-form-label">Option 4</label>
																<div class="col-sm-10">
																	<input type="text" name="option4" class="form-control">
																</div>
															</div>





														

															 

														


														
															
															
												
															

																			
														<input type="submit" class="btn btn-primary" value="Add Question"/>
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