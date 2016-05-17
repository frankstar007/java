/**
 * 
 */
package com.frankstar.study.servlet3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import sun.security.krb5.internal.crypto.RsaMd5CksumType;


/**
 * @author frankstar
 * 通过PreparedStatement对象完成对数据库的操作
 */
public class JdbcPreparedStatement {
	public void insert() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		//获得数据库链接
		try {
			connection = JdbcUtils.getConnection();
			String sql = "insert into user(id,userName,userAge,userAddress) values(?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, 8);
			pStatement.setString(2, "李舒雅");
			pStatement.setInt(3, 26);
			pStatement.setString(4, "辽宁丹东");
			int num = pStatement.executeUpdate();
			if (num > 0) {
				System.out.println("插入成功！");
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
	public void delete() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "delete from user where id = ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, 6);
			int num = pStatement.executeUpdate();
			if (num > 0) {
				System.out.println("成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
	public void update() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try{
			connection = JdbcUtils.getConnection();
			String sql = "update user set userName=?,userAddress=? where id=?";
			pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, "舒雅");
		pStatement.setString(2, "南京");
		pStatement.setInt(3, 3);
		int num = pStatement.executeUpdate();
		if (num > 0) {
			System.out.println("成功！");
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
	public void find() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();
			String sql = "select * from user where id =?";
			pStatement = connection.prepareStatement(sql);
			pStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t"
						+ resultSet.getString(2) + "\t"
						+ resultSet.getString(3) + "\t"
						+ resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection, pStatement, resultSet);
		}
	}
}
