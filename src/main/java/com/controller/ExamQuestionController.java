package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CourseBean;
import com.bean.ExamQuestionBean;
import com.bean.QuestionBean;
import com.dao.CourseDao;
import com.dao.ExamQuestionDao;
import com.dao.QuestionDao;

@Controller
public class ExamQuestionController {
	
	@Autowired
	ExamQuestionDao examQuestionDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	CourseDao courseDao;

	@GetMapping("/selectexam")
	public String listExamQuestion(Model model) {
		
		List<CourseBean> courses = examQuestionDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "StartExamQuestion";
	}
	
	@GetMapping("/startexam")
	public String startExam(ExamQuestionBean eqb,Model model) {
		
		List<QuestionBean> questions = examQuestionDao.getExamQuestions(eqb.getCourseId());
		
		model.addAttribute("questions",questions);
		
		return "ListExamQuestions";
		
	}
	
	@GetMapping("/newexamquestion")
	public String newExamQuestion(Model model) {
		
		List<CourseBean> courses = courseDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "NewExamQuestion";
	}
	
	@PostMapping("/saveexamquestion")
	public String saveExamQuestion(QuestionBean question) {
		
		questionDao.addQuestion(question);
		
		return "redirect:/startexam";
	}
	
	
	@GetMapping("/deleteexamquestion/{questionId}")
	public String deleteQuestion(@PathVariable("questionId") int questionId) {
		
		questionDao.deleteQuestion(questionId);
		
		return "redirect:/startexam";
		
	}
	
	@GetMapping("/editexamquestion")
	public String editQuestion(@RequestParam("questionId") int questionId,Model model) {
		
		QuestionBean question = questionDao.getQuestionById(questionId);
		model.addAttribute("question",question);
		
		return "EditExamQuestion";
		
	}
	
	@PostMapping("/updateexamquestion")
	public String updateQuestion(QuestionBean question) {
		
		questionDao.updateQuestion(question);
		
		return "redirect:/startexam";
		
	}
	
	
	
	
	
	
}
