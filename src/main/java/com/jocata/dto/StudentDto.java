package com.jocata.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class StudentDto {

	private int id;
	
	
	private int DeptId;
	

	private String SName;
	
	
	private int RollNo;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getDeptId() {
		return DeptId;
	}


	public void setDeptId(int deptId) {
		DeptId = deptId;
	}


	public String getSName() {
		return SName;
	}


	public void setSName(String sName) {
		SName = sName;
	}


	public int getRollNo() {
		return RollNo;
	}


	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	
	

}
