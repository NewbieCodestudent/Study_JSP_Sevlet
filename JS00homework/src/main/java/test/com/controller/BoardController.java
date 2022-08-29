package test.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.controller.BoardVO;
import test.com.controller.BoardDAO;
import test.com.controller.BoardDAOimpl;

@WebServlet({"/insert.do", "/selectAll.do", "/selectOne.do", "/insertOK.do", "/update.do", "/updateOK.do", "/delete.do", "/deleteOK.do", "/searchList.do"})
public class BoardController extends HttpServlet {
	
	BoardDAO dao = new BoardDAOimpl();
	BoardVO vo = new BoardVO();
	List<BoardVO> vos = dao.boardDummy();
	
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("sPath : " + sPath);
		
		if (sPath.equals("/index.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/selectAll.do")) {
			
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/selectOne.do")) {
			
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/insertOK.do")) {
			System.out.println("sPath : " + sPath);
			System.out.println("NUM:" + request.getParameter("num")+" TITLE:"+request.getParameter("title")+" CONTENT:"+request.getParameter("content")+" WRITER:"+request.getParameter("writer"));
			response.sendRedirect("selectAll.do");
		} else if (sPath.equals("/update.do")) {
			
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/updateOK.do")) {
			System.out.println("sPath : " + sPath);
			System.out.println("NUM:" + request.getParameter("num")+" TITLE:"+request.getParameter("title")+" CONTENT:"+request.getParameter("content")+" WRITER:"+request.getParameter("writer"));
			response.sendRedirect("selectAll.do");
		} else if (sPath.equals("/delete.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
			rd.forward(request, response);
		} else if (sPath.equals("/deleteOK.do")) {
			System.out.println("sPath : " + sPath);
			response.sendRedirect("selectAll.do");
		} else if (sPath.equals("/searchList.do")) {
			System.out.println("searchKey : " + request.getParameter("searchKey") +
					   " searchWord : " + request.getParameter("searchWord"));
			
			List<BoardVO> vos = new ArrayList<BoardVO>();
			for (int i = 0; i < 10; i+=2) {
				BoardVO vo = new BoardVO();
				vo.setNum(i+1);
				vo.setTitle("java" + (i+1));
				vo.setContent("JSP_homework" + (i+1));
				vo.setWriter("lee" + (i+1));
				vos.add(vo);
			}
			
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
			rd.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
