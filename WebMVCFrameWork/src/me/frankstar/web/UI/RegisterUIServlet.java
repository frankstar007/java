package me.frankstar.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * Servlet implementation class RegisterUIServlet
 */
@WebServlet("/RegisterUIServlet")
public class RegisterUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 为用户提供注册的界面Servlet
     * RegisterUIServlet负责为用户输出注册界面
     * 当用户访问该Servlet就会跳转到register.jsp
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		//System.out.println(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
