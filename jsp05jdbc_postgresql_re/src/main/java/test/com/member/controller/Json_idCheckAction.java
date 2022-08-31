package test.com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberDAOimpl;
import test.com.member.model.MemberVO;

public class Json_idCheckAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("id"));
	    
		MemberDAO dao = new MemberDAOimpl();
	    MemberVO vo = new MemberVO();
	    vo.setId(request.getParameter("id"));
		
	    MemberVO vo2 = dao.idCheck(vo);
	    System.out.println("idCheck:"+vo2);
	    
	    
	    response.addHeader("Access-Control-Allow-Origin", "*");
	    response.addHeader("Access-Control-Allow-Credentials", "true");
	    
	    PrintWriter out = response.getWriter();
	    if(vo2 != null){
	    	out.print("{\"result\":\"Not OK\"}");
	    }else{
	    	out.print("{\"result\":\"OK\"}");
	    }
	}

}
