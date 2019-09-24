package com.jocata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class BookTypeDto {
	
	
	private int id;
	

	private String BookCategory;
	
	private String Description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookCategory() {
		return BookCategory;
	}

	public void setBookCategory(String bookCategory) {
		BookCategory = bookCategory;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	
	
}
