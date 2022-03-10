package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExamBean;
import com.bean.UserBean;
import com.bean.UserExamBean;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate stmt;
	
	
	public List<ExamBean> getRemainingExams(int userId) {
		
		List<ExamBean> exam = stmt.query("select e.*,c.coursename from exam e,course c where e.examid not in (select examid from userexam where userid=?)"
				+ "and e.courseid=c.courseid", 
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {userId});
	
		return exam;
	}
	
	public List<UserExamBean> getUserGivenExams(int userId) {
		
		List<UserExamBean> ueb = stmt.query("select userid,examid from userexam where userid=?", 
				new BeanPropertyRowMapper<UserExamBean>(UserExamBean.class),new Object[] {userId});
		
		
		return ueb;
	}
	
	public UserBean getStudentProfile(int userId) {
		
		UserBean student = stmt.queryForObject("select * from users where userid =?", 
				new BeanPropertyRowMapper<UserBean>(UserBean.class),new Object[] {userId});
		
		return student;
	}
	
	public void updateStudentProfile(UserBean user) {
		
		stmt.update("update users set firstname=?,email=?,xender=?,phoneno=?,address=?,city=?,state=?,pincode=?"
				+ "where userid=?",user.getFirstName(),user.getEmail(),user.getXender(),user.getPhoneNo(),user.getAddress(),
				user.getCity(),user.getState(),user.getPincode(),user.getUserId());
		
	}
	
}
