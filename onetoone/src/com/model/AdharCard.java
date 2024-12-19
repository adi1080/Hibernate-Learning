package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AdharCard {
@Id
private int aid;
private String adharName;
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
