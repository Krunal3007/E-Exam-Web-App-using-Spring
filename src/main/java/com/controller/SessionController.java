package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SessionBean;
import com.bean.UserBean;
import com.dao.UserDao;




@Controller
public class SessionController {
	
	
	@Autowired
	UserDao userDao;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
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
	
	@PostMapping("/login") //same url rakhi sakay jo mapping different hoy (this is mapping is for authenication 
	public String authenticate(SessionBean session,Model model) {
		
		boolean isCorrect=false;
		
		UserBean dbuser = userDao.getUserByEmail(session.getLoginEmail());
		if(dbuser != null) {
			
			if(bCryptPasswordEncoder.matches(session.getLoginPassword(), dbuser.getPassword()) == true) {
				isCorrect=true;
			}
		}
		
		if(isCorrect == true) {
			
			//admin
			//faculty
			//student
			
			return "Home";
		}
		else {
			
			model.addAttribute("error","Invalid Credentials");
			return "Login";
		}
		
	}
	
	
	@RequestMapping(value = "forgetpassword", method = RequestMethod.GET)
	public String forgetpassword() {
		
		return "ForgetPassword";
	}
	
	@RequestMapping(value = "signupsaveuser" , method = RequestMethod.POST)
	public String saveuser(SessionBean user) {
		
		
		
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
