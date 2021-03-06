package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.ExamQuestionBean;
import com.bean.QuestionBean;
import com.dao.CourseDao;
import com.dao.ExamDao;
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
	
	@Autowired
	ExamDao examDao;
	
	
	

	@GetMapping("/selectexam")
	public String listExamQuestion(Model model) {
		
		List<CourseBean> courses = examQuestionDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "StartExamQuestion";
	}
	
	@GetMapping("/startexam")
	public String startExam(ExamQuestionBean eqb,Model model) {
		
		
		List<QuestionBean> questions = examQuestionDao.getAllExamQuestions(eqb.getCourseId());
		
		model.addAttribute("questions",questions);
		
		return "ListExamQuestions";
		
	}
	
	
	@GetMapping("/listexamquestions")
	public String listExamQuestionsForAll(HttpSession hts,Model model) {
		
		
		
		int courseId =(int)hts.getAttribute("courseId");
		
	
		List<QuestionBean> questions = examQuestionDao.getAllExamQuestions(courseId);
		
		int totalMarks=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
		}
		model.addAttribute("count",questions.size());
		model.addAttribute("totalMarks",totalMarks);
		
		List<QuestionBean> questionsOfExam = examQuestionDao.getExamQuestions(courseId);
		for(int i=0;i<questions.size();i++) {
			for(int j=0;j<questionsOfExam.size();j++) {
			if(questionsOfExam.get(j).getQuestionId() == questions.get(i).getQuestionId()) {
				questions.get(i).setIsAdded(1);
			}
			}
		}
		model.addAttribute("questions",questions);
		
		return "ListExamQuestions";
	}
	
	
	
	
	@GetMapping("/showallexamquestions")
	public String showAllExamQuestions(@RequestParam("courseId")int courseId,HttpSession hts) {
		
		
		
		hts.setAttribute("courseId", courseId);
		
		
		return "redirect:/listexamquestions";
	}
	
	@GetMapping("showexamquestions")
	public String showExamQuestions(@RequestParam("courseId")int courseId,Model model) {
		
		
		
		List<QuestionBean> questionsAll = examQuestionDao.getAllExamQuestions(courseId);
	
		if(questionsAll.size() != 0) {
		String courseName = questionsAll.get(0).getCourseName();
		
		model.addAttribute("courseName",courseName);
		
		int count=0;
		int totalMarks=0;
		List<QuestionBean> questions = examQuestionDao.getExamQuestions(courseId);
		for(int i=0;i<questions.size();i++) {
			questions.get(i).setCourseName(courseName);
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		model.addAttribute("count",count);
		model.addAttribute("totalMarks",totalMarks);
		model.addAttribute("questions",questions);
		}
		
		
		return "ListAddedExamQuestions";
		
	}
	
	
	
	
	@GetMapping("addquestiontoexam")
	public String addQuestionToExam(@RequestParam("questionId") int questionId,ExamQuestionBean eqb,HttpSession session) {
		
		QuestionBean question = examQuestionDao.getCourseIdByQuestionId(questionId);
		
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		
		
		eqb.setExamId(exam.getExamId());
		eqb.setQuestionId(questionId);
		
		examQuestionDao.addExamQuestion(eqb);
		
		
		
		return "redirect:/listexamquestions";
	}
	
	
	
	
	@GetMapping("deletequestionfromexamquestion/{questionId}")
	public String deleteQuestionFromExamQuestion(@PathVariable("questionId") int questionId,HttpSession hts) {
		
		
		QuestionBean question = examQuestionDao.getCourseIdByQuestionId(questionId);
		
		int courseId = question.getCourseId();
		hts.setAttribute("courseId", courseId);
		
		examQuestionDao.deleteFromExamQuestion(questionId);
		
	
		
		return "redirect:/showafterdelete";
		
	}
	
	@GetMapping("showafterdelete")
	public String showAfterDelete(Model model,HttpSession hts) {
		
		int courseId =(int) hts.getAttribute("courseId");
		
		QuestionBean que = examQuestionDao.getCourseNameByCourseId(courseId);
		String cName = que.getCourseName();
		
		
		int count=0;
		int totalMarks=0;
		List<QuestionBean> questions = examQuestionDao.getExamQuestions(courseId);
		for(int i=0;i<questions.size();i++) {
			questions.get(i).setCourseName(cName);
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		model.addAttribute("count",count);
		model.addAttribute("totalMarks",totalMarks);
		model.addAttribute("questions",questions);
		
		return "ListAddedExamQuestions";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/newexamquestion")
	public String newExamQuestion(Model model) {
		
		List<CourseBean> courses = courseDao.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "NewExamQuestion";
	}
	
	@PostMapping("/saveexamquestion")
	public String saveExamQuestion(QuestionBean question,HttpSession hts) {
		
		questionDao.addQuestion(question);
		
		List<QuestionBean> questions = examDao.getExamQuestions(question.getCourseId());
		
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
		examDao.updateMarksCount(exam);
		
		int courseId = question.getCourseId();
		hts.setAttribute("courseId", courseId);
		
		
		return "redirect:/listexamquestions";
	}
	
	
	@GetMapping("/deleteexamquestion/{questionId}")
	public String deleteExamQuestion(@PathVariable("questionId") int questionId,HttpSession hts) {
		
		
		QuestionBean question = examQuestionDao.getCourseIdByQuestionId(questionId);
		
		int courseId = question.getCourseId();
		hts.setAttribute("courseId", courseId);
		
		questionDao.deleteQuestion(questionId);
		
		List<QuestionBean> questions = examDao.getExamQuestions(question.getCourseId());
		
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
		examDao.updateMarksCount(exam);
		
		

		return "redirect:/listexamquestions";
		
	}
	
	
	
	
	@GetMapping("/editexamquestion")
	public String editExamQuestion(@RequestParam("questionId") int questionId,Model model) {
		
		QuestionBean question = questionDao.getQuestionById(questionId);
		model.addAttribute("question",question);
		
		return "EditExamQuestion";
		
	}
	
	@PostMapping("/updateexamquestion")
	public String updateExamQuestion(QuestionBean question,HttpSession hts) {
		
		questionDao.updateQuestion(question);
		
		List<QuestionBean> questions = examDao.getExamQuestions(question.getCourseId());
		
		int totalMarks=0;
		int count=0;
		for(int i=0;i<questions.size();i++) {
			totalMarks = questions.get(i).getQuestionMarks() + totalMarks;
			count++;
		}
		ExamBean exam = examQuestionDao.getExamByCourseId(question.getCourseId());
		
		exam.setTotalMarks(totalMarks);
		exam.setNoOfQuestion(count);
		
		examDao.updateMarksCount(exam);
		
		int courseId = question.getCourseId();
		hts.setAttribute("courseId", courseId);
		
		
		return "redirect:/listexamquestions";
		
		
	}
	
	
	
	
	
	
	
}
