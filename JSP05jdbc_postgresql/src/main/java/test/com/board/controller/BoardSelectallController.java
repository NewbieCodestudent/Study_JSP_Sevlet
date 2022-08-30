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

@WebServlet({"/b_selectAll.do"})
public class BoardSelectallController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSelectallController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		// DB 파일를 가져오는 방법
		BoardDAO dao = new BoardDAOimpl();
		
		List<BoardVO> vos = dao.selectAll();
		
		System.out.println("vos.size():" + vos.size());
		
		request.setAttribute("vos", vos);
		
		request.getRequestDispatcher("board/selectAll.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}// end doPost

}
