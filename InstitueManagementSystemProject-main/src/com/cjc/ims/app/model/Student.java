package com.cjc.ims.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
private int sId;
private String sName;
@OneToOne(cascade = CascadeType.ALL)
private Batch b;

public int getsId() {
	return sId;
}
public void setsId(int sId) {
	this.sId = sId;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public Batch getB() {
	return b;
}
public void setB(Batch b) {
	this.b = b;
}
@Override
public String toString() {
	return "Student [sId=" + sId + ", sName=" + sName + ", b=" + b + "]";
}


}
