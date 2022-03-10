package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ExamBean;
import com.bean.UserBean;
import com.bean.UserExamBean;
import com.dao.StudentDao;

@Controller
public class StudentController {

	@Autowired
	StudentDao studentDao;
	
	
	@GetMapping("/studentdashboard")
	public String studentDashboard(HttpSession hts,Model model) {
		
		
		UserBean dbuser = (UserBean)hts.getAttribute("user");
		
		List<ExamBean> remainingExams = studentDao.getRemainingExams(dbuser.getUserId());
		model.addAttribute("remainingExams",remainingExams.size());
		
		List<UserExamBean> userGivenExams = studentDao.getUserGivenExams(dbuser.getUserId());
		model.addAttribute("userGivenExams",userGivenExams.size());
		
		
		return "StudentDashboard";
	}
	
	@GetMapping("studentprofile")
	public String studentProfile(@RequestParam("userId")int userId,Model model) {
		
		
		UserBean student = studentDao.getStudentProfile(userId);
		model.addAttribute("user",student);
		
		return "StudentProfile";
	}
	
	@GetMapping("editstudentprofile")
	public String editStudentProfile(@RequestParam("userId")int userId,Model model) {
		
		UserBean student = studentDao.getStudentProfile(userId);
		model.addAttribute("user",student);
		
		return "EditStudentProfile";
	}
	
	@PostMapping("updatestudentprofile")
	public String updateStudentProfile(UserBean user,Model model) {
		
		studentDao.updateStudentProfile(user);
		
		UserBean student = studentDao.getStudentProfile(user.getUserId());
		model.addAttribute("user",student);
		
		return "StudentProfile";
	}
	
	
	
}
