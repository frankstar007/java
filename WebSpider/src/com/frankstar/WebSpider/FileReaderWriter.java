/**
 * 
 */
package com.frankstar.WebSpider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author frankstar
 * @function 读写文件
 */
public class FileReaderWriter {
	public static boolean createNewfile(String filePath) {
		boolean isSuccess = true;
		String filePathTurn = filePath.replace("\\\\", "/");
		//先过滤掉文件名
		int index = filePathTurn.lastIndexOf("/");
		String dir = filePathTurn.substring(0, index);
		//在创建文件夹
		File fileDir = new File(dir);
		isSuccess = fileDir.mkdirs();
		//创建文件
		File file = new File(filePathTurn);
		try {
			isSuccess = file.createNewFile();
		} catch(IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}
	public static boolean writeIntoFile(String content,String filePath, boolean isAppend) {
		boolean isSuccess = true;
		//先过滤掉文件名
		int index = filePath.lastIndexOf("/");
		String dir = filePath.substring(0, index);
		//创建文件路径
		File fileDir = new File(dir);
		fileDir.mkdirs();
		//创建文件
		File file = null;
		try {
			file = new File(filePath);
			file.createNewFile();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		//写入文件
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, isAppend);
			fw.write(content);
			fw.flush();
		} catch(IOException e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}  
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isSuccess;
		
	}

}
