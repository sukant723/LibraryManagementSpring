package com.jocata.model;


import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="deptid")
	private Department deptId;
	
	@Column(name="Sname")
	private String sName;
	
	@Column(name="rollno")
	private int rollNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="photo")
	private Blob photo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, Department deptId, String sName, int rollNo, String email, Blob photo) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.sName = sName;
		this.rollNo = rollNo;
		this.email = email;
		this.photo = photo;
	}

	 
}