package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ExamBean;
import com.bean.UserExamBean;

@Repository
public class UserExamDao {

	@Autowired
	JdbcTemplate stmt;
	
	public List<ExamBean> getUserExams(int userId) {
		
		List<ExamBean> exam = stmt.query("select e.*,c.coursename from exam e,course c where e.examid not in (select examid from userexam where userid=?)"
				+ "and e.courseid=c.courseid", 
				new BeanPropertyRowMapper<ExamBean>(ExamBean.class),new Object[] {userId});
	
		return exam;
	}
	
	
	
	
	public void addIntoUserExam(UserExamBean ueb,int qId,String ans) {

		
		
//		int ar[] = new int[ueb.getUserExamQuestionId().size()];
//		for(int i=0;i<ueb.getUserExamQuestionId().size();i++) {
//			ar[i]=ueb.getUserExamQuestionId().get(i);
//		}
//
//		String sr[] = new String[ueb.getUserExamAnswer().size()];
//		for(int i=0;i<ueb.getUserExamAnswer().size();i++) {
//			sr[i] = ueb.getUserExamAnswer().get(i);
//		}
				


		
		stmt.update("insert into userexam (userid,examid,questionid,useranswer) values(?,?,?,?)",ueb.getUserId(),ueb.getExamId(),qId,ans);
		
		
		

		
	}
	
}
