package com.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.bean.UserExamBean;
import com.dao.CourseDao;
import com.dao.ExamQuestionDao;
import com.dao.UserExamAnswerDao;
import com.dao.UserExamDao;

@Controller
public class UserExamController {
	
	
	
	@Autowired
	UserExamDao userExamDao;
	
	@Autowired
	ExamQuestionDao examQuestionDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	UserExamAnswerDao userExamAnswerDao;
	
	
	@GetMapping("/listuserexams")
	public String listUserExams(Model model,HttpSession hts) {
		
		UserBean dbuser = (UserBean)hts.getAttribute("user");
		
		List<ExamBean> exams = userExamDao.getUserExams(dbuser.getUserId());
		
		model.addAttribute("exams",exams);
		
		return "ListUserExams";
	}
	
	@GetMapping("/showuserexamquestions")
	public String showUserExamQuestions(@RequestParam("courseId") int courseId,Model model,HttpSession hts) {
		
		
		
		CourseBean course = courseDao.getCourseById(courseId);
		model.addAttribute("course",course);
		
		List<QuestionBean> questions = examQuestionDao.getExamQuestions(courseId);
		model.addAttribute("questions",questions);
		
		int totalMarks=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
		}
		model.addAttribute("count",questions.size());
		model.addAttribute("totalMarks",totalMarks);
		
		return "ListUserExamQuestions";
	}
	
	@PostMapping("/saveuserexam")
	public String saveUserExam(UserExamBean ueb,HttpSession hts,Model model) {
		
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i=0;i<ueb.getAnswer().size();i++) {
			if(ueb.getAnswer().get(i) != null) {
		
				tmp.add(ueb.getAnswer().get(i));
				
			}
		}
		for(int i=0;i<tmp.size();i++) {
			System.out.println(tmp.get(i));
		}
		
		
		ueb.getUserExamAnswer().addAll(tmp);
		
//		for(int i=0;i<ueb.getUserExamAnswer().size();i++) {
			System.out.println("stored id "+ueb.getUserExamQuestionId());
			System.out.println("stored answer "+ueb.getUserExamAnswer());
//		}
		QuestionBean question = examQuestionDao.getCourseIdByQuestionId(ueb.getUserExamQuestionId().get(0));
		
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		ueb.setExamId(exam.getExamId());
		
		
		int exId = exam.getExamId();
		hts.setAttribute("exId", exId);
		
		UserBean dbuser = (UserBean)hts.getAttribute("user");
		ueb.setUserId(dbuser.getUserId());
		
		for(int i=0;i<ueb.getUserExamQuestionId().size();i++) {
			
			userExamDao.addIntoUserExam(ueb,ueb.getUserExamQuestionId().get(i),ueb.getUserExamAnswer().get(i));
		}
		
		
		return "redirect:/calculateuserexamanswer";
		
	}

	
	@GetMapping("calculateuserexamanswer")
	public String calculateUserExamAnswer(HttpSession hts,Model model) {
		
		
		int exId = (int) hts.getAttribute("exId");
		
		UserBean dbuser = (UserBean)hts.getAttribute("user");
		
		List<UserExamBean> user = userExamAnswerDao.getUserGivenExamQuestions(dbuser.getUserId(),exId);
		
		

		
		int totalMarks=0;
		int obtainMarks=0;
		int isPass;
		for(int i=0;i<user.size();i++) {
			
			QuestionBean question = userExamAnswerDao.getQuestionByQuestionId(user.get(i).getQuestionId());
			totalMarks=question.getQuestionMarks() + totalMarks;
			
			
			
			if(user.get(i).getUserAnswer().trim().equalsIgnoreCase(question.getQuestionAnswer().trim())) {
				obtainMarks = question.getQuestionMarks() + obtainMarks;
			}
		}
		System.out.println(totalMarks);
		System.out.println(obtainMarks);
		
		if(obtainMarks < (totalMarks/2)) {
			isPass=0;
			System.out.println("Fail");
		}
		else {
			isPass=1;
			System.out.println("Pass");
		}
		
		Date date = Calendar.getInstance().getTime();
		DateFormat date_format = new SimpleDateFormat("dd-MMM-yyyy");
		String date_string = date_format.format(date);
//		System.out.println("Date to String : "+ date_string);
		
		userExamAnswerDao.addUserExamAnswer(dbuser.getUserId(),exId,totalMarks,obtainMarks,isPass,date_string);
		
		
//		model.addAttribute("msg","Exam Submitted Successfully");
		
		return "StudentExamSubmitted";
	}
	
}
