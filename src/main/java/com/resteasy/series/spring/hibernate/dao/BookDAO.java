package com.resteasy.series.spring.hibernate.dao;

import java.util.List;

import com.resteasy.series.spring.hibernate.model.Book;

public interface BookDAO {

	public String insertNewBook(Book book);
	public Book getBook(int bookId);
	public String updateBook(Book book);
	public String deleteBook(Book book);
	public List<Book> getAllBook();
}