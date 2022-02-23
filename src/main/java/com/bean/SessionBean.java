package com.bean;

public class SessionBean {
	
	private String signupFirstName;
	private String signupEmail;
	private String signupPassword;
	private String emailForPass;
	private String loginEmail;
	private String loginPassword;
	private int otp;
	
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getSignupFirstName() {
		return signupFirstName;
	}
	public void setSignupFirstName(String signupFirstName) {
		this.signupFirstName = signupFirstName;
	}
	public String getSignupEmail() {
		return signupEmail;
	}
	public void setSignupEmail(String signupEmail) {
		this.signupEmail = signupEmail;
	}
	public String getSignupPassword() {
		return signupPassword;
	}
	public void setSignupPassword(String signupPassword) {
		this.signupPassword = signupPassword;
	}
	
	public String getEmailForPass() {
		return emailForPass;
	}
	public void setEmailForPass(String emailForPass) {
		this.emailForPass = emailForPass;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}
