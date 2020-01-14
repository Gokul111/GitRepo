package com.l7.jdbc.book.daoimpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.l7.jdbc.book.connection.ConnectionManager;
import com.l7.jdbc.book.dao.AuthorDAO;
import java.sql.ResultSet;

public class AuthorDaoImpl implements AuthorDAO{

	@Override
	public int updateAuthor(int bookId, String newAuthorName) throws SQLException, IOException {
		Connection connect;
		Statement stmt=null,stmt2=null;
		ResultSet foreign_idSet1;
		int foreign_id1,i=0;
		try {
			DataSource connectObj = ConnectionManager.getDataSource();
			connect = connectObj.getConnection();
			stmt = connect.createStatement();
			stmt2 = connect.createStatement();
			String sql = "SELECT author_id FROM book_author where book_id=" + bookId;
			foreign_idSet1 = stmt.executeQuery(sql);
			foreign_idSet1.next();
			foreign_id1 = foreign_idSet1.getInt("author_id");
			String sql1 = "UPDATE author SET author_name='" + newAuthorName + "' where author_id='" + foreign_id1 + "'";
			i = stmt2.executeUpdate(sql1);
			if (i == 1)
				System.out.println("Author Updation Successful : 1 row affected");
			else
				System.out.println("0 rows affected");
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			else if(stmt2!=null) {
				stmt2.close();
			}
		}
		return i;
	}

}
