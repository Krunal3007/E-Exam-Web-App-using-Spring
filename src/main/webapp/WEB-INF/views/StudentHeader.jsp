<nav class="navbar header-navbar pcoded-header iscollapsed"
				header-theme="themelight1" pcoded-header-position="fixed">
				<div class="navbar-wrapper">
					<div class="navbar-logo" logo-theme="theme6">
						<a href="index.html">
			
							E-Exam

						</a> <a class="mobile-menu" id="mobile-collapse" href="#!"> <i
							class="feather icon-menu icon-toggle-right"></i>
						</a> <a class="mobile-options waves-effect waves-light"> <i
							class="feather icon-more-horizontal"></i>
						</a>
					</div>
					<div class="navbar-container container-fluid">
						
						<ul class="nav-right">
							

							<li class="user-profile header-notification">
								<div class="dropdown-primary dropdown">
									<div class="dropdown-toggle" data-toggle="dropdown"
										aria-expanded="false">
										<img src="jpg/user1.png" class="img-radius"
											alt="User-Profile-Image"> <span>${user.firstName}</span> <i
											class="feather icon-chevron-down"></i>
									</div>
									<ul
										class="show-notification profile-notification dropdown-menu"
										data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
										
										<li><a href="studentprofile?userId=${user.userId }"> <i class="feather icon-user"></i>
												Profile
										</a></li>
										
										
										<li><a href="logout"> <i
												class="feather icon-log-out"></i> Logout
										</a></li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</nav>