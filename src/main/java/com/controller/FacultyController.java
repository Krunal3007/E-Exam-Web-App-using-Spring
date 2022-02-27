package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacultyController {

	@GetMapping("/facultydashboard")
	public String facultyDashboard() {
		
		return "FacultyDashboard";
	}
}
