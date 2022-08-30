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

@WebServlet({"/b_delete.do", "/b_deleteOK.do"})
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if (sPath.equals("/b_delete.do")) {
			
			request.getRequestDispatcher("board/delete.jsp").forward(request, response);
			
		} else if(sPath.equals("/b_deleteOK.do")) {
			
			BoardDAO dao = new BoardDAOimpl();
			BoardVO vo = new BoardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			int result = dao.delete(vo);
			
			System.out.println("result : " + result);
			
			if(result==1) response.sendRedirect("b_selectAll.do");
			else response.sendRedirect("b_delete.do");
		} 
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}// end doPost

}
