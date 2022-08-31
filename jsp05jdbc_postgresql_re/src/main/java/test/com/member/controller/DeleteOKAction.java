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

public class DeleteOKAction {
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("num"));
		
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.delete(vo);
		System.out.println("result:"+result);
		
		if(result==1)
			response.sendRedirect("m_selectAll.do");
		else
			response.sendRedirect("m_update.do?num=" + request.getParameter("num"));
		
	}

}
