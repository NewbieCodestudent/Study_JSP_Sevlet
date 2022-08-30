package test.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/index.do", "/login.do", "/loginOK.do", "/join.do", "/logout.do"})
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if(sPath.equals("/index.do")) {

			// 서버에 저장하여 로그인을 유지하는 방법...
			ServletContext app = request.getServletContext();
			System.out.println(app.getRealPath("board"));
			// 작업하는 파일경로가 아닌 서버파일경로
			// realPath 경로 : C:\golfzon\JSP_Servlet\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps
			
			app.setAttribute("player_name", "king1004");
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/login.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/join.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/logout.do")) {
			
			HttpSession session = request.getSession();
			session.removeAttribute("user_id");
			
			response.sendRedirect("index.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doPost : " + sPath);
		// session 브라우저 단위 정보유지(로그인 유지기능 등...)
		if(sPath.equals("/loginOK.do")) {
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pw"));
			
			String user_id = request.getParameter("id");
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(5);  // ()의 초동안 동작하지 않으면 자동로그아웃
			session.setAttribute("user_id", user_id);
			
			response.sendRedirect("selectAll.do");
		}
	}

}
