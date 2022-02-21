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
import com.bean.QuestionBean;
import com.dao.CourseDao;
import com.dao.QuestionDao;

@Controller
public class QuestionController {
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@GetMapping("/newquestion")
	public String newQuestion(Model model) {
		
		List<CourseBean> courses = courseDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "NewQuestion";
	}
	
	@PostMapping("/savequestion")
	public String saveQuestion(QuestionBean question) {
		
		questionDao.addQuestion(question);
		
		return "redirect:/listquestions";
	}
	
	@GetMapping("/listquestions")
	public String listQuestions(Model model) {
		
		List<QuestionBean> questions = questionDao.getAllQuestions();
		model.addAttribute("questions",questions);
		
		return "ListQuestions";
	}
	
	@GetMapping("/deletequestion/{questionId}")
	public String deleteQuestion(@PathVariable("questionId") int questionId) {
		
		questionDao.deleteQuestion(questionId);
		
		return "redirect:/listquestions";
		
	}
	
	@GetMapping("/editquestion")
	public String editQuestion(@RequestParam("questionId") int questionId,Model model) {
		
		QuestionBean question = questionDao.getQuestionById(questionId);
		model.addAttribute("question",question);
		
		return "EditQuestion";
		
	}
	
	@PostMapping("/updatequestion")
	public String updateQuestion(QuestionBean question) {
		
		questionDao.updateQuestion(question);
		
		return "redirect:/listquestions";
		
	}

}
