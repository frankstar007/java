package com.frankstar.servlet.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundFault;

/**
 * Servlet implementation class ResponseDemo2
 */
@WebServlet("/ResponseDemo2")
public class ResponseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//downloadFileByOutputStream(response);
		//downloadChineseFileByOutputStream(response);
		downloadFileByPrintWriter(response);
	}

	private void downloadFileByPrintWriter(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/download/叶红星.txt");
		String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		FileReader fileReader = new FileReader(realPath);
		int len = 0;
		char[] buffer = new char[1024];
		PrintWriter printWriter = response.getWriter();
		while ((len = fileReader.read(buffer)) > 0) {
			printWriter.write(buffer, 0, len);
		}
		fileReader.close();
	}

	private void downloadChineseFileByOutputStream(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/download/叶红星.txt");
		String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		InputStream inputStream = new FileInputStream(realPath);
		int len = 0;
		byte[] buffer = new byte[1024];
		OutputStream outputStream = response.getOutputStream();		
		while ((len = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		
	}

	private void downloadFileByOutputStream(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		//通过outputstream下载文件
		//1 获得下载的文件的绝对路径
		String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/download/yasuo.jpg");
		//2 获取下载的文件名
		String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
		//3 设置content-disposition相应头控制浏览器下载形式打开文件
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		//4 获取要下载的文件输入流
		InputStream inputStream = new FileInputStream(realPath);
		int len = 0;
		// 5 创建数据缓冲区
		byte[] buffer = new byte[1024];
		// 6 通过response对象获取Outputstream
		OutputStream outputStream = response.getOutputStream();
		// 7将file写入到buff缓冲去
		while ((len = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
