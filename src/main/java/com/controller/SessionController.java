package com.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping("/")
	public String login2() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "Login";
	}
	
	@PostMapping("/login") //same url rakhi sakay jo mapping different hoy (this is mapping is for authenication 
	public String authenticate(SessionBean session,Model model,HttpSession hts) {
		
		boolean isCorrect=false;
		
		UserBean dbuser = userDao.getUserByEmail(session.getLoginEmail());
		
		if(dbuser != null) {
			
			if(bCryptPasswordEncoder.matches(session.getLoginPassword(), dbuser.getPassword()) == true) {
				isCorrect=true;
				hts.setAttribute("user", dbuser);
			}
		}
		
		if(isCorrect == true) {
			
			//admin
			//faculty
			//student
			
			if(dbuser.getRoleId() == 1) {
				return "redirect:/admindashboard";
			
			}else if(dbuser.getRoleId() == 6) {
				return "redirect:/facultydashboard";
			
			}else if(dbuser.getRoleId() == 5) {
				return "redirect:/studentdashboard";
				
			}else {
				return "NoRole";
			}
			
			
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
	
	
	
	@RequestMapping(value = "forgetpassword" , method = RequestMethod.POST)
	public String emailforpass(SessionBean sessionb,Model model,HttpSession session) {
		
		UserBean dbuser = userDao.getUserByEmail(sessionb.getEmailForPass());
		
		if(dbuser == null) {
			
			model.addAttribute("error","Please enter valid email");
			return "ForgetPassword";
		}
		else {
			
			int otp = (int)(Math.random() * 1000000);
			session.setAttribute("otp", otp);
			session.setAttribute("email", sessionb.getEmailForPass());
			
			model.addAttribute("msg","Otp is generated and sent to your email");
			System.out.println(otp);
			
			return "NewPassword";
		}
		
		
	}
	
	@PostMapping("/updatepassword")
	public String updatePassword(SessionBean sessionb,HttpSession session,Model model) {
		
		int otp = (int)session.getAttribute("otp");
		String email = (String)session.getAttribute("email");
		
		if(otp == sessionb.getOtp() && email.equals(sessionb.getLoginEmail())) {
			
			String encryptedPassword = bCryptPasswordEncoder.encode(sessionb.getLoginPassword());
			sessionb.setLoginPassword(encryptedPassword);
			
			userDao.updatePassword(sessionb);
			
			model.addAttribute("msg","Password updated successfully please login");
			return "Login";
		}
		else {
			model.addAttribute("error","Your data mismatch with our records");
			return "NewPassword";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/login";
		
	}

}
