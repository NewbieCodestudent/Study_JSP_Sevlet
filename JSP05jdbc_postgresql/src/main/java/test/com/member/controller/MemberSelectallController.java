package test.com.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

@WebServlet({"/m_selectAll.do", "/m_Master_selectAll.do"})
public class MemberSelectallController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelectallController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);
		
		// DB 파일를 가져오는 방법
		MemberDAO dao = new MemberDAOimpl();
		List<MemberVO> vos = dao.selectAll();
		System.out.println("vos.size():" + vos.size());
		request.setAttribute("vos", vos);
		
		if (sPath.equals("/m_selectAll.do")) {
			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/m_Master_selectAll.do")) {
			request.getRequestDispatcher("member/Master_selectAll.jsp").forward(request, response);
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}// end doPost

}
