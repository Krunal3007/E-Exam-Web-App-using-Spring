package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.ExamQuestionBean;
import com.bean.QuestionBean;


@Repository
public class ExamQuestionDao {

	@Autowired
	JdbcTemplate stmt;
	
	public List<CourseBean> getAllCourses() {
		
		List<CourseBean> courses = stmt.query("select * from course",new BeanPropertyRowMapper<CourseBean>(CourseBean.class));
		
		return courses;
	}
	
	public List<QuestionBean> getAllExamQuestions(int courseId) {
		
		List<QuestionBean> questions = stmt.query("select q.*,c.coursename from question q,course c where q.courseid=c.courseid and q.courseid=?", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {courseId});
		
		return questions;
	}
	
	public List<QuestionBean> getExamQuestions(int courseId) {
		List<QuestionBean> questions=null;
		try {
			questions = stmt.query("select q.*,e.* from question q,examquestion e where q.questionid = e.questionid and courseid=?", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {courseId});
		}
		catch(Exception e) {}
		return questions;
	}
	
	public void deleteFromExamQuestion(int questionId) {
		
		stmt.update("delete from examquestion where questionid = ?",questionId);
		
	}
	
	
	
	public QuestionBean getCourseIdByQuestionId(int questionId) {
		
		QuestionBean question = stmt.queryForObject("select * from question where questionid=?", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {questionId});
	
		return question;
	}
	
	public ExamBean getExamByCourseId(int courseId) {
		ExamBean exam=null;
		try {
		 exam = stmt.queryForObject("select * from exam where courseid=?", 
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {courseId});
		}
		catch(Exception e) {
			
		}
		return exam;
	}
	
	public void addExamQuestion(ExamQuestionBean eqb) {
		
		stmt.update("insert into examquestion(examid,questionid) values(?,?)",eqb.getExamId(),eqb.getQuestionId());
	}
	
	public ExamBean isQuestionIdAvailable(int questionId) {
		ExamBean exambn=null;
		try {
			exambn = stmt.queryForObject("select * from examquestion where questionid=?", 
					new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {questionId});
		}
		catch(Exception e) {
			
		}
		return exambn;
	}
	
	
	
	
}
