/**
 * 
 */
package me.frankstar.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;
import me.frankstar.dao.IUserDao;
import me.frankstar.domain.User;
import me.frankstar.util.XMLUtils;

/**
 * @author frankstar
 * 具体实现数据访问接口中的定义
 */
public class UserDaoImpl implements IUserDao{

	@Override
	public User find(String userName, String userPwd) {
		try {
			Document document = XMLUtils.getOwnerDocument();
			//使用XPath表达式来操作XML节点
			Element element = (Element) document.selectSingleNode("//user[@userName='"+userName+"' and @userPwd='"+userPwd+"']");
			if (element == null) {
				return null;
			}
			
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setEmail(element.attributeValue("email"));
			user.setUserName(element.attributeValue("userName"));
			user.setUserPwd(element.attributeValue("userPwd"));
			String birth = element.attributeValue("birthday");
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sDateFormat.parse(birth));
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	@SuppressWarnings("deprecation")
	@Override
	public void add(User user) {
		try {
			Document document = XMLUtils.getDocument();
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("userName", user.getUserName());
			user_node.setAttributeValue("userPwd", user.getUserPwd());
			user_node.setAttributeValue("email", user.getEmail());
			
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user_node.setAttributeValue("birthday", sDateFormat.format(user.getBirthday()));
			XMLUtils.write2Xml();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User find(String userName) {
		try {
			Document document = XMLUtils.getDocument();
			Element element = (Element) document.selectSingleNode("//user[@userName='" + userName + "']");
			if (element == null) {
				return null;
			}
			User user = new User();
			user.setId(element.attributeValue("id"));
			user.setEmail(element.attributeValue("email"));
			user.setUserName(element.attributeValue("userName"));
			user.setUserPwd(element.attributeValue("userPwd"));
			
			String birth = element.attributeValue("birthday");
			SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sDateFormat.parse(birth));
			
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
