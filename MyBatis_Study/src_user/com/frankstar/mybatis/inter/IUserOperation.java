package com.frankstar.mybatis.inter;

import com.frankstar.mybatis.model.User;

public interface IUserOperation {
	public User selectUserByID(int id);

}
