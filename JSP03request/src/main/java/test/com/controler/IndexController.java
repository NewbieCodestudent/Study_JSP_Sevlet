package test.com.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({ "/index.do", "/login.do", "/loginOK.do", "/logout.do", "/join.do"})
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();
        System.out.println("IndexController");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);
		
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);	
		} else if (sPath.equals("/login.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if  (sPath.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user_id");
			
			response.sendRedirect("index.do");
		} else if(sPath.equals("/join.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/join.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
			rd.forward(request, response);
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
			session.setAttribute("user_id", user_id);
			
			response.sendRedirect("m_selectAll.do");
		}
	}

}
