package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person {
@Id
private int pid;
private String pname;

@OneToOne(cascade = CascadeType.ALL)   // use , mappedBy="p" so that in person database table foreign
private AdharCard ad;                  // key column will not be created

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public AdharCard getAd() {
	return ad;
}

public void setAd(AdharCard ad) {
	this.ad = ad;
}


}
