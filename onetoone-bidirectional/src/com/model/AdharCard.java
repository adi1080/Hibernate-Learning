package com.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AdharCard {
@Id
private int aid;
private String adharName;
@OneToOne(cascade = CascadeType.ALL)
private Person p;

public Person getP() {
	return p;
}
public void setP(Person p) {
	this.p = p;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAdharName() {
	return adharName;
}
public void setAdharName(String adharName) {
	this.adharName = adharName;
}


}
