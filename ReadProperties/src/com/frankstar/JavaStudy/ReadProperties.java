/**
 * 
 */
package com.frankstar.JavaStudy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Properties;

/**
 * @author frankstar
 *
 */
public class ReadProperties {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readPropertiesBygetResourceAsStream();
			System.out.println("");
			readPropertiesByInputStream();
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	private static void readPropertiesByInputStream() {
		// TODO Auto-generated method stub
		InputStream in1 = null;
		InputStream in2 = null;
		InputStream in3 = null;
		InputStream in4 = null;
		System.out.println("使用inputstream读取");
		
		try {
			in1 = new BufferedInputStream(new FileInputStream("src/jdbc.properties"));
			in2 = new BufferedInputStream(new FileInputStream("src/config/properties/test1.properties"));
			in3 = new BufferedInputStream(new FileInputStream("src/com/frankstar/JavaStudy/test2.properties"));
			in4 = new BufferedInputStream(new FileInputStream("config/config.properties"));
			
			Properties p = new Properties();
			System.out.println("<hr/>");
			p.load(in1);
			System.out.println("jdbc.properties:");
            System.out.println(String.format("jdbc.driver=%s",
                    p.getProperty("jdbc.driver")));// 这里的%s是java String占位符
            System.out.println(String.format("jdbc.url=%s",
                    p.getProperty("jdbc.url")));
            System.out.println(String.format("jdbc.usename=%s",
                    p.getProperty("jdbc.usename")));
            System.out.println(String.format("jdbc.password=%s",
                    p.getProperty("jdbc.password")));
            
            p.load(in2);
            System.out.println("test1.properties:name=" + p.getProperty("name")
            + ",age=" + p.getProperty("age"));
		    
            System.out.println("<hr/>");
		    p.load(in3);
		    System.out.println("test2.properties:name=" + p.getProperty("name")
		            + ",age=" + p.getProperty("age"));
		    
		    p.load(in4);
            System.out.println("config.properties:");
            System.out.println(MessageFormat.format("dbuser={0}",
                    p.getProperty("dbuser")));// {0}是一个java的字符串占位符
            System.out.println(MessageFormat.format("dbpassword={0}",
                    p.getProperty("dbpassword")));
            System.out.println(MessageFormat.format("database={0}",
                    p.getProperty("database")));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in1 != null) {
				try {
					in1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (in2 != null) {
				try {
					in2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (in3 != null) {
				try {
					in3.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (in4 != null) {
				try {
					in4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
	}

	private static void readPropertiesBygetResourceAsStream() {
		// TODO Auto-generated method stub
		// 使用getResourceAsStream方法读取properties
		InputStream in1 = ReadProperties.class.getClassLoader()
				.getResourceAsStream("config/properties/test1.properties");
		
		InputStream in2 = ReadProperties.class.getClassLoader()
				.getResourceAsStream("com/frankstar/JavaStudy/test2.properties");
		
		InputStream in3 = ReadProperties.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		
		InputStream in4 = ReadProperties.class.getClassLoader()
				.getResourceAsStream("config.config.properties");
		
		Properties p = new Properties();
		System.out.println("使用getResourceAsStream方法读取properties");
		
		try {
			System.out.println("<hr/>");
			p.load(in1);
			System.out.println("test1.properties:name=" + p.getProperty("name")
					+ ",age=" + p.getProperty("age"));
			System.out.println("---test2---");
			System.out.println("<hr/>");
			p.load(in2);
			System.out.println("test2.properties:name=" + p.getProperty("name")
					+ ",age=" + p.getProperty("age"));
			System.out.println("---jdbc---");
			System.out.println("<hr/>");
			p.load(in3);
			System.out.println(MessageFormat.format("jdbc.properties:jdbc.driver={0},jdbc.url={1}"
					+ ",jdbc.username={2},jdbc.password={3}", p.getProperty("jdbc.driver"), p.getProperty("jdbc.url")
					, p.getProperty("jdbc.username"), p.getProperty("jdbc.password")));
//			System.out.println("---config---");
//			System.out.println("<hr/>");
//			//p.load(in4);
//			System.out.println("config.properties:dbuser=" + p.getProperty("dbuser")
//					+ ",dbpassword=" + p.getProperty("dbpassword") + p.getProperty("database"));
//			System.out.println("<hr/>");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in1 != null) {
				try {
					in1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in2 != null) {
				try {
					in2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in3 != null) {
				try {
					in3.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in4 != null) {
				try {
					in4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		}
	}
}	
