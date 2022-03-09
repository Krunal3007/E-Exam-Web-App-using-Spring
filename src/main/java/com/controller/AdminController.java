package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.bean.UserExamAnswerBean;
import com.dao.AdminDao;
import com.dao.CourseDao;
import com.dao.ExamDao;
import com.dao.QuestionDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.dao.UserExamAnswerDao;

@Controller
public class AdminController {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ExamDao examDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	UserExamAnswerDao userExamAnswerDao;
	
	
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

	
	@GetMapping("userreport")
	public String getAllUsers(@RequestParam("roleId")int roleId,Model model) {
		
		if(roleId == 0) {
		List<UserBean> users =  userDao.getAllUsers();
		model.addAttribute("users",users);
		}
		else {
			List<UserBean> users = userDao.getUserByRoleId(roleId);
			model.addAttribute("users",users);
		}
		List<RoleBean> roles = roleDao.getAllRoles();
		model.addAttribute("roles",roles);
		
		return "UserReport";
	}
	
	@GetMapping("questionreport")
	public String getAllQuestions(@RequestParam("courseId")int courseId,Model model) {
		
		if(courseId == 0) {
			List<QuestionBean> questions = questionDao.getAllQuestions();
			model.addAttribute("questions",questions);
		}
		else {
			List<QuestionBean> questions = questionDao.getQuestionByCourseId(courseId);
			model.addAttribute("questions",questions);
		}
		List<CourseBean> courses = courseDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "QuestionReport";
		
	}
	
	@GetMapping("studentreport")
	public String getAllStudent(@RequestParam("userId")int userId,Model model) {
		
		if(userId == 0) {
			List<UserExamAnswerBean> ueb = userExamAnswerDao.getAllUser();
			for(int i=0;i<ueb.size();i++) {
				UserBean ub = adminDao.getUserbyUserId(ueb.get(i).getUserId());
				ueb.get(i).setFirstName(ub.getFirstName());
				ExamBean eb = userExamAnswerDao.getCourseIdByExamId(ueb.get(i).getExamId());
				CourseBean cb = adminDao.getCourseById(eb.getCourseId());
				ueb.get(i).setExamName(cb.getCourseName());
			}
			
			model.addAttribute("ueb",ueb);
		}
		else {
			List<UserExamAnswerBean> ueb = userExamAnswerDao.getUserByUserId(userId);
			for(int i=0;i<ueb.size();i++) {
				UserBean ub = adminDao.getUserbyUserId(ueb.get(i).getUserId());
				ueb.get(i).setFirstName(ub.getFirstName());
				ExamBean eb = userExamAnswerDao.getCourseIdByExamId(ueb.get(i).getExamId());
				CourseBean cb = adminDao.getCourseById(eb.getCourseId());
				ueb.get(i).setExamName(cb.getCourseName());
			}
			
			
			model.addAttribute("ueb",ueb);
		}
		List<UserBean> students = userExamAnswerDao.getAllStudents();
		model.addAttribute("students",students);
		
		
		return "StudentReport";
	}
	
	
	
	
}
