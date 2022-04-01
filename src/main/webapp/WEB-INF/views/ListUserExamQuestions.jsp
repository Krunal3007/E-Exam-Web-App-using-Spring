<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User Exam Questions</title>
<jsp:include page="AllCss.jsp"></jsp:include>

</head>
<body>


















<div id="pcoded" class="pcoded iscollapsed ">
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
											<h5>Subject : ${course.courseName }</h5>
											
										</div>
										
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="studentdashboard"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Questions</a></li>
											<li class="breadcrumb-item"><a href="#!">List</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>

						<div class="pcoded-inner-content">

							<div class="main-body ">
								<div class="page-wrapper">

									<div class="page-body ">
										<div class="row">
											<div class="col-sm-8 mx-auto">
												<div class="card">
													<div class="card-header">
														<h4 class="btn btn-secondary  ">Total Questions : ${count }</h4>
														<h4 class="btn btn-secondary  ">Total Marks : ${totalMarks }</h4>		
													</div>
													<div class="card-block">
														
						
														
														
														
														
												

<form action="saveuserexam" method="post" >

										

<ol type="1">
<c:forEach items="${questions}" var="q" varStatus="status">
	
	
	<div class="align-items-center pt-4 text-right">
			
							Marks : ${q.questionMarks }	
			
	</div>
<li>
	${q.questionName } 
	<input type="hidden" name="userExamQuestionId" value="${q.questionId }" >
	
		<br>
		
		<input type="radio" id="${q.questionId }${q.option1 }"  name="answer[${status.index }]"  value="${q.option1 } " required="required">
		<label for="${q.questionId }${q.option1 }">${q.option1 }</label>
		
		<br>
			
		
	
		<input type="radio" id="${q.questionId }${q.option2 }" name="answer[${status.index }]" value="${q.option2 }">
		<label for="${q.questionId }${q.option2 }">${q.option2 }</label>
		
		<br>
			
		
			
		<input type="radio" id="${q.questionId }${q.option3 }" name="answer[${status.index }]" value="${q.option3 }">
		<label for="${q.questionId }${q.option3 }">${q.option3 }</label>
		
		<br>
			
		
		
		<input type="radio" id="${q.questionId }${q.option4 }" name="answer[${status.index }]" value="${q.option4 }">
		<label for="${q.questionId }${q.option4 }">${q.option4 }</label>
		
		
		
		<br><br>
		
	
</li>

</c:forEach>
</ol>


 			<div class="align-items-center pt-4 text-center">
			
					<input type="submit" value="Submit" class="btn btn-primary ">
			
			</div>




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