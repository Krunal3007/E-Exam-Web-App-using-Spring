package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.bean.UserExamAnswerBean;
import com.bean.UserExamBean;

@Repository
public class UserExamAnswerDao {

	@Autowired
	JdbcTemplate stmt;
	
	public List<UserExamBean> getUserGivenExams(int userId) {
		
		List<UserExamBean> ueb = stmt.query("select userid,examid from userexam where userid=?", 
				new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {userId});
		
		
		return ueb;
	}
	
	public ExamBean getCourseIdByExamId(int examId) {
		
		ExamBean exam = stmt.queryForObject("select * from exam where examid =?", 
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {examId});
	
		return exam;
	}
	public ExamBean getExamIdByCourseId(int courseId) {
		ExamBean exam=null;
		try {
		 exam = stmt.queryForObject("select * from exam where courseid =?", 
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {courseId});
		}
		catch(Exception e) {}
		return exam;
	}
	public List<UserExamAnswerBean> getResultByCourseId(int examId) {
		return stmt.query("select * from userexamanswer where examid = ?", 
				new BeanPropertyRowMapper<UserExamAnswerBean>(UserExamAnswerBean.class),new Object[] {examId});
	}
	
	public CourseBean getCourseNameByCourseId(int courseId) {
		
		CourseBean course = stmt.queryForObject("select * from course where courseId=?", 
				new BeanPropertyRowMapper<CourseBean>(CourseBean.class),new Object[] {courseId});
	
		return course;
	}
	
	public List<UserExamBean> getUserGivenExamQuestions(int userId,int examId) {
		
		List<UserExamBean> user = stmt.query("select * from userexam where userid=? and examid=? ", 
				new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {userId,examId});
	
		return user;
		
	}
	
	public QuestionBean getQuestionByQuestionId(int questionId) {
		
		QuestionBean question = stmt.queryForObject("select * from question where questionid=? ", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {questionId});
		
		return question;
		
	}
	
	public void addUserExamAnswer(int userId,int examId,int totalMarks,int obtainMarks,int isPass,String examDate) {
		
		stmt.update("insert into userexamanswer(userid,examid,totalmarks,obtainmarks,ispass,examdate) values(?,?,?,?,?,?)",
				userId,examId,totalMarks,obtainMarks,isPass,examDate);
		
	}
	
	public UserExamAnswerBean viewResult(int userId,int examId) {
		
		UserExamAnswerBean ueb = stmt.queryForObject("select * from userexamanswer where userid=? and examid=?",
				new BeanPropertyRowMapper<UserExamAnswerBean>(UserExamAnswerBean.class),new Object[] {userId,examId});
		
		return ueb;
		
	}
	
	public List<UserExamAnswerBean> getAllUser() {
		
		List<UserExamAnswerBean> ueb = stmt.query("select * from userexamanswer ",
				new BeanPropertyRowMapper<UserExamAnswerBean>(UserExamAnswerBean.class));
		
		return ueb;
		
	}
	public List<UserBean> getAllStudents(){
		List<UserBean> user = stmt.query("select * from users where roleid=5", 
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
	
		return user;
	}
	
	public List<UserExamAnswerBean> getUserByUserId(int userId) {
		
		List<UserExamAnswerBean> ueb = stmt.query("select * from userexamanswer where userid=?",
				new BeanPropertyRowMapper<UserExamAnswerBean>(UserExamAnswerBean.class),new Object[] {userId});
		
		return ueb;
		
	}
	
	
	
}
