package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
@Id
private int eid;
private String ename;
@ManyToOne(cascade = CascadeType.ALL)
private Department d;


public Department getD() {
	return d;
}
public void setD(Department d) {
	this.d = d;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}

}
