package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity     //it maps pojo class with database table
public class Student {

	@Id      //indicate primary key in table
	private int rollno;
	private String name;
	private long mobileno;
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
