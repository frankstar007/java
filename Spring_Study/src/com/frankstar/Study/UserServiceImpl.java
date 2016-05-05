package com.frankstar.Study;

import com.frankstar.Spring.UserDAO;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	@Override
	public void show() {
		// TODO Auto-generated method stub
		userDAO.show();
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
