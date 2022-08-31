package test.com.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.member.model.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/m_insert.do", "/m_insertOK.do", "/m_update.do", "/m_updateOK.do", "/m_delete.do", "/m_deleteOK.do",
		"/m_selectAll.do", "/m_selectOne.do", "/m_searchList.do" })
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sPath = request.getServletPath();

		System.out.print("doGet():");
		System.out.println(sPath);
		if (sPath.equals("/m_insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/insert.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_selectAll.do")) {
			new SelectAllAction().execute(request, response);
		} else if (sPath.equals("/m_update.do")) {
			new UpdateAction().execute(request, response);
		} else if (sPath.equals("/m_delete.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/delete.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/m_selectOne.do")) {
			new SelectOneAction().execute(request, response);
		} else if (sPath.equals("/m_searchList.do")) {
			new SearchListAction().execute(request, response);
		} else if (sPath.equals("/m_insertOK.do")) {
			response.sendRedirect("m_insert.do");
		} else if (sPath.equals("/m_deleteOK.do")) {
			new DeleteOKAction().execute(request, response);
		}

	}// end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();

		System.out.print("doPost():");
		System.out.println(sPath);
		if (sPath.equals("/m_insertOK.do")) {
			new InsertOKAction().execute(request, response);
		} else if (sPath.equals("/m_updateOK.do")) {
			new UpdateOKAction().execute(request, response);
		}

	}// end doPost

}
