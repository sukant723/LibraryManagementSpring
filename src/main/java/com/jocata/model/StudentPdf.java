package com.jocata.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentpdf")
public class StudentPdf {

	@Id
	@GeneratedValue
	@Column(name="pdfid")
	private int pdfid;
	
	@OneToOne
	@JoinColumn(name="sid")
	private Student sid;
	
	@Column(name ="pdf")
	private Blob pdf;

	public int getPdfid() {
		return pdfid;
	}

	public void setPdfid(int pdfid) {
		this.pdfid = pdfid;
	}

	public Student getSid() {
		return sid;
	}

	public void setSid(Student sid) {
		this.sid = sid;
	}

	public Blob getPdf() {
		return pdf;
	}

	public void setPdf(Blob pdf) {
		this.pdf = pdf;
	}

	public StudentPdf(int pdfid, Student sid, Blob pdf) {
		super();
		this.pdfid = pdfid;
		this.sid = sid;
		this.pdf = pdf;
	}

	public StudentPdf() {
		super();

	}
	
	
	
	
}
