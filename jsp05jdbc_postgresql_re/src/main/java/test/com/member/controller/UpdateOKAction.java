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

public class UpdateOKAction {
	
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("num"));
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("tel"));
		
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setTel(request.getParameter("tel"));
		
		MemberDAO dao = new MemberDAOimpl();
		int result = dao.update(vo);
		System.out.println("result:"+result);
		
		if(result==1) response.sendRedirect("m_selectOne.do?num=" + request.getParameter("num"));
		else response.sendRedirect("m_update.do?num=" + request.getParameter("num"));
			
	}

}
