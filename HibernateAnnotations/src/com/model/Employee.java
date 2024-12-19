package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Table(name="employee")  //used to change database table name
@Entity // used to connect java pojo class with database table
public class Employee {

	@Id  //primary key in database
	@GeneratedValue(strategy = GenerationType.AUTO)  //used to automatically generate value
	private int id;                                  //use IDENTITIY instead of AUTO to make database handle it
	                                                 //in database go to table settings and select generated
	
	@Column(nullable = false)//property means that name cannot be empty
	private String name;
	
	@Transient //used so that the field a will not be added in database
	private int a;
	@Transient
	private int b;
	
	@Column(name="mob", unique = true) //used to change column name and give property
	private long mobileno;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public long getMobileno() {
		return mobileno;
	}

	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
}
