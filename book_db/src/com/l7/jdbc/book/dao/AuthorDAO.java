package com.l7.jdbc.book.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface AuthorDAO {

	int updateAuthor(int bookId, String newAuthorName) throws SQLException, IOException;
}
