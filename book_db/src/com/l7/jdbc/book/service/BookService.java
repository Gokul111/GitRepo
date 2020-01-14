package com.l7.jdbc.book.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.l7.jdbc.book.daoimpl.AuthorDaoImpl;
import com.l7.jdbc.book.daoimpl.BookDaoImpl;
import com.l7.jdbc.book.dto.Book;
import com.l7.jdbc.book.exception.BookException;

public class BookService {
	List<Book> bookObjList = new ArrayList<Book>();
	int i;

	public int createBook(String bookName, String authorName) throws IOException, SQLException, BookException {
		// validate
		bookName = bookName.trim();
		authorName = authorName.trim();
		if (!doesExist(bookName, authorName) && !isNull(bookName, authorName)) {
			BookDaoImpl daoobj = new BookDaoImpl();
			i = daoobj.createBook(bookName, authorName);
		} else if (doesExist(bookName, authorName)) {
			i = 0;
			throw new BookException("Data already Exists!!! Please Try Again.");
		} else if (isNull(bookName, authorName)) {
			i = 0;
			throw new BookException("Names cannot be Empty!!! Please Try Again.");
		} else if (bookName.length() > 35 || authorName.length() > 35) {
			i = 0;
			throw new BookException("Maximum 35 characters allowed as Input!!! Please Try Again.");
		}

		return i;
	}

	public int deleteBook(int bookId) throws IOException, SQLException {
		// validate
		if (bookId > 0) {
			BookDaoImpl daoobj = new BookDaoImpl();
			i = daoobj.deleteBook(bookId);
		} else {
			i = 0;
		}
		return i;
	}

	public void readBook(String bookName) throws IOException, SQLException {
		// validate
		BookDaoImpl daoobj = new BookDaoImpl();
		daoobj.readBook(bookName);
	}

	public int updateBook(int bookId, String newBookName) throws IOException, SQLException {
		newBookName = newBookName.trim();
		if (newBookName != null && !newBookName.contentEquals("")) {
			BookDaoImpl daoobj = new BookDaoImpl();
			i = daoobj.updateBook(bookId, newBookName);
		} else {
			i = 0;
		}
		return i;
	}

	public int updateAuthor(int bookId, String newAuthorName) throws IOException, SQLException {
		AuthorDaoImpl daoobj = new AuthorDaoImpl();
		i = daoobj.updateAuthor(bookId, newAuthorName);
		return i;
	}

	public List<Book> getAllBooks() throws SQLException {
		// TODO Auto-generated method stub
		BookDaoImpl daoobj = new BookDaoImpl();
		bookObjList = daoobj.getAllBooks();
		return bookObjList;
	}

	private boolean doesExist(String bookName, String authorName) throws SQLException, IOException {

		List<Book> bookList = getAllBooks();
		for (Book book : bookList) {
			if (book.getBookName().equalsIgnoreCase(bookName)) {
				if (book.getAuthorName1().equalsIgnoreCase(authorName)) {
					return true;
				}
			}
		}
		return false;
	}

//	private boolean doesExist(String bookName) throws SQLException, IOException	 {
//		List<Book> bookList = getAllBooks();
//		for (Book book : bookList) {
//			if (book.getBookName().equalsIgnoreCase(bookName) ) {
//				
//			}
//
//		}
//		return false;
//
//	}

	private boolean isNull(String bookName, String authorName) {
		return (authorName == ("")) || (bookName == ("")) || (bookName.length() == 0) || (authorName.length() == 0);
	}
}
