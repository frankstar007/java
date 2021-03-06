/**
 * 
 */
package me.frankstar.service;

import me.frankstar.domain.User;
import me.frankstar.exception.UserExistException;

/**
 * @author frankstar
 *@function service层对web层提供所有的业务服务
 */
public interface IUserService {
	//提供注册服务
	void registerUser(User user) throws UserExistException;
	//提供登陆服务
	User loginUser(String userName, String userPwd);
}
