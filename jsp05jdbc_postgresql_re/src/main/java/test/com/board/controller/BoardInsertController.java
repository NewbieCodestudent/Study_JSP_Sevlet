package test.com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet({ "/b_insert.do", "/b_insertOK.do" })
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet:" + sPath);

		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("user_id:"+user_id);
		if(user_id != null) {
			request.getRequestDispatcher("board/insert.jsp").forward(request, response);
		}else {
			response.sendRedirect("login.do");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doPost:" + sPath);

		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("writer"));

		BoardDAO dao = new BoardDAOimpl();

		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		int result = dao.insert(vo);
		System.out.println("result:" + result);

		if(result==1)
			response.sendRedirect("b_selectAll.do");
		else 
			response.sendRedirect("b_insert.do");

	}// end doPost

}
