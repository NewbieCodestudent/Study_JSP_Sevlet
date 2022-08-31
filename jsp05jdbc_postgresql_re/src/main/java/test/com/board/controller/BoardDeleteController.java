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
 * Servlet implementation class BoardDeleteController
 */
@WebServlet({ "/b_delete.do", "/b_deleteOK.do" })
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardDeleteController() {
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

		if(sPath.equals("/b_delete.do")) {
			request.getRequestDispatcher("board/delete.jsp").forward(request, response);
		}else if(sPath.equals("/b_deleteOK.do")) {
			String num = request.getParameter("num");
			System.out.println(num);
			
			BoardDAO dao = new BoardDAOimpl();

			BoardVO vo = new BoardVO();
			vo.setNum(Integer.parseInt(num));
			
			int result = dao.delete(vo);
			if (result == 1)
				response.sendRedirect("b_selectAll.do");
			else
				response.sendRedirect("b_delete.do?num="+num);
			
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}// end doPost

}
