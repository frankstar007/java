package com.frankstar.mybatis.inter;

import com.frankstar.mybatis.model.Article;
import com.frankstar.mybatis.model.User;
import java.util.List;

public interface IUserOperation {
	public User selectUserByID(int id);
	public List<User> selectUsers(String userName);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<Article> getUserArticles(int userid);

}
