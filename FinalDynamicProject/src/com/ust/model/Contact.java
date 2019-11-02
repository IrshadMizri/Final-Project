package com.ust.model;

public class Contact {
	
	int cId;
	String cName;
	int cvId;
	String cDepartment;
	String cEmail;
	long  cPhone;
	String isActive;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int cId, String cName, int cvId, String cDepartment, String cEmail, long cPhone, String isActive) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cvId = cvId;
		this.cDepartment = cDepartment;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.isActive = isActive;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getCvId() {
		return cvId;
	}
	public void setCvId(int cvId) {
		this.cvId = cvId;
	}
	public String getcDepartment() {
		return cDepartment;
	}
	public void setcDepartment(String cDepartment) {
		this.cDepartment = cDepartment;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public long getcPhone() {
		return cPhone;
	}
	public void setcPhone(long cPhone) {
		this.cPhone = cPhone;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", cName=" + cName + ", cvId=" + cvId + ", cDepartment=" + cDepartment
				+ ", cEmail=" + cEmail + ", cPhone=" + cPhone + ", isActive=" + isActive + "]";
	}
	
	

}
