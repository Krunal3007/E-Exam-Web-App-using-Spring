package com.bean;

public class UserExamAnswerBean {

	private int userExamAnswerId;
	private int userId;
	private int examId;
	private int totalMarks;
	private int obtainMarks;
	private int isPass;
	
	private String firstName;
	private String examName;
	
	private float percentage;
	
	private String description;
	
	private String examDate;
	
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getUserExamAnswerId() {
		return userExamAnswerId;
	}
	public void setUserExamAnswerId(int userExamAnswerId) {
		this.userExamAnswerId = userExamAnswerId;
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
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getObtainMarks() {
		return obtainMarks;
	}
	public void setObtainMarks(int obtainMarks) {
		this.obtainMarks = obtainMarks;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	
	
}
