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

public class UpdateAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("num"));

		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));

		MemberDAO dao = new MemberDAOimpl();
		MemberVO vo2 = dao.selectOne(vo);

		request.setAttribute("vo2", vo2);

		RequestDispatcher rd = request.getRequestDispatcher("member/update.jsp");
		rd.forward(request, response);
	}

}
