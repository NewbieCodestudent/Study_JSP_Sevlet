package test.com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

@WebServlet({"/selectOne.do"})
public class BoardSelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSelectOneController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
//	    System.out.println(request.getParameter("num"));
	      
	    BoardVO vo = new BoardVO();
	    vo.setNum(Integer.parseInt(request.getParameter("num")));
	    
//	    System.out.println(vo.getNum());
	    
	    BoardDAO dao = new BoardDAOimpl();
	      
	    BoardVO vo2 = dao.searchOne(vo);
//	    System.out.println("vo2:"+vo2);
	    
	    request.setAttribute("vo2", vo2);

		request.getRequestDispatcher("board/selectOne.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}// end doPost

}
