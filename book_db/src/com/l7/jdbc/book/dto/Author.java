package com.l7.jdbc.book.dto;
import java.util.*;
public class Author {
	private List<Book> bookName;
	private int authorId;
	private String authorName;
	
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public List<Book> getBookName() {
		return bookName;
	}
	public void setBookName(List<Book> bookName) {
		this.bookName = bookName;
	}

	
}
