package com.l7.jdbc.book.dto;

import java.util.List;

public class Book {
	private int bookId;
	private String bookName;
	private List<String> authorName;
	private String authorName1;

	public String getAuthorName1() {
		return authorName1;
	}
	public void setAuthorName1(String authName1) {
		this.authorName1 = authName1;
	}
	public List<String> getAuthorName() {
		return authorName;
	}
	public void setAuthorName(List<String> authorName) {
		this.authorName = authorName;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
