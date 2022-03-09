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
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.dao.CourseDao;
import com.dao.ExamDao;
import com.dao.ExamQuestionDao;
import com.dao.QuestionDao;

@Controller
public class QuestionController {
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	ExamDao examDao;
	
	@Autowired
	ExamQuestionDao examQuestionDao;
	
	@GetMapping("/newquestion")
	public String newQuestion(Model model) {
		
		List<CourseBean> courses = courseDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "NewQuestion";
	}
	
	@PostMapping("/savequestion")
	public String saveQuestion(QuestionBean question) {
		
		questionDao.addQuestion(question);
		
		List<QuestionBean> questions = examDao.getExamQuestions(question.getCourseId());
		
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		
		if(exam != null) {
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
		examDao.updateMarksCount(exam);
		}
		

		
		return "redirect:/listquestions";
	}
	
	@GetMapping("/listquestions")
	public String listQuestions(Model model) {
		
		List<QuestionBean> questions = questionDao.getAllQuestions();
		model.addAttribute("questions",questions);
		
		model.addAttribute("count",questions.size());
		
		return "ListQuestions";
	}
	
	@GetMapping("/deletequestion/{questionId}")
	public String deleteQuestion(@PathVariable("questionId") int questionId) {
		
		
		
		QuestionBean question = examQuestionDao.getCourseIdByQuestionId(questionId);
		
		
		questionDao.deleteQuestion(questionId);
		
		List<QuestionBean> questions = examDao.getExamQuestions(question.getCourseId());
		
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		
		if(exam != null) {
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
		examDao.updateMarksCount(exam);
		}
		
		
		
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
		
		List<QuestionBean> questions = examDao.getExamQuestions(question.getCourseId());
		
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		
		
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		System.out.println(exam.getCourseId());
		if(exam != null) {
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
		examDao.updateMarksCount(exam);
		}
		
		return "redirect:/listquestions";
		
	}

}
