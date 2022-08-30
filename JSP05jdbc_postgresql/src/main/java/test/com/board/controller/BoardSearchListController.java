package test.com.board.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

@WebServlet({"/searchList.do"})
public class BoardSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);

		String searchKey = request.getParameter("searchKey");
		String searchWord = request.getParameter("searchWord");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		BoardDAO dao = new BoardDAOimpl();
		
		List<BoardVO> vos = dao.searchList(searchKey, searchWord);
		System.out.println("vos.size():" + vos.size());
		
		request.setAttribute("vos", vos);
		
		request.getRequestDispatcher("board/selectAll.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}// end doPost

}
