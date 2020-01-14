package com.l7.jdbc.book.dao;

import java.io.IOException;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;
//
//import com.l7.jdbc.book.dto.Book;
import java.util.List;

import com.l7.jdbc.book.dto.Book;

public interface BookDAO {
	 public void readBook(String bookName) throws IOException, SQLException;
	 public int createBook(String bookName, String authorName) throws IOException, SQLException;
	 public int deleteBook(int bookName) throws IOException, SQLException;
	 public int updateBook(int bookName, String newBookName) throws SQLException, IOException;
	 public List<Book> getAllBooks() throws SQLException;
//	 public ResultSet new1();
}
