package test.com.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class SelectAllAction {
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("user_id:"+user_id);
		if(user_id != null) {
			MemberDAO dao = new MemberDAOimpl();
			
			List<MemberVO> vos = dao.selectAll();
			System.out.println("vos.size():"+vos.size());
			
			request.setAttribute("vos", vos);
			
			for (MemberVO x : vos) {
				System.out.println(x);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("member/selectAll.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("login.do");
		}
		
	}

}
