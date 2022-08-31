package test.com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet({ "/b_update.do", "/b_updateOK.do" })
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardUpdateController() {
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

		System.out.println(request.getParameter("num"));

		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));

		BoardDAO dao = new BoardDAOimpl();

		BoardVO vo2 = dao.selectOne(vo);
		System.out.println("vo2:" + vo2);

		request.setAttribute("vo2", vo2);

		request.getRequestDispatcher("board/update.jsp").forward(request, response);

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


		System.out.println(request.getParameter("num"));
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("writer"));

		BoardDAO dao = new BoardDAOimpl();

		BoardVO vo = new BoardVO();
		String num = request.getParameter("num");
		vo.setNum(Integer.parseInt(num));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setWriter(request.getParameter("writer"));
		int result = dao.update(vo);
		System.out.println("result:" + result);

		if (result == 1)
			response.sendRedirect("b_selectOne.do?num="+num);
		else
			response.sendRedirect("b_update.do?num="+num);

	}// end doPost

}
