package com.jocata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class BookMasterDto {

	private int id;
	private int PKBookTypeId;
	private String Title;
	private String Description;
	private String Publication;
	private String YearOfPublication;
	private String EbookUrl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPKBookTypeId() {
		return PKBookTypeId;
	}
	public void setPKBookTypeId(int pKBookTypeId) {
		PKBookTypeId = pKBookTypeId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPublication() {
		return Publication;
	}
	public void setPublication(String publication) {
		Publication = publication;
	}
	public String getYearOfPublication() {
		return YearOfPublication;
	}
	public void setYearOfPublication(String yearOfPublication) {
		YearOfPublication = yearOfPublication;
	}
	public String getEbookUrl() {
		return EbookUrl;
	}
	public void setEbookUrl(String ebookUrl) {
		EbookUrl = ebookUrl;
	}
	
	
}
