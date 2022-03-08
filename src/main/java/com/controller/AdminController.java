package com.controller;

import java.util.ArrayList;
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
import com.dao.ExamDao;

@Controller
public class AdminController {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ExamDao examDao;
	
	
	@GetMapping("/admindashboard")
	public String adminDashboard(Model model) {
		
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
		
		
		return "AdminDashboard";
	}
	
	@GetMapping("getallusersresult")
	public String adminSideUsersResult(Model model) {
		
		List<UserExamAnswerBean> ueb = adminDao.getAllUsersResult();
		List<String> uName = new ArrayList<>();
		
		
		for(int i=0;i<ueb.size();i++) {
			UserBean user = adminDao.getUserbyUserId(ueb.get(i).getUserId());
			uName.add(user.getFirstName());
		}
		List<Integer> cId = new ArrayList<>();
		
		for(int i=0;i<ueb.size();i++) {
			ExamBean exam = examDao.getExamById(ueb.get(i).getExamId());
			cId.add(exam.getCourseId());
		}
		List<String> cName = new ArrayList<>();
		for(int i=0;i<ueb.size();i++) {
			CourseBean course = adminDao.getCourseById(cId.get(i));
			cName.add(course.getCourseName());
		}
		
		for(int i=0;i<ueb.size();i++) {
			ueb.get(i).setFirstName(uName.get(i));
			ueb.get(i).setExamName(cName.get(i));
		}
		
		
		
		model.addAttribute("ueb",ueb);
		
		return "ListAllUsersResult";
	}

	
}
