package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity     //it maps pojo class with database table
public class Student {

	@Id      //indicate primary key in table
	private int rollno;
	private String name;
	private long mobileno;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "s")
//	@JoinTable(name="course_student" , joinColumns = {@JoinColumn(name="sid")},
//	inverseJoinColumns = {@JoinColumn(name="cid")})
private Set<Course> c=new HashSet<Course>();
	
	public Set<Course> getC() {
		return c;
	}
	public void setC(Set<Course> c) {
		this.c = c;
	}
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
