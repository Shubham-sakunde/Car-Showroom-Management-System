package com.tka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShowroomA {

	@Id
	int showNo;
	String showName;
	int totalCars;


	public void setShowNo(int showNo) {
		this.showNo = showNo;
	}

	public int getShowNo() {
		return showNo;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowName() {
		return showName;
	}

	public void setTotalCars(int totalCars) {
		this.totalCars = totalCars;
	}

	public int getTotalCars() {
		return totalCars;
	}

	
	
	public String toString() {
		return "ShowroomA [showNo=" + showNo + ", showName=" + showName + ", totalCars=" + totalCars + "]";
	}
	
	

}
