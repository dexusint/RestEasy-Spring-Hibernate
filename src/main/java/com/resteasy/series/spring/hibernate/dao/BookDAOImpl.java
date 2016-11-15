package com.resteasy.series.spring.hibernate.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.resteasy.series.spring.hibernate.model.Book;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO	 {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public String insertNewBook(Book book) {

		// inserts into database & return bookId (primary_key)
		int bookId = (Integer) sessionFactory.getCurrentSession().save(book);
		return "Book information saved successfully with Book_ID " + bookId;
	}

	@Override
	@Transactional
	public Book getBook(int bookId) {

		// retrieve book based on the id supplied in the formal argument
		Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, bookId);
		return book;
	}
	
	@Override
	@Transactional
	public String updateBook(Book book) {

		// update database with book information and return success msg
		sessionFactory.getCurrentSession().update(book);
		return "Book information updated successfully";
	}

	@Override
	@Transactional
	public String deleteBook(Book book) {

		// delete book information and return success msg
		sessionFactory.getCurrentSession().delete(book);
		return "Book information deleted successfully";
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Book> getAllBook() {

		// get all book info from database
		List<Book> lstBook = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
		return lstBook;
	}
}