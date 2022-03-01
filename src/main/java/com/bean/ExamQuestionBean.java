package com.bean;

public class ExamQuestionBean {
	
	private int examQuestionId;
	private  static int courseId;
	private int examId;
	private int questionId;
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getExamQuestionId() {
		return examQuestionId;
	}
	public void setExamQuestionId(int examQuestionId) {
		this.examQuestionId = examQuestionId;
	}
	public static int getCourseId() {
		return courseId;
	}
	public static void setCourseId(int courseId) {
		ExamQuestionBean.courseId = courseId;
	}
	
	
	
	

}
