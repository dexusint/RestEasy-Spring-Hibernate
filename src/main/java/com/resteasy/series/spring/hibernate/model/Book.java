package com.resteasy.series.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	// member variables
	@Id 
	@GeneratedValue
	@Column(name = "BOOK_ID")
	private int bookId;

	@Column(name= "AUTHOR")
	private String author;

	@Column(name= "TITLE")
	private String title;

	// default constructor
	public Book() {
		super();
	}

	// 3-arg parameterized-constructor
	public Book(int bookId, String author, String title) {
		super();
		this.bookId = bookId;
		this.author = author;
		this.title = title;
	}

	// getters & setters
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}