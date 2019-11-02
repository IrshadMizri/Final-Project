package com.ust.model;

public class Combined {
	int vId;
	String vName;
	String vAddress;
	String vLocation;
	String vService;
	double vPincode;
	String isActive;
	int cId;
	String cName;
	String cDepartment;
	String cEmail;
	long  cPhone;
	
	public Combined() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Combined(int vId, String vName, String vAddress, String vLocation, String vService, double vPincode,
			String isActive, int cId, String cName, String cDepartment, String cEmail, long cPhone) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddress = vAddress;
		this.vLocation = vLocation;
		this.vService = vService;
		this.vPincode = vPincode;
		this.isActive = isActive;
		this.cId = cId;
		this.cName = cName;
		this.cDepartment = cDepartment;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
	}



	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvAddress() {
		return vAddress;
	}
	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}
	public String getvLocation() {
		return vLocation;
	}
	public void setvLocation(String vLocation) {
		this.vLocation = vLocation;
	}
	public String getvService() {
		return vService;
	}
	public void setvService(String vService) {
		this.vService = vService;
	}
	public double getvPincode() {
		return vPincode;
	}
	public void setvPincode(double vPincode) {
		this.vPincode = vPincode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
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
	
	

}
