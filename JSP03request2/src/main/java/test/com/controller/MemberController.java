package test.com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexController
 */
@WebServlet({"/m_insert.do", "/m_update.do", "/m_delete.do", "/m_selectAll.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);
		
		if(sPath.equals("/m_insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/insert.do");
			rd.forward(request, response);
		} else if(sPath.equals("/m_selectAll.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.do");
			rd.forward(request, response);
		} else if(sPath.equals("/m_delete.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/delete.do");
			rd.forward(request, response);
		} else if(sPath.equals("/m_update.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/update.do");
			rd.forward(request, response);
		}
		
		
		
	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
