package com.frankstar.servlet.study;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo3
 */
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("refresh", "5");
		//内存中创建一张图片
		BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		//得到图片
		Graphics2D graphics2d = image.createGraphics();
		graphics2d.setBackground(Color.WHITE);//设置图片的背景色;
		graphics2d.fillRect(0, 0, 80, 20);//填充背景色
		//向图片上写数据
		graphics2d.setColor(Color.BLUE);//图片上的字体颜色
		graphics2d.setFont(new Font(null, Font.BOLD, 15));
		graphics2d.drawString(makeNum(), 0, 20);
		//设置相应头控制浏览器以图片的方式打开
		response.setContentType("image/jpeg");
		//设置响应头控制浏览器不要缓存图片数据
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//将图片写给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}

	private String makeNum() {
		// TODO Auto-generated method stub
		Random random = new Random();
		String num = random.nextInt(9999999) + "";
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 7 - num.length(); i++) {
			stringBuffer.append("0");
		}
		num = stringBuffer.toString() + num;
		return num;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
