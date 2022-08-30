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

@WebServlet({"/m_update.do", "/m_updateOK.do"})
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		request.getRequestDispatcher("member/update.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		if(sPath.equals("/m_updateOK.do")) {
			
			MemberDAO dao = new MemberDAOimpl();
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			int result = dao.update(vo);
			
			System.out.println("result : " + result);
			
			if(result==1) response.sendRedirect("m_selectAll.do");
			else response.sendRedirect("m_update.do");
		} 
		
		
	}// end doPost

}
