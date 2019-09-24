package com.jocata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name="deptid")
	private int id;
	
	@Column(name="dname")
	private String dName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDName() {
		return dName;
	}

	public void setDName(String dName) {
		this.dName = dName;
	}

	public Department(int id, String dName) {
		super();
		this.id = id;
		this.dName = dName;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
}
