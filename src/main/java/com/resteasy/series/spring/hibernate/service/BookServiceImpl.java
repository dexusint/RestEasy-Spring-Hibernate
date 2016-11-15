package com.resteasy.series.spring.hibernate.service;

import in.benchresources.cdm.book.BookListType;
import in.benchresources.cdm.book.BookType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resteasy.series.spring.hibernate.dao.BookDAO;
import com.resteasy.series.spring.hibernate.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookDAO bookDAO;

	@Override
	public String createOrSaveNewBookInfo(BookType bookType) {

		Book newBook = new Book();
		newBook.setBookId(bookType.getBookId());
		newBook.setAuthor(bookType.getAuthor());
		newBook.setTitle(bookType.getTitle());
		return bookDAO.insertNewBook(newBook);
	}

	@Override
	public BookType getBookInfo(int bookId) {

		Book getBook = bookDAO.getBook(bookId);

		BookType bookType = new BookType();
		bookType.setBookId(getBook.getBookId());
		bookType.setAuthor(getBook.getAuthor());
		bookType.setTitle(getBook.getTitle());
		return bookType;
	}
	
	@Override
	public String deleteBook(int bookId) {

		Book removeBook = bookDAO.getBook(bookId);
		return bookDAO.deleteBook(removeBook);
	}


	@Override
	public String updateBookInfo(BookType bookType) {

		Book modifyBook = new Book();
		modifyBook.setBookId(bookType.getBookId());
		modifyBook.setAuthor(bookType.getAuthor());
		modifyBook.setTitle(bookType.getTitle());
		return bookDAO.updateBook(modifyBook);
	}

	@Override
	public String deleteBookInfo(BookType bookType) {

		Book removeBook = new Book();
		removeBook.setBookId(bookType.getBookId());
		removeBook.setAuthor(bookType.getAuthor());
		removeBook.setTitle(bookType.getTitle());
		return bookDAO.deleteBook(removeBook);
	}

	@Override
	public BookListType getAllBookInfo() {

		List<Book> lstBook = bookDAO.getAllBook();
		BookListType bookListType = new BookListType();

		for(Book book : lstBook){
			BookType bookType = new BookType();
			bookType.setBookId(book.getBookId());
			bookType.setAuthor(book.getAuthor());
			bookType.setTitle(book.getTitle());
			bookListType.getBookType().add(bookType);
		}
		return bookListType;
	}
}