package test.com.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class SearchListAction {
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchKey = request.getParameter("searchKey");
		String searchWord = request.getParameter("searchWord");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		MemberDAO dao = new MemberDAOimpl();
		List<MemberVO> vos = dao.searchList(searchKey,searchWord);
		
		request.setAttribute("vos", vos);
		
		RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
		rd.forward(request, response);
	}

}
