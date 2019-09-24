package com.jocata.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BookIssue")
public class BookIssue {
	
	@Id
	@GeneratedValue
	@Column(name="bookIssueId")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="studid")
	private Student studid;
	
	@ManyToOne
	@JoinColumn(name="bookMasterId")
	private BookMaster bookid;
	
	@Column(name="issuedate")
	private Date issueDate;
	
	@Column(name="noofdays")
	private int noDfDays;
	
	
	@ManyToOne
	@JoinColumn(name="issuedby")
	private UserMaster issuedBy;
	
	@Column(name="returned")
	private int returned;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudid() {
		return studid;
	}

	public void setStudid(Student studid) {
		this.studid = studid;
	}

	public BookMaster getBookid() {
		return bookid;
	}

	public void setBookid(BookMaster bookid) {
		this.bookid = bookid;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getNoDfDays() {
		return noDfDays;
	}

	public void setNoDfDays(int noDfDays) {
		this.noDfDays = noDfDays;
	}

	public UserMaster getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(UserMaster issuedBy) {
		this.issuedBy = issuedBy;
	}

	public int getReturned() {
		return returned;
	}

	public void setReturned(int returned) {
		this.returned = returned;
	}

	public BookIssue() {
		super();
		
	}

	public BookIssue(int id, Student studid, BookMaster bookid, Date issueDate, int noDfDays, UserMaster issuedBy,
			int returned) {
		super();
		this.id = id;
		this.studid = studid;
		this.bookid = bookid;
		this.issueDate = issueDate;
		this.noDfDays = noDfDays;
		this.issuedBy = issuedBy;
		this.returned = returned;
	}

	@Override
	public String toString() {
		return "BookIssue [id=" + id + ", studid=" + studid + ", bookid=" + bookid + ", issueDate=" + issueDate
				+ ", noDfDays=" + noDfDays + ", issuedBy=" + issuedBy + ", returned=" + returned + "]";
	}
	
	
	
}
