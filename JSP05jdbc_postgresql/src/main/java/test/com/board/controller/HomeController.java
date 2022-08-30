package test.com.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/home.do", "/login.do", "/loginOK.do", "/logout.do"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if (sPath.equals("/home.do")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if(sPath.equals("/login.do")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if(sPath.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user_id");
			
			response.sendRedirect("home.do");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doPost : " + sPath);
		if(sPath.equals("/loginOK.do")) {
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pw"));
			
			String user_id = request.getParameter("id");
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(5);
			session.setAttribute("user_id", user_id);
			
			response.sendRedirect("b_selectAll.do");
		}
	}

}
