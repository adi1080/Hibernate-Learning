package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
	@Id
private int cid;
private String cName;
@ManyToMany(cascade = CascadeType.ALL)
private Set<Student> s=new HashSet();
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public Set<Student> getS() {
	return s;
}
public void setS(Set<Student> s) {
	this.s = s;
}

}
