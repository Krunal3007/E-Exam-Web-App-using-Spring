package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.RoleBean;
import com.bean.UserBean;

@Repository
public class AdminDao {

	@Autowired
	JdbcTemplate stmt;
	
	public List<UserBean> getTotalStudents() {
		
		List<UserBean> students = stmt.query("select * from users where roleid=5", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		
		return students;
	}
	
	public List<UserBean> getTotalTeachers() {
		
		List<UserBean> teachers = stmt.query("select * from users where roleid=6", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		
		return teachers;
	}
	
	public List<RoleBean> getAllRoles(){
		
		return stmt.query("select * from role", new BeanPropertyRowMapper<RoleBean>(RoleBean.class));
		
	}
	
	public List<CourseBean> getAllCourses(){
		
		return stmt.query("select * from course", new BeanPropertyRowMapper<CourseBean>(CourseBean.class));
		
	}
	
	public List<QuestionBean> getAllQuestions(){
		
		return stmt.query("select * from question", new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class));
		
	}
	
	public List<ExamBean> getAllExams(){
		
		return stmt.query("select * from exam", new BeanPropertyRowMapper<ExamBean>(ExamBean.class));
		
	}
	
}
