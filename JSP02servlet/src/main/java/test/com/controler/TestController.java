package test.com.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestControler
 */
@WebServlet({ "/index.do", "/test.do", "/insert.do", "/selectAll.do" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        System.out.println("TestController()...");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.append("Served at: ");
//		out.append(request.getContextPath());
//		out.append(request.getServletPath());
//		response.getWriter().append("Served at: ").append(request.getContextPath()); 한줄로 정리
		
		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);
		
		// 각 경로에 따라 해당 경로로 연결해주기
		if(sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/test.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("test/test.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/selectAll.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
			rd.forward(request, response);
		}
		
	}//end doGet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}//end doPost()

}
