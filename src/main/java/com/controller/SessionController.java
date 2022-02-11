package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup() {
		System.out.println("I am from signup");
		return "Signup";  //this is your view page --> html -->
		//we cant write java in html so we use jsp file
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	@RequestMapping(value = "forgetpassword", method = RequestMethod.GET)
	public String forgetpassword() {
		return "ForgetPassword";
	}

}
