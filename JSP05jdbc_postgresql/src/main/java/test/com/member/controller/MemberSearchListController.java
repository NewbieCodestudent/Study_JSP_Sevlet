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

@WebServlet({"/m_searchList.do", "/m_Mater_searchList.do"})
public class MemberSearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSearchListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPath = request.getServletPath();
		System.out.println("doGet : " + sPath);

		String searchKey = request.getParameter("searchKey");
		String searchWord = request.getParameter("searchWord");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		MemberDAO dao = new MemberDAOimpl();
		
		List<MemberVO> vos = dao.searchList(searchKey, searchWord);
		System.out.println("vos.size():" + vos.size());
		
		request.setAttribute("vos", vos);
		
		if (sPath.equals("/m_searchList.do")) {
			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
		} else if (sPath.equals("/m_Mater_searchList.do")) {
			request.getRequestDispatcher("member/Master_selectAll.jsp").forward(request, response);
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}// end doPost

}
