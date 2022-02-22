package com.bean;

public class ExamQuestionBean {
	
	private int examQuestionId;
	private  static int courseId;
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
