package com.l7.jdbc.book.daoimpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.l7.jdbc.book.connection.ConnectionManager;
import com.l7.jdbc.book.dao.BookDAO;
//import com.l7.jdbc.book.dto.Book;
import com.l7.jdbc.book.dto.Book;

public class BookDaoImpl implements BookDAO {

	Connection connect = null;
	Statement stmt = null, stmt2 = null, stmt3 = null, stmt4 = null, stmt5 = null;
	ResultSet foreign_idSet1, foreign_idSet2, read1, read2, create_view;
	int foreign_id1, foreign_id2;
	int i;
	Book bookObj = new Book();

	@Override
	public int createBook(String bookName, String authorName) throws IOException, SQLException {

		try {
			DataSource connectObj = ConnectionManager.getDataSource();
			connect = connectObj.getConnection();
			stmt = connect.createStatement();
			stmt2 = connect.createStatement();
			stmt3 = connect.createStatement();

			String sql1 = "INSERT INTO book(book_name) VALUES('" + bookName + "')";
			String sql2 = "INSERT INTO author(author_name) VALUES('" + authorName + "')";

			stmt.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
			foreign_idSet1 = stmt.getGeneratedKeys();
			stmt2.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);
			foreign_idSet2 = stmt2.getGeneratedKeys();
			if (foreign_idSet1.next() && foreign_idSet2.next()) {
				foreign_id1 = foreign_idSet1.getInt(1);
				foreign_id2 = foreign_idSet2.getInt(1);
				sql2 = "INSERT INTO book_author(book_id,author_id) VALUES(" + foreign_id1 + "," + foreign_id2 + ")";
				i = stmt3.executeUpdate(sql2);
			}
			if (i > 0)
				System.out.println("Insertion Successful");
		} finally {
			if (stmt != null && stmt2 != null) {
				stmt.close();
				stmt2.close();
			}
		}
		return i;
	}

	@Override
	public int updateBook(int bookId, String newBookName) throws SQLException, IOException {
		try {

			DataSource connectObj = ConnectionManager.getDataSource();
			connect = connectObj.getConnection();
			stmt = connect.createStatement();
			String sql1 = "UPDATE book SET book_name='" + newBookName + "' where book_id='" + bookId + "'";
			i = stmt.executeUpdate(sql1);
			if (i == 1)
				System.out.println("Book Updation Successful : 1 row affected");
			else
				System.out.println("0 rows affected");
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return i;
	}

	@Override
	public int deleteBook(int bookId) throws IOException, SQLException {
		try {
			DataSource connectObj = ConnectionManager.getDataSource();
			connect = connectObj.getConnection();
			stmt = connect.createStatement();
			stmt2 = connect.createStatement();
			stmt3 = connect.createStatement();
			stmt4 = connect.createStatement();
			stmt5 = connect.createStatement();

			String sql = "select book_id from book where book_id='" + bookId + "'";
			foreign_idSet1 = stmt.executeQuery(sql);
			if (foreign_idSet1.next())
				foreign_id1 = foreign_idSet1.getInt("book_id");
			else {
				System.out.println("No rows for the Input");
				System.exit(0);
			}
			sql = "select author_id from book_author where book_id=" + foreign_id1;

			foreign_idSet2 = stmt2.executeQuery(sql);
			foreign_idSet2.next();
			foreign_id2 = foreign_idSet2.getInt("author_id");
			sql = "delete from book_author where book_id=" + foreign_id1;

			stmt3.executeUpdate(sql);
			String sql2 = "delete from book where book_id='" + bookId + "'";

			stmt4.executeUpdate(sql2);
			sql2 = "delete from author where author_id=" + foreign_id2;

			int i = stmt5.executeUpdate(sql2);
			if (i == 0)
				System.out.println("deletion unsuccessful");
			else
				System.out.println(i + " rows affected");
		} finally {
			if (stmt != null && stmt2 != null) {
				stmt.close();
				stmt2.close();
			}
		}
		return i;
	}

	@Override
	public void readBook(String bookName) throws IOException, SQLException {
		try {
			DataSource connectObj = ConnectionManager.getDataSource();
			connect = connectObj.getConnection();
			stmt = connect.createStatement();
			stmt2 = connect.createStatement();
			String sql1 = "select book_id,book_name from book where book_name='" + bookName + "'";

			read1 = stmt.executeQuery(sql1);
			int id1 = 0, id2 = 0;
			if (read1.next()) {
				id1 = read1.getInt("book_id");
				String sql2 = "select author_id from book_author where book_id=" + id1;
				read2 = stmt2.executeQuery(sql2);
				read2.next();
				id2 = read2.getInt("author_id");
				String sql3 = "select author_name from author where author_id=" + id2;
				read2 = stmt2.executeQuery(sql3);
				read2.next();
				String dupBookName = read1.getString("book_name");
				String authorName = read2.getString("author_name");
				System.out.println("");
				System.out
						.println("id: " + id1 + "\n" + "BookName: " + dupBookName + "\n" + "authorName: " + authorName);
			} else
				System.out.println("Not Found in DB");
		} finally {
			if (stmt != null && stmt2 != null) {
				stmt.close();
				stmt2.close();
			}
		}
	}

	public List<Book> getAllBooks() throws SQLException {
		// TODO Auto-generated method stub
		DataSource connectObj = ConnectionManager.getDataSource();
		connect = connectObj.getConnection();
		stmt = connect.createStatement();
		String sql2 = "select book.book_id,book.book_name,author.author_name from book INNER JOIN book_author ON book.book_id=book_author.book_id INNER JOIN author ON book_author.author_id=author.author_id";
		create_view = stmt.executeQuery(sql2);
		List<Book> bookList = new ArrayList<Book>();
		while (create_view.next()) {
			Book bookObj1 = new Book();
			bookObj1.setBookId(create_view.getInt("book_id"));
			bookObj1.setBookName(create_view.getString("book_name"));
			bookObj1.setAuthorName1(create_view.getString("author_name"));
			bookList.add(bookObj1);
		}
		return bookList;
	}

}
