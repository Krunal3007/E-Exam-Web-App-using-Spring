package com.bean;

public class SessionBean {
	
	private String signupFirstName;
	private String signupEmail;
	private String signupPassword;
	private String emailForPass;
	private String loginEmail;
	private String loginPassword;
	private int otp;
	
	private String signupGender;
	private String signupAddress;
	private String signupPhoneNo;
	private String signupCity;
	private String signupState;
	private int signupPincode;
	
	public int getOtp() {
		return otp;
	}
	public String getSignupGender() {
		return signupGender;
	}
	public void setSignupGender(String signupGender) {
		this.signupGender = signupGender;
	}
	public String getSignupAddress() {
		return signupAddress;
	}
	public void setSignupAddress(String signupAddress) {
		this.signupAddress = signupAddress;
	}
	public String getSignupPhoneNo() {
		return signupPhoneNo;
	}
	public void setSignupPhoneNo(String signupPhoneNo) {
		this.signupPhoneNo = signupPhoneNo;
	}
	public String getSignupCity() {
		return signupCity;
	}
	public void setSignupCity(String signupCity) {
		this.signupCity = signupCity;
	}
	public String getSignupState() {
		return signupState;
	}
	public void setSignupState(String signupState) {
		this.signupState = signupState;
	}
	public int getSignupPincode() {
		return signupPincode;
	}
	public void setSignupPincode(int signupPincode) {
		this.signupPincode = signupPincode;
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
