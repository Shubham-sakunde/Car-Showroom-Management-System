package com.tka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShowroomB {

	@Id
	int showNo;
	String showAddress;
	int showContact;
	
	
	
	public void setShowNo(int showNo) {
		this.showNo = showNo;
	}
	
	public int getShowNo() {
		return showNo;
	}
	
	
	
	public void setShowAddress(String showAddress) {
		this.showAddress = showAddress;
	}
	
	public String getShowAddress() {
		return showAddress;
	}
	
	
	public void setShowContact(int showContact) {
		this.showContact = showContact;
	}
	
	public int getShowContact() {
		return showContact;
	}


	
	public String toString() {
		return "ShowroomB [showNo=" + showNo + ", showAddress=" + showAddress + ", showContact=" + showContact + "]";
	}
	
	
}
