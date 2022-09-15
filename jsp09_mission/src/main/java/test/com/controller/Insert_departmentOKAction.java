package test.com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.department.departmentDAO;
import test.com.department.departmentDAOimpl;
import test.com.department.departmentVO;

public class Insert_departmentOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("insertOKAction");
		departmentDAO dao = new departmentDAOimpl();
		departmentVO vo = new departmentVO();
		
		vo.setDepartment_name(request.getParameter("department_name"));
		vo.setDepartment_number(request.getParameter("department_number"));
		
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		if(result ==1) response.sendRedirect("department.do");
		else response.sendRedirect("insert_department.do");
		
		
	}

}
