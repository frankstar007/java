/**
 * 
 */
package me.frankstar.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


/**
 * @author frankstar
 * 封装用户注册表单bean 用来接受register.jsp中表单输入项的值
 */
public class RegisterFormBean {
	private String userName;
	private String userPwd;
	private String confirmPwd;
	private String email;
	private String birthday;
	
	private Map<String, String> errors = new HashMap<String, String>();
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public boolean validate() {
		boolean isOk = true;
		
		if (this.getUserName() == null || this.getUserName().trim().equals("")) {
			isOk = false;
			errors.put("userName", "用户名不能为空！");
		} else {
			if (!this.getUserName().matches("[a-zA-Z]{3,8}")) {
				isOk = false;
				errors.put("userName", "用户名必须师3-8位的字母！");
			}
		}
		
		if (this.getUserPwd() == null || this.getUserPwd().trim().equals("")) {
			isOk = false;
			errors.put("userPwd", "密码不能为空！");
		} else {
			if (!this.getUserPwd().matches("\\d{3,8}")) {
				isOk = false;
				errors.put("userPwd", "密码必须师3-8位的数字！");
			}
		}
		if (this.getConfirmPwd() != null) {
			if (!this.getConfirmPwd().equals(this.getUserPwd())) {
				isOk = false;
				errors.put("confirmPwd", "两次密码不一致！");
			}
		}
		if (this.getEmail() != null || this.getEmail().trim().equals("")) {
			if (!this.getEmail().matches("\\w+@\\w+(\\.\\w+)+")) {
				isOk = false;
				errors.put("email", "邮箱不是一个合法邮箱！");
			}
		}
		if (this.getBirthday() != null && !this.getBirthday().trim().equals("")) {
			try {
				DateLocaleConverter converter = new DateLocaleConverter();
				converter.convert(this.getBirthday());
			} catch (Exception e) {
				isOk = false;
				errors.put("birthday", "生日必须是一个日期！");
			}
		}
		
		return isOk;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
