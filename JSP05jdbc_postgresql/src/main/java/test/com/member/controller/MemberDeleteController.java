package test.com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

@WebServlet({"/m_delete.do", "/m_deleteOK.do"})
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if (sPath.equals("/m_delete.do")) {
			
			request.getRequestDispatcher("member/delete.jsp").forward(request, response);
			
		} else if(sPath.equals("/m_deleteOK.do")) {
			
			MemberDAO dao = new MemberDAOimpl();
			MemberVO vo = new MemberVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			int result = dao.delete(vo);
			
			System.out.println("result : " + result);
			
			if(result==1) response.sendRedirect("m_selectAll.do");
			else response.sendRedirect("m_delete.do");
		} 
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}// end doPost

}
