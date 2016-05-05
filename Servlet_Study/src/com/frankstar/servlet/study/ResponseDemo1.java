package com.frankstar.servlet.study;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo1
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//outputChineseByOutputStream(response);
		//outputChineseByPrinterWriter(response);
		outputOneByOutputStream(response);
	}

	private void outputOneByOutputStream(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-type", "text/html;charset=UTF-8");;
		OutputStream outputStream = response.getOutputStream();
		outputStream.write("使用OutputStream输出数字".getBytes());
		outputStream.write((1 + "").getBytes());
		
	}

	private void outputChineseByPrinterWriter(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String data = "叶红星";
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		writer.write(data);
		
		
	}

	private void outputChineseByOutputStream(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String data = "李舒雅";
		OutputStream outputStream = response.getOutputStream();
		response.setHeader("content-type", "text/html;charset=UTF-8");
		byte[] dataByte = data.getBytes();
		outputStream.write(dataByte);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
