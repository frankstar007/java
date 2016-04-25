package com.frankstar.mybatis.inter;

import com.frankstar.mybatis.model.User;
import java.util.List;

public interface IUserOperation {
	public User selectUserByID(int id);
	public List<User> selectUsers(String userName);

}
