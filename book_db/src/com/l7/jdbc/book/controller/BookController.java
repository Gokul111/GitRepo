//package com.l7.jdbc.book.controller;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.l7.jdbc.book.service.BookService;
//
//public class BookController {
//	public static void main(String[] args) {
//		String bookName=null,authorName=null,newBookName=null,newAuthorName=null;
//		
//		BookController controlObj=new BookController();
//		System.out.println("Create(1)\tUpdate(2)\tRead(3) \tDelete(4)");
//		Scanner s1=new Scanner(System.in);
//		BufferedReader s=new BufferedReader(new InputStreamReader(System.in));
//		try {
//		int choice=s1.nextInt();
//		switch(choice) {
//		case 1: System.out.println("Enter Bookname and Authorname to insert line by line:");
//				bookName=s.readLine();
//				authorName=s.readLine();
//				controlObj.createBook(bookName,authorName);
//				break;
//		case 2:	System.out.println("Book(0) or author(1): ");
//				int choice_inner=s.read();
//				if(choice_inner==0) {
//					System.out.println("Enter Existing Bookname and new Bookname line by line: ");
//					bookName=s.readLine();
//					newBookName=s.readLine();
//					controlObj.updateBook(bookName,newBookName);
//				}
//				else if(choice_inner==1) {
//					System.out.println("Enter Existing Authorname and new Authorname line by line: ");
//					bookName=s.readLine();
//					newAuthorName=s.readLine();
//					controlObj.updateAuthor(bookName,newAuthorName);
//				}
//				else
//					System.out.println("Invalid Input!!");
//				break;
//		case 3:	System.out.println("Input Bookname for which details are to be fetched: ");
//				bookName=s.readLine();
//				controlObj.readBook(bookName);
//				break;
//		case 4: System.out.println("Input Bookname to be deleted: ");
//				bookName=s.readLine();
//				controlObj.deleteBook(bookName);
//				break;
//		default: System.out.println("Invalid");
//				break;
//		}
//		s1.close();
//		s.close();
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public void createBook(String bookName,String authorName) {
//		BookService serviceObj=new BookService();
//		try {
//			serviceObj.createBook(bookName, authorName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public  void deleteBook(String bookName) {
//		BookService serviceObj=new BookService();
//		try {
//			serviceObj.deleteBook(bookName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public  void readBook(String bookName) {
//		BookService serviceObj=new BookService();
//		try {
//			serviceObj.readBook(bookName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	public void updateBook(String bookName,String newBookName) {
//		BookService serviceObj=new BookService();
//		try {
//			serviceObj.updateBook(bookName,newBookName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void updateAuthor(String authorName,String newAuthorName) {
//		BookService serviceObj=new BookService();
//		try {
//			serviceObj.updateAuthor(authorName,newAuthorName);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
