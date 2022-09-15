package test.com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.student.studentDAO;
import test.com.student.studentDAOimpl;
import test.com.student.studentVO;

public class Insert_studentOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("insertOKAction");
		studentDAO dao = new studentDAOimpl();
		studentVO vo = new studentVO();
		
		vo.setStudent_name(request.getParameter("student_name"));
		vo.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		vo.setMajor_id(Integer.parseInt(request.getParameter("major_id")));
		vo.setStudent_credit(Integer.parseInt(request.getParameter("student_credit")));
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		if(result ==1) response.sendRedirect("student.do");
		else response.sendRedirect("insert_student.do");
		
		
	}

}
