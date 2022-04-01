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
		
		
		List<UserExamAnswerBean> ueb = adminDao.getAllUsersResult();
		model.addAttribute("allGivenExams",ueb.size());
		
		float percentage=0;
		for(int i=0;i<ueb.size();i++) {
			percentage = ((float)ueb.get(i).getObtainMarks()/ueb.get(i).getTotalMarks())*100;
			String percent = String.format("%.2f",percentage );
			
			ueb.get(i).setPercentage(Float.parseFloat(percent));
		}
		
		model.addAttribute("allResults",ueb);
		
		
		
		List<UserExamAnswerBean> pass = adminDao.getAllPassedStudents();
		model.addAttribute("allPassed",pass.size());
		
		
		List<UserExamAnswerBean> fail = adminDao.getAllFailedStudents();
		model.addAttribute("allFailed",fail.size());
		
		int a=ueb.size();
		int b = pass.size();
		String ratio = String.format("%.2f", ((float)b/a)*100);
		model.addAttribute("ratio",ratio);
		
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
		List<String> desc = new ArrayList<>();
		for(int i=0;i<ueb.size();i++) {
			ExamBean exam = examDao.getExamById(ueb.get(i).getExamId());
			cId.add(exam.getCourseId());
			desc.add(exam.getInstructions());
		}
		List<String> cName = new ArrayList<>();
		for(int i=0;i<ueb.size();i++) {
			CourseBean course = adminDao.getCourseById(cId.get(i));
			cName.add(course.getCourseName());
		}
		
		for(int i=0;i<ueb.size();i++) {
			ueb.get(i).setFirstName(uName.get(i));
			ueb.get(i).setExamName(cName.get(i));
			ueb.get(i).setDescription(desc.get(i));
		}

		float percentage=0;
		for(int i=0;i<ueb.size();i++) {
			percentage = ((float)ueb.get(i).getObtainMarks()/ueb.get(i).getTotalMarks())*100;
			String percent = String.format("%.2f",percentage );
			
			ueb.get(i).setPercentage(Float.parseFloat(percent));
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
	
	@GetMapping("courseresultreport")
	public String getResultesOfAllCourses(@RequestParam("courseId")int courseId,Model model) {
		
		if(courseId == 0) {
			List<UserExamAnswerBean> ueb = userExamAnswerDao.getAllUser();
			
			for(int i=0;i<ueb.size();i++) {
				ExamBean exam = examDao.getExamById(ueb.get(i).getExamId());
				ueb.get(i).setDescription(exam.getInstructions());
			}
			for(int i=0;i<ueb.size();i++) {
				UserBean ub = adminDao.getUserbyUserId(ueb.get(i).getUserId());
				ueb.get(i).setFirstName(ub.getFirstName());
				ExamBean eb = userExamAnswerDao.getCourseIdByExamId(ueb.get(i).getExamId());
				CourseBean cb = adminDao.getCourseById(eb.getCourseId());
				ueb.get(i).setExamName(cb.getCourseName());
			}
			float percentage=0;
			for(int i=0;i<ueb.size();i++) {
				percentage = ((float)ueb.get(i).getObtainMarks()/ueb.get(i).getTotalMarks())*100;
				String percent = String.format("%.2f",percentage );
				
				ueb.get(i).setPercentage(Float.parseFloat(percent));
			}
			
		    model.addAttribute("allResults",ueb);
		}
		else {
			ExamBean eb = userExamAnswerDao.getExamIdByCourseId(courseId);
			if(eb != null) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
			List<UserExamAnswerBean> ueb = userExamAnswerDao.getResultByCourseId(eb.getExamId());
			
			for(int i=0;i<ueb.size();i++) {
				ExamBean exam = examDao.getExamById(ueb.get(i).getExamId());
				ueb.get(i).setDescription(exam.getInstructions());
			}
			for(int i=0;i<ueb.size();i++) {
				UserBean ub = adminDao.getUserbyUserId(ueb.get(i).getUserId());
				ueb.get(i).setFirstName(ub.getFirstName());
				ExamBean ebb = userExamAnswerDao.getCourseIdByExamId(ueb.get(i).getExamId());
				CourseBean cb = adminDao.getCourseById(ebb.getCourseId());
				ueb.get(i).setExamName(cb.getCourseName());
			}
			float percentage=0;
			for(int i=0;i<ueb.size();i++) {
				percentage = ((float)ueb.get(i).getObtainMarks()/ueb.get(i).getTotalMarks())*100;
				String percent = String.format("%.2f",percentage );
				
				ueb.get(i).setPercentage(Float.parseFloat(percent));
			}
			
			model.addAttribute("allResults",ueb);
			}
		}
		List<CourseBean> courses = courseDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "CourseResultReport";
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
				ExamBean exam = examDao.getExamById(ueb.get(i).getExamId());
				ueb.get(i).setDescription(exam.getInstructions());
			}
			for(int i=0;i<ueb.size();i++) {
				UserBean ub = adminDao.getUserbyUserId(ueb.get(i).getUserId());
				ueb.get(i).setFirstName(ub.getFirstName());
				ExamBean eb = userExamAnswerDao.getCourseIdByExamId(ueb.get(i).getExamId());
				CourseBean cb = adminDao.getCourseById(eb.getCourseId());
				ueb.get(i).setExamName(cb.getCourseName());
			}
			float percentage=0;
			for(int i=0;i<ueb.size();i++) {
				percentage = ((float)ueb.get(i).getObtainMarks()/ueb.get(i).getTotalMarks())*100;
				String percent = String.format("%.2f",percentage );
				
				ueb.get(i).setPercentage(Float.parseFloat(percent));
			}
			
			model.addAttribute("ueb",ueb);
		}
		else {
			List<UserExamAnswerBean> ueb = userExamAnswerDao.getUserByUserId(userId);
			for(int i=0;i<ueb.size();i++) {
				ExamBean exam = examDao.getExamById(ueb.get(i).getExamId());
				ueb.get(i).setDescription(exam.getInstructions());
			}
			for(int i=0;i<ueb.size();i++) {
				UserBean ub = adminDao.getUserbyUserId(ueb.get(i).getUserId());
				ueb.get(i).setFirstName(ub.getFirstName());
				ExamBean eb = userExamAnswerDao.getCourseIdByExamId(ueb.get(i).getExamId());
				CourseBean cb = adminDao.getCourseById(eb.getCourseId());
				ueb.get(i).setExamName(cb.getCourseName());
			}
			float percentage=0;
			for(int i=0;i<ueb.size();i++) {
				percentage = ((float)ueb.get(i).getObtainMarks()/ueb.get(i).getTotalMarks())*100;
				String percent = String.format("%.2f",percentage );
				
				ueb.get(i).setPercentage(Float.parseFloat(percent));
			}
			
			
			model.addAttribute("ueb",ueb);
		}
		List<UserBean> students = userExamAnswerDao.getAllStudents();
		model.addAttribute("students",students);
		
		
		return "StudentReport";
	}
	
	
	
	
	
}
