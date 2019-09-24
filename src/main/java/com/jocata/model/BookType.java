package com.jocata.model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="BookType")
public class BookType {
	
	@Id
	@GeneratedValue
	@Column(name="bookTypeId")
	private int id;
	
	@Column(name="bookcategory")
	private String bookCategory;
	
	
	//@OneToMany(mappedBy="id",cascade=CascadeType.ALL)
	//private List<BookMaster> bookmaster;


	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	

	public BookType(int id, String bookCategory, String description) {
		super();
		this.id = id;
		this.bookCategory = bookCategory;
		
	}

	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
