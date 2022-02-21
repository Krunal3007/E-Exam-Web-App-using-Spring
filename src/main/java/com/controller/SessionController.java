package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SessionBean;




@Controller
public class SessionController {
	
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup() {
//		System.out.println("I am from signup");
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
	
	@RequestMapping(value = "signupsaveuser" , method = RequestMethod.POST)
	public String saveuser(SessionBean user) {
		
		System.out.println(user.getFirstName());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		
		return "Login";
	}
	
	@RequestMapping(value = "emailforpass" , method = RequestMethod.POST)
	public String emailforpass(SessionBean user) {
		System.out.println(user.getNewEmail());
		
		return "Login";
	}
	
	@RequestMapping(value = "loginuser", method = RequestMethod.POST)
	public String loginuser(SessionBean user) {
		System.out.println(user.getLoginEmail());
		System.out.println(user.getLoginPassword());
		
		return "Login";
	}

}
