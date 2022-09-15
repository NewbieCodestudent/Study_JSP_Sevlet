package test.com.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.model.EmpDAO;
import test.com.model.EmpDAOimpl;
import test.com.model.EmpVO;

public class InsertOKAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("insertOKAction");
		EmpDAO dao = new EmpDAOimpl();
		EmpVO vo = new EmpVO();
		
		vo.setFirst_name(request.getParameter("first_name"));
		vo.setLast_name(request.getParameter("last_name"));
		vo.setSalary(Integer.parseInt(request.getParameter("salary")));
		vo.setJob_id(request.getParameter("job_id"));
		vo.setDepartment_id(request.getParameter("department_id"));
		
		System.out.println(vo);
		
		int result = dao.insert(vo);
		System.out.println(result);
		
		if(result ==1) response.sendRedirect("selectAll.do");
		else response.sendRedirect("insert.do");
		
		
	}

}
