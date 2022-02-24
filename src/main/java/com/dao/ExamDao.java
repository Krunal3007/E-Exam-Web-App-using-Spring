package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExamBean;
import com.bean.QuestionBean;

@Repository
public class ExamDao {
	
	@Autowired
	JdbcTemplate stmt;
	


public void addExam(ExamBean exam) {
	
	stmt.update("insert into exam(courseid,duration,noofquestion,instructions,totalmarks) values(?,?,?,?,?)",exam.getCourseId(),
			exam.getDuration(),exam.getNoOfQuestion(),exam.getInstructions(),exam.getTotalMarks());
}

public List<ExamBean> getAllExams() {
	
	List<ExamBean> exams = stmt.query("select e.*,c.courseName from exam e,course c where e.courseid=c.courseid", 
			new BeanPropertyRowMapper<ExamBean>(ExamBean.class));
	
	return exams;
}




public List<QuestionBean> getExamQuestions(int courseId) {
	
	List<QuestionBean> questions = stmt.query("select * from question where courseid=?", 
			new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),new Object[] {courseId});
	
	return questions;
}

public void deleteExam(int examId) {

	stmt.update("delete from exam where examid=?",examId);
}

public ExamBean getExamById(int examId) {
	
	ExamBean exam = stmt.queryForObject("select * from exam where examid = ?", new BeanPropertyRowMapper<ExamBean>(ExamBean.class),
			new Object[] {examId});
	
	return exam;
	
}

public void updateExam(ExamBean exam) {
	
	stmt.update("update exam set duration=?,instructions=?",exam.getDuration(),exam.getInstructions());
}

public void updateMarksCount(ExamBean exam) {
	
	stmt.update("update exam set noofquestion=?,totalmarks=? where examid=?",exam.getNoOfQuestion(),exam.getTotalMarks(),exam.getExamId());
}


}
