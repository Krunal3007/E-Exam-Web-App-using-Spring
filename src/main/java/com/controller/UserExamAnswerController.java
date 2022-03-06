package com.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.bean.UserExamAnswerBean;
import com.bean.UserExamBean;
import com.dao.UserExamAnswerDao;

@Controller
public class UserExamAnswerController {
	
	@Autowired
	UserExamAnswerDao userExamAnswerDao;

	@GetMapping("usergivenexams")
	public String userGivenExams(HttpSession session,Model model) {
		
		UserBean dbuser =  (UserBean)session.getAttribute("user");
		
		List<UserExamBean> userGivenExams = userExamAnswerDao.getUserGivenExams(dbuser.getUserId());
		
		
		ArrayList<Integer> allCourseId = new ArrayList<Integer>();
		for(int i=0;i<userGivenExams.size();i++) {
			
			ExamBean exam = userExamAnswerDao.getCourseIdByExamId(userGivenExams.get(i).getExamId());
			int courseId = exam.getCourseId();
			allCourseId.add(courseId);
		}
		
		ArrayList<String> allCourseName = new ArrayList<String>();
		for(int i=0;i<userGivenExams.size();i++) {
			CourseBean course = userExamAnswerDao.getCourseNameByCourseId(allCourseId.get(i));
			String courseName = course.getCourseName();
			allCourseName.add(courseName);
		}
		
		
		for(int i=0;i<userGivenExams.size();i++) {
			userGivenExams.get(i).setCourseName(allCourseName.get(i));
		}
		
		
		LinkedHashSet<Integer> hs = new  LinkedHashSet<>();
		for(int i=0;i<userGivenExams.size();i++) {
			hs.add(userGivenExams.get(i).getExamId());
		}
		LinkedHashSet<String> hs1 = new LinkedHashSet<>();
		for(int i=0;i<userGivenExams.size();i++) {
			hs1.add(userGivenExams.get(i).getCourseName());
		}
		
		
		ArrayList<Integer> a = new ArrayList<>(hs);
		
		ArrayList<String> b = new ArrayList<>(hs1);
 		
 		
		
		model.addAttribute("examId",a);
		model.addAttribute("courseName",b);
		
		
		return "ListUserGivenExams";
	}
	
	
	@GetMapping("viewuserresult")
	public String viewUserResult(@RequestParam("examId") int examId,HttpSession hts,Model model) {
		
		UserBean dbuser = (UserBean)hts.getAttribute("user");
		
		UserExamAnswerBean userExamAnswer = userExamAnswerDao.viewResult(dbuser.getUserId(),examId);
		model.addAttribute("userExamAnswer",userExamAnswer);
		
		
		
		return "ListUserResult";
	}
	
	
}
