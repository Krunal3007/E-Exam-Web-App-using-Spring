package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
public class ExamController {
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ExamDao examDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	ExamQuestionDao examQuestionDao;
	
	
	@GetMapping("/newexam")
	public String newExam(Model model) {
		
		List<CourseBean> courses = courseDao.getAllCourses(); 
		
		model.addAttribute("courses",courses);
		
		return "NewExam";
	}
	
	@PostMapping("/saveexam")
	public String saveExam(ExamBean exam,HttpSession hts) {
		
		
		List<QuestionBean> questions = examDao.getExamQuestions(exam.getCourseId());
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		System.out.println(totalMarks);
		System.out.println(count);
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
				
		examDao.addExam(exam);
		
		return "redirect:/listexams";
	}
	
	@GetMapping("/listexams")
	public String listExams(Model model) {
		
		
		List<ExamBean> exams = examDao.getAllExams();

		model.addAttribute("exams",exams);
		
		
//this is for questions which are in userexam
//		int courseId=0;
//		int totalMarks=0;
//		int count=0;
//		 
//		
//		for(int i=0;i<exams.size();i++) {
//			courseId = exams.get(i).getCourseId();
//			
//			List<QuestionBean> questions = examQuestionDao.getExamQuestions(courseId);
//			
//			
//			if(questions.size() != 0) {
//			for(int j=0;j<questions.size();j++) {
//				totalMarks = questions.get(j).getQuestionMarks() + totalMarks;
//				count++;
//			}
//			
//			
//			questions.get(i).setTotalMarks(totalMarks);
//			questions.get(i).setTotalQuestions(count);
//		
//			totalMarks=0;
//			count=0;
//			
//			
//			model.addAttribute("questions",questions);
//			}
//		}
		
		
		
		
		
		return "ListExams";
	}
	
	@GetMapping("/deleteexam/{examId}")
	public String deleteExam(@PathVariable("examId") int examId) {
		
		examDao.deleteExam(examId);
		
		return "redirect:/listexams";
		
	}
	
	@GetMapping("/editexam")
	public String exitExam(@RequestParam("examId") int examId,Model model) {
		
		ExamBean exam = examDao.getExamById(examId);
		model.addAttribute("exam",exam);
		
		return "EditExam";
	}
	
	@PostMapping("/updateexam")
	public String updateExam(ExamBean exam) {
		
		examDao.updateExam(exam);
		
		return "redirect:/listexams";
	}
	
	
	
	
	
	
}
