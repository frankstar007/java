/**
 * 
 */
package com.frankstar.study.servlet3;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import java.io.FileReader;

/**
 * @author frankstar
 * 数据库中插入大数据
 */
public class JdbcOperClob {
	public void add() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		Reader reader = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into bigdata(resume) values(?)";
			pStatement = connection.prepareStatement(sql);
			String path = JdbcOperClob.class.getClassLoader().getResource("data.txt").getPath();
			path = path.replaceAll("%20", " ");
			File file = new File(path);
			reader = new FileReader(file);
			pStatement.setCharacterStream(1, reader, (int) file.length());
			int num = pStatement.executeUpdate();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
}
