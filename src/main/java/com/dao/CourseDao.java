package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;

@Repository
public class CourseDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	public void addCourse(CourseBean course) {
		
		stmt.update("insert into course(coursename,isactive,description) values (?,?,?)",course.getCourseName(),course.getIsActive(),course.getDescription());
	}

	public List<CourseBean> getAllCourses() {
		
		List<CourseBean> courses = stmt.query("select * from course",new BeanPropertyRowMapper<CourseBean>(CourseBean.class));
		
		return courses;
	}
	
	public void deleteCourse(int courseId) {
		stmt.update("delete from course where courseid = ?",courseId);
	}
	
	public CourseBean getCourseById(int courseId) {
		
		CourseBean course = stmt.queryForObject("select * from course where courseid = ?", 
				new BeanPropertyRowMapper<CourseBean>(CourseBean.class),new Object[] {courseId} );
		
		return course;
	}
	
	public void updateCourse(CourseBean course) {
		
		stmt.update("update course set coursename = ?,description = ?,isactive=? where courseid=?",
				course.getCourseName(),course.getDescription(),course.getIsActive(),course.getCourseId());
	}
}
