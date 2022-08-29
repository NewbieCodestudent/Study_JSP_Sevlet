package test.com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.BoardVO;

@WebServlet({ "/delete.do", "/b_deleteOK.do", "/insert.do", "/b_insertOK.do", "/update.do", "/b_updateOK.do", "/selectAll.do", "/selectOne.do", "/searchList.do", "/joinOK.do" })
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if(sPath.equals("/insert.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/b_insertOK.do")) {
			response.sendRedirect("insert.do");
		} else if(sPath.equals("/update.do")) {
			if(request.getParameter("num") != null) {
				String num = request.getParameter("num");
				System.out.println(num);
				
				BoardVO vo2 = new BoardVO();
				vo2.setNum(Integer.parseInt(num));
				vo2.setTitle("title2");
				vo2.setContent("content2");
				vo2.setWriter("writer2");
				
				RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("selectAll.do");
			}
		} else if(sPath.equals("/delete.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/selectAll.do")) {
			
			List<BoardVO> vos = new ArrayList<BoardVO>();
			for (int i = 0; i < 10; i++) {
				BoardVO vo = new BoardVO();
				vo.setNum(i+1);
				vo.setTitle("title"+ (i+1));
				vo.setContent("content" + (i+1));
				vo.setWriter("writer" + (i+1));
				vo.setWdate(new Timestamp(System.currentTimeMillis()));
				vos.add(vo);
			}
			request.setAttribute("vos", vos);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/selectOne.do")) {
			
			BoardVO vo = new BoardVO();
			vo.setTitle("title");
			vo.setContent("content");
			vo.setWriter("writer");
			vo.setWdate(new Timestamp(System.currentTimeMillis()));
			
			request.setAttribute("vo", vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/searchList.do")) {
			
			List<BoardVO> vos = new ArrayList<BoardVO>();
			for (int i = 0; i < 10; i+=2) {
				BoardVO vo = new BoardVO();
				vo.setNum(i+1);
				vo.setTitle("title"+ (i+1));
				vo.setContent("content" + (i+1));
				vo.setWriter("writer" + (i+1));
				vo.setWdate(new Timestamp(System.currentTimeMillis()));
				vos.add(vo);
			}
			request.setAttribute("vos", vos);
			
			System.out.println(request.getParameter("searchKey"));
			System.out.println(request.getParameter("searchWord"));
			
			RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
			rd.forward(request, response);
		} else if(sPath.equals("/b_deleteOK.do")) {
			
			String num = request.getParameter("num");
			System.out.println(num);
			
			response.sendRedirect("selectAll.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doPost : " + sPath);
		if(sPath.equals("/b_insertOK.do")) {
			
			System.out.println(request.getParameter("title"));
			System.out.println(request.getParameter("content"));
			System.out.println(request.getParameter("writer"));
			
			response.sendRedirect("selectAll.do");
		} else if(sPath.equals("/b_updateOK.do")) {
			
			System.out.println(request.getParameter("title"));
			System.out.println(request.getParameter("content"));
			System.out.println(request.getParameter("writer"));
			
			response.sendRedirect("selectAll.do");
		} else if (sPath.equals("/joinOK.do")) {
			System.out.println("ID:" + request.getParameter("id")+" PW:"+request.getParameter("pw")+" NAME:"+request.getParameter("name")+" TEL:"+request.getParameter("tel"));
			response.sendRedirect("index.do"); 	
		}
	}

}