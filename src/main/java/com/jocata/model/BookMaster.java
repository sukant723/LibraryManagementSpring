package com.jocata.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name="BookMaster")
@Component
@Scope(value="prototype")
public class BookMaster {
			
	@Id
	@GeneratedValue
	@Column(name="bookMasterId")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="pkbooktypeid")
	private BookType bookType;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="publication")
	private String publication;
	
	@Column(name="yearofpublication")
	private String yearOfPublication;
	
	@Column(name="ebookurl")
	private String ebookUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getEbookUrl() {
		return ebookUrl;
	}

	public void setEbookUrl(String ebookUrl) {
		this.ebookUrl = ebookUrl;
	}

	

	public BookMaster(int id, BookType bookType, String title, String description, String publication,
			String yearOfPublication, String ebookUrl) {
		super();
		this.id = id;
		this.bookType = bookType;
		this.title = title;
		this.description = description;
		this.publication = publication;
		this.yearOfPublication = yearOfPublication;
		this.ebookUrl = ebookUrl;
	}

	public BookMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
