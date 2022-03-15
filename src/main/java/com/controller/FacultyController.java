package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.bean.UserExamAnswerBean;
import com.dao.AdminDao;

@Controller
public class FacultyController {

	@Autowired
	AdminDao adminDao;
	
	@GetMapping("/facultydashboard")
	public String facultyDashboard(Model model) {
		
		
		
		
		
		List<UserBean> students = adminDao.getTotalStudents();	
		model.addAttribute("students",students.size());
		
		
		List<UserBean> teachers = adminDao.getTotalTeachers();	
		model.addAttribute("teachers",teachers.size());
		
		
		List<RoleBean> roles = adminDao.getAllRoles();
		model.addAttribute("roles", roles.size());
		
		
		List<CourseBean> courses = adminDao.getAllCourses();
		model.addAttribute("courses", courses.size());
		
		
		List<QuestionBean> questions = adminDao.getAllQuestions();
		model.addAttribute("questions", questions.size());
		
		List<ExamBean> exams = adminDao.getAllExams();
		model.addAttribute("exams", exams.size());
			
		
		List<UserExamAnswerBean> ueb = adminDao.getAllUsersResult();
		model.addAttribute("allGivenExams",ueb.size());
		
		List<UserExamAnswerBean> pass = adminDao.getAllPassedStudents();
		model.addAttribute("allPassed",pass.size());
		
		List<UserExamAnswerBean> fail = adminDao.getAllFailedStudents();
		model.addAttribute("allFailed",fail.size());
		
		int a=ueb.size();
		int b = pass.size();
		String ratio = String.format("%.2f", ((float)b/a)*100);
		model.addAttribute("ratio",ratio);
		
		
		
		
		
		return "FacultyDashboard";
	}
}
