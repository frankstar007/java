/**
 * 
 */
package loginAction;

import loginBean.LoginBean;

/**
 * @author frankstar
 * 处理视图业务落，一般一个视图对应一个业务逻辑控制器
 */
public class LoginAction {
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
	public String execute() throws Exception {
		LoginBean loginBean = new LoginBean();
		if (loginBean.login(username, password)) {
			return "success";
		} else {
			return "error";
		}
	}


}
