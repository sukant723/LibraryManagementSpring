package com.jocata.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class BookIssueDto {
	
	private int id;
	private int Studid;
	private int Bookid;
	private Date IssueDate;
	private int NoDfDays;
	private int IssuedBy;
	private int Returned;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudid() {
		return Studid;
	}
	public void setStudid(int studid) {
		Studid = studid;
	}
	public int getBookid() {
		return Bookid;
	}
	public void setBookid(int bookid) {
		Bookid = bookid;
	}
	public Date getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(Date issueDate) {
		IssueDate = issueDate;
	}
	public int getNoDfDays() {
		return NoDfDays;
	}
	public void setNoDfDays(int noDfDays) {
		NoDfDays = noDfDays;
	}
	public int getIssuedBy() {
		return IssuedBy;
	}
	public void setIssuedBy(int issuedBy) {
		IssuedBy = issuedBy;
	}
	public int getReturned() {
		return Returned;
	}
	public void setReturned(int returned) {
		Returned = returned;
	}
	
	
	
	
}
