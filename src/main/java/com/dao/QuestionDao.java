package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.bean.QuestionBean;

@Repository
public class QuestionDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void addQuestion(QuestionBean question) {
		
		stmt.update("insert into question(questionname,questionmarks,questionanswer,courseid,option1,option2,"
				+ "option3,option4,isactive) values (?,?,?,?,?,?,?,?,?)",question.getQuestionName(),
				question.getQuestionMarks(),question.getQuestionAnswer(),question.getCourseId(),question.getOption1(),
				question.getOption2(),question.getOption3(),question.getOption4(),1);
		
	}
	
	public List<QuestionBean> getAllQuestions() {
		
		List<QuestionBean> questions = stmt.query("select q.*,c.coursename from question q,course c where "
				+ "q.courseid = c.courseid", new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class));
		
		return questions;
		
	}
	
	public void deleteQuestion(int questionId) {
		
		stmt.update("delete from question where questionid=?",questionId);
		
	}
	
	public QuestionBean getQuestionById(int questionId) {
		
		QuestionBean question = stmt.queryForObject("select q.*,c.coursename from question q,course c where "
				+ "q.courseid = c.courseid and questionid = ?", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {questionId});
		
		return question;
		
	}
	
	public void updateQuestion(QuestionBean question) {
		
		 stmt.update("update question set questionname=?,questionmarks=?,questionanswer=?,option1=?,option2=?,"
				+ "option3=?,option4=?,isactive=? where questionid=?",question.getQuestionName(),
				question.getQuestionMarks(),question.getQuestionAnswer(),question.getOption1(),question.getOption2(),
				question.getOption3(),question.getOption4(),question.getIsActive(),question.getQuestionId());
	
		
	}
	
	public List<QuestionBean> getQuestionByCourseId(int courseId) {
		
		List<QuestionBean> question = stmt.query("select q.*,c.coursename from question q,course c where "
				+ "q.courseid = c.courseid and c.courseid = ?", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {courseId});
		
		return question;
		
	}

}
