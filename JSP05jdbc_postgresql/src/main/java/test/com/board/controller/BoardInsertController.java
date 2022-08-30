package test.com.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

@WebServlet({"/b_insert.do", "/b_insertOK.do"})
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		request.getRequestDispatcher("board/insert.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if(sPath.equals("/b_insertOK.do")) {
			
			BoardDAO dao = new BoardDAOimpl();
			BoardVO vo = new BoardVO();
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));
			
			int result = dao.insert(vo);
			
			System.out.println("result : " + result);
			
			if(result==1) response.sendRedirect("b_selectAll.do");
			else response.sendRedirect("b_insert.do");
		} 
		
		
	}// end doPost

}
