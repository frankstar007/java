/**
 * 
 */
package loginBean;

/**
 * @author frankstar
 * 业务逻辑组件LoginBean类
 */
public class LoginBean {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//处理用户登录的方法
	public boolean login(String username, String password) {
		boolean flag = false;
		if (username.equals("frankstar") && password.equals("frankstar")) {
			flag = true;
		}
		return flag;
	}

}
