/**
 * 
 */
package me.frankstar.service.impl;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import me.frankstar.dao.IUserDao;
import me.frankstar.dao.impl.UserDaoImpl;
import me.frankstar.domain.User;
import me.frankstar.exception.UserExistException;
import me.frankstar.service.IUserService;

/**
 * @author frankstar
 * 为IUserService接口提供具体的实现
 */
public class UserServiceImpl implements IUserService{
	
	private IUserDao UserDao = new UserDaoImpl();
	
	@Override
	public void registerUser(User user) throws UserExistException {
		// TODO Auto-generated method stub
		if (UserDao.find(user.getUserName()) != null) {
			throw new UserExistException("注册的用户名已存在！");
		}
		UserDao.add(user);
	}

	@Override
	public User loginUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		return UserDao.find(userName, userPwd);
	}

}
