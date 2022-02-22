package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;
import com.bean.QuestionBean;


@Repository
public class ExamQuestionDao {

	@Autowired
	JdbcTemplate stmt;
	
	public List<CourseBean> getAllCourses() {
		
		List<CourseBean> courses = stmt.query("select * from course",new BeanPropertyRowMapper<CourseBean>(CourseBean.class));
		
		return courses;
	}
	
	public List<QuestionBean> getExamQuestions(int courseId) {
		
		List<QuestionBean> questions = stmt.query("select q.*,c.coursename from question q,course c where q.courseid=c.courseid and q.courseid=?", 
				new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {courseId});
		
		return questions;
	}
	
}
