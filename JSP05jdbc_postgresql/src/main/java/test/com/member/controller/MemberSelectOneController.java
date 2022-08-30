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

@WebServlet({"/m_selectOne.do"})
public class MemberSelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelectOneController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
	    MemberVO vo = new MemberVO();
	    vo.setNum(Integer.parseInt(request.getParameter("num")));
	    
	    MemberDAO dao = new MemberDAOimpl();
	      
	    MemberVO vo2 = dao.selectOne(vo);
	    
	    request.setAttribute("vo2", vo2);

		request.getRequestDispatcher("member/selectOne.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}// end doPost

}
