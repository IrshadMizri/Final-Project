package com.ust.model;

public class Vendor {
	int vId;
	String vName;
	String vAddress;
	String vLocation;
	String vService;
	double vPincode;
	String isActive;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
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
	public Vendor(int vId, String vName, String vAddress, String vLocation, String vService, double vPincode,
			String isActive) {
		super();
		this.vId = vId;
		this.vName = vName;
		this.vAddress = vAddress;
		this.vLocation = vLocation;
		this.vService = vService;
		this.vPincode = vPincode;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Vendor [vId=" + vId + ", vName=" + vName + ", vAddress=" + vAddress + ", vLocation=" + vLocation
				+ ", vService=" + vService + ", vPincode=" + vPincode + ", isActive=" + isActive + "]";
	}
	
	
	
	

}
