package test.com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.major.majorDAO;
import test.com.major.majorDAOimpl;
import test.com.major.majorVO;

public class Insert_majorOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("insert_majorOKAction");
		majorDAO dao = new majorDAOimpl();
		majorVO vo = new majorVO();
		
		vo.setMajor_name(request.getParameter("major_name"));
		vo.setMin_credit(Integer.parseInt(request.getParameter("min_credit")));
		vo.setMax_credit(Integer.parseInt(request.getParameter("max_credit")));
		
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		if(result ==1) response.sendRedirect("major.do");
		else response.sendRedirect("insert_major.do");
		
		
	}

}
