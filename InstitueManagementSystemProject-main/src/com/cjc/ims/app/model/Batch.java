package com.cjc.ims.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Batch {
	@Id
private int batchId;
private String batchName;
@OneToOne(cascade = CascadeType.ALL)
private Faculty f;

public int getBatchId() {
	return batchId;
}
public void setBatchId(int batchId) {
	this.batchId = batchId;
}
public String getBatchName() {
	return batchName;
}
public void setBatchName(String batchName) {
	this.batchName = batchName;
}
public Faculty getF() {
	return f;
}
public void setF(Faculty f) {
	this.f = f;
}
@Override
public String toString() {
	return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", f=" + f + "]";
}
}
