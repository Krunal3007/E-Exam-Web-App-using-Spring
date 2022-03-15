<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Admin Dashboard</title>
<jsp:include page="AllCss.jsp"></jsp:include>
</head>

<body themebg-pattern="theme1">



	<div id="pcoded" class="pcoded iscollapsed" nav-type="st2"
		theme-layout="vertical" vertical-placement="left"
		vertical-layout="wide" pcoded-device-type="desktop"
		vertical-nav-type="expanded" vertical-effect="shrink"
		vnavigation-view="view1" fream-type="theme1" layout-type="light">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">



			<jsp:include page="AdminHeader.jsp"></jsp:include>




			<div class="pcoded-main-container" style="margin-top: 70.3906px;">
				<div class="pcoded-wrapper">

					<jsp:include page="AdminSideBar.jsp"></jsp:include>


					<div class="pcoded-content">

						<div class="page-header card">
							<div class="row align-items-end">
								<div class="col-lg-8">
									<div class="page-header-title">
										<i class="feather icon-home bg-c-blue"></i>
										<div class="d-inline">
											<h5>Welcome ${user.firstName }</h5>
											<span>Have a great day ahead!!!</span>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="index.html"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Dashboard
													</a></li>
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

											<div class="col-xl-4 col-md-8">
												<div class="card prod-p-card card-red">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
															
																<h6 class="m-b-5 text-white"><a href="listusers" class="h5 hov">Total Students</a></h6>
																<h3 class="m-b-0 f-w-700 text-white">${students }</h3>
																
															</div>
															<div class="col-auto">
																<i class="fas fa-user text-c-red f-18"></i>
															</div>
														</div>
														<!-- <p>&nbsp;</p> -->
														<!-- <p class="m-b-0 text-white">
															<span class="label label-danger m-r-10">+11%</span>From
															Previous Month
														</p> -->
													</div>
												</div>
											</div>
											<div class="col-xl-4 col-md-8">
												<div class="card prod-p-card card-blue">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white"><a href="listusers" class="h5 hov">Total Teachers</a></h6>
																<h3 class="m-b-0 f-w-700 text-white">${teachers }</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-users text-c-blue f-18"></i>
															</div>
														</div>
														<!-- <p class="m-b-0 text-white">
															<span class="label label-primary m-r-10">+12%</span>From
															Previous Month
														</p> -->
													</div>
												</div>
											</div>
											<div class="col-xl-4 col-md-8">
												<div class="card prod-p-card card-green">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white"><a href="listroles" class="h5 hov">Total Roles</a></h6>
																<h3 class="m-b-0 f-w-700 text-white">${roles }</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-tags text-c-green f-18"></i>
															</div>
														</div>
														<!-- <p class="m-b-0 text-white">
															<span class="label label-success m-r-10">+52%</span>From
															Previous Month
														</p> -->
													</div>
												</div>
											</div>
											<div class="col-xl-4 col-md-8">
												<div class="card prod-p-card bg-secondary">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white"><a href="listcourses" class="h5 hov">Total Courses</a></h6>
																<h3 class="m-b-0 f-w-700 text-white">${courses }</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-file text-c-yellow f-18"></i>
															</div>
														</div>
														<!-- <p class="m-b-0 text-white">
															<span class="label label-warning m-r-10">+52%</span>From
															Previous Month
														</p> -->
													</div>
												</div>
											</div>
											
											<div class="col-xl-4 col-md-8">
												<div class="card prod-p-card bg-info">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white"><a href="listquestions" class="h5 hov">Total Questions</a></h6>
																<h3 class="m-b-0 f-w-700 text-white">${questions }</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-book text-c-yellow f-18"></i>
															</div>
														</div>
														<!-- <p class="m-b-0 text-white">
															<span class="label label-warning m-r-10">+52%</span>From
															Previous Month
														</p> -->
													</div>
												</div>
											</div>

											
											<div class="col-xl-4 col-md-8">
												<div class="card prod-p-card bg-dark">
													<div class="card-body">
														<div class="row align-items-center m-b-30">
															<div class="col">
																<h6 class="m-b-5 text-white"><a href="listexams" class="h5 hov">Total Exams</a></h6>
																<h3 class="m-b-0 f-w-700 text-white">${exams }</h3>
															</div>
															<div class="col-auto">
																<i class="fas fa-bars text-c-green f-18"></i>
															</div>
														</div>
														<!-- <p class="m-b-0 text-white">
															<span class="label label-success m-r-10">+52%</span>From
															Previous Month
														</p> -->
													</div>
												</div>
											</div>
											
											
<div class="col-xl-10 col-md-12 ">
<div class="card comp-card">
<div class="card-body">
<div class="row align-items-center">
<div class="col">
<h6 class="m-b-25">Total Attempted Exams</h6>
<h3 class="f-w-700 text-c-blue">${allGivenExams }</h3>
<!-- <p class="m-b-0">May 23 - June 01 (2017)</p> -->
</div>
<div class="col-auto">
<i class="fas fa-eye bg-c-blue"></i>
</div>
</div>
</div>
</div>
</div>

<div class="col-xl-5 col-md-6">
<div class="card comp-card">
<div class="card-body">
<div class="row align-items-center">
<div class="col">
<h6 class="m-b-25">Total Cleared Exams</h6>
<h3 class="f-w-700 text-c-green">${allPassed }</h3>
<!-- <p class="m-b-0">May 23 - June 01 (2017)</p> -->
</div>
<div class="col-auto">
<i class="fas fa-bullseye bg-c-green"></i>
</div>
</div>
</div>
</div>
</div>

<div class="col-xl-5 col-md-6">
<div class="card comp-card">
<div class="card-body">
<div class="row align-items-center">
<div class="col">
<h6 class="m-b-25">Total Failed Exams</h6>
<h3 class="f-w-700 text-c-red">${allFailed }</h3>
<!-- <p class="m-b-0">May 23 - June 01 (2017)</p> -->
</div>
<div class="col-auto">
<i class="fas fa-bullseye bg-c-red"></i>
</div>
</div>
</div>
</div>
</div>


<div class="col-xl-10 col-md-6">
<div class="card comp-card">
<div class="card-body">
<div class="row align-items-center">
<div class="col">
<h6 class="m-b-25">Pass Ratio</h6>
<h3 class="f-w-700 text-c-yellow">${ratio }%</h3>
<!-- <p class="m-b-0">May 23 - June 01 (2017)</p> -->
</div>
<div class="col-auto">
 <i class="fas fa-hand-paper bg-c-yellow"></i>
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
					</div>

					<div id="styleSelector"></div>

				</div>
			</div>
		</div>
	</div>


	<jsp:include page="AllJs.jsp"></jsp:include>

	<!-- Mirrored from colorlib.com/polygon/admindek/default/dashboard-crm.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 12 Dec 2019 16:08:32 GMT -->
</body>

</html>