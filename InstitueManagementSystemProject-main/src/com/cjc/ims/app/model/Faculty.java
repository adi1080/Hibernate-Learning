package com.cjc.ims.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Faculty {
	@Id
private int facultyId;
private String facultyName;
@OneToOne(cascade = CascadeType.ALL)
private Course c;


public int getFacultyId() {
	return facultyId;
}
public void setFacultyId(int facultyId) {
	this.facultyId = facultyId;
}
public String getFacultyName() {
	return facultyName;
}
public void setFacultyName(String facultyName) {
	this.facultyName = facultyName;
}
public Course getC() {
	return c;
}
public void setC(Course c) {
	this.c = c;
}
@Override
public String toString() {
	return "Faculty [facultyId=" + facultyId + ", facultyName=" + facultyName + ", c=" + c + "]";
}

}
