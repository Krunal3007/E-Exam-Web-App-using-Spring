package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.bean.UserExamBean;
import com.dao.ExamQuestionDao;
import com.dao.UserExamDao;

@Controller
public class UserExamController {
	
	
	
	@Autowired
	UserExamDao userExamDao;
	
	@Autowired
	ExamQuestionDao examQuestionDao;
	
	@GetMapping("/listuserexams")
	public String listUserExams(Model model) {
		
		List<ExamBean> exams = userExamDao.getUserExams();
		model.addAttribute("exams",exams);
		
		return "ListUserExams";
	}
	
	@GetMapping("/showuserexamquestions")
	public String showUserExamQuestions(@RequestParam("courseId") int courseId,Model model) {
		
		List<QuestionBean> questions = examQuestionDao.getExamQuestions(courseId);
		model.addAttribute("questions",questions);
		
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
//		for(int i=0;i<tmp.size();i++) {
//			System.out.println(tmp.get(i));
//		}
		
		ueb.getUserExamAnswer().addAll(tmp);
		
//		for(int i=0;i<ueb.getUserExamAnswer().size();i++) {
//			System.out.println(ueb.getUserExamAnswer().get(i));
//		}
		QuestionBean question = examQuestionDao.getCourseIdByQuestionId(ueb.getUserExamQuestionId().get(0));
		
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		ueb.setExamId(exam.getExamId());
		
		
		UserBean dbuser = (UserBean)hts.getAttribute("user");
		ueb.setUserId(dbuser.getUserId());
		
		userExamDao.addIntoUserExam(ueb);
		
		
		model.addAttribute("msg","Exam Submitted Successfully");
		
		return "StudentExamSubmitted";
	}

}
