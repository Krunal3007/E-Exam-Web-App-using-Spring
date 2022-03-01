package com.bean;

import java.util.ArrayList;

public class UserExamBean {
	
	private int userExamId;
	private int userId;
	private int examId;
	
	private ArrayList<Integer> userExamQuestionId = new ArrayList<Integer>();
	private ArrayList<String> answer = new ArrayList<String>();
	
	private ArrayList<String> userExamAnswer = new ArrayList<String>();
	
	
	public ArrayList<String> getUserExamAnswer() {
		return userExamAnswer;
	}
	public void setUserExamAnswer(ArrayList<String> userExamAnswer) {
		this.userExamAnswer = userExamAnswer;
	}
	public ArrayList<String> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
	
	
	
	public ArrayList<Integer> getUserExamQuestionId() {
		return userExamQuestionId;
	}
	public void setUserExamQuestionId(ArrayList<Integer> userExamQuestionId) {
		this.userExamQuestionId = userExamQuestionId;
	}
	public int getUserExamId() {
		return userExamId;
	}
	public void setUserExamId(int userExamId) {
		this.userExamId = userExamId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	
	
}